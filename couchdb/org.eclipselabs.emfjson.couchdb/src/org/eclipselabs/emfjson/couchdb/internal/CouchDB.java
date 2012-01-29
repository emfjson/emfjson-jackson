/*******************************************************************************
 * Copyright (c) 2011 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Guillaume Hillairet - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.emfjson.couchdb.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.ws.http.HTTPException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.emf.common.util.URI;
import org.eclipselabs.emfjson.internal.EJsUtil;
import org.eclipselabs.emfjson.internal.JSONSave;

public class CouchDB {

	public static JsonNode getContent(URI uri) {
		HttpURLConnection connection;
		try {
			connection = getGetConnection(uri);
			if (connection.getResponseCode() == 200) {
				return getRootNode(connection.getInputStream());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static HttpURLConnection getGetConnection(URI uri) throws MalformedURLException, IOException {
		return (HttpURLConnection) new URL(uri.toString()).openConnection();
	}

	public static HttpURLConnection getConnection(URI uri, String type) throws MalformedURLException, IOException {
		final HttpURLConnection connection = (HttpURLConnection) new URL(uri.toString()).openConnection();

		connection.setDoOutput(true);
		connection.setRequestMethod(type);
		connection.setRequestProperty("Content-Type", "application/json");

		return connection;
	}

	public static boolean isCouchDbService(URI uri) {
		final URI baseURI = uri.trimSegments(uri.segmentCount());

		try {
			HttpURLConnection connection = getGetConnection(baseURI);
			InputStream inStream = connection.getInputStream();
			try {
				JsonNode node = getRootNode(inStream);
				JsonNode couchdbNode = node.findValue("couchdb");

				return couchdbNode != null; 
			} catch (Exception e){
				return false;
			} finally {
				inStream.close();
				connection.disconnect();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return false;
	}

	public static void createDataBase(URI uri) {
		HttpURLConnection connection;
		try {
			connection = (HttpURLConnection) new URL(uri.toString()).openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod(PUT);

			if(checkResponse(connection.getInputStream()) == 0) {
				throw new IllegalArgumentException("Could not create database on "+uri);
			}

			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int checkDataBase(URI uri) {
		final String[] segments = uri.segments();
		int result = 0;
		if (segments.length == 0) {
			throw new IllegalArgumentException();
		} else {
			String database = segments[0];
			URI baseURI = uri.trimSegments(uri.segmentCount());
			try {
				HttpURLConnection connection = getGetConnection(baseURI.appendSegment(allDbs));
				JsonNode node = getRootNode(connection.getInputStream());

				if (node != null) {
					if (node.isArray()) {
						for (Iterator<JsonNode> it = node.getElements(); it.hasNext() && result == 0;) {
							JsonNode n = it.next();

							if (database.equalsIgnoreCase(n.getTextValue())) {
								result = 1;
							}
						}
					}
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static URI getDocumentURI(URI baseURI, InputStream inStream) throws JsonParseException, JsonMappingException, IOException {
		final JsonNode rootNode = getRootNode(inStream);

		URI result = null;
		if (rootNode.isObject()) {
			JsonNode okNode = rootNode.findValue("ok");

			if (okNode.getBooleanValue()) {
				JsonNode idNode = rootNode.findValue("id");

				result = baseURI.appendSegment(idNode.getTextValue());
			}
		}
		return result;
	}

	public static String getLastRevisionID(URI uri) {
		try {
			HttpURLConnection connection = getGetConnection(uri);
			JsonNode node = getRootNode(connection.getInputStream());
			return node.findValue(rev).getTextValue();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static URI createOrUpdateDocument(URI uri, JSONSave writer, JsonNode current) {
		if (current.isArray() && current.getElements().hasNext()) {
			throw new IllegalArgumentException("Document Root must be an Object");
		}
		if (isUpdate(uri)) {
			return updateDocument(uri, writer, current);
		} else {
			return createDocument(uri, writer, current);
		}
	}

	public static void delete(URI uri) {
		if (checkDataBase(uri) == 1) {
			String[] segments = uri.segments();
			if (segments.length < 3) {
				HttpURLConnection connection;
				try {
					connection = getConnection(uri, DELETE);
					connection.connect();
					int code = connection.getResponseCode();
					if (code == 200) {
						connection.getInputStream();
					}
					connection.disconnect();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}

	private static URI updateDocument(URI uri, JSONSave writer, JsonNode current) {
		final String lastRevision = getLastRevisionID(uri);
		if (current.isObject()) {
			((ObjectNode)current).put(rev, lastRevision);
		}

		HttpURLConnection connection;
		try {
			connection = getConnection(uri, PUT);
			OutputStream output = null;
			try {
				output = connection.getOutputStream();
				writer.getDelegate().writeValue(output, current);
			} finally {
				if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
			}
			try {
				if (connection.getResponseCode() >= 400) {
					System.err.println(connection.getResponseMessage());
					System.err.println(getRootNode(connection.getErrorStream()));
					throw new HTTPException(connection.getResponseCode());
				} else {
					return uri;
				}
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return uri;
	}

	private static URI createDocument(URI uri, JSONSave writer, JsonNode current) {
		HttpURLConnection connection = null;
		try {
			connection = getConnection(uri, POST);
			OutputStream output = null;
			try {
				if (current != null && current.isObject()) {
					output = connection.getOutputStream();
					writer.getDelegate().writeValue(output, current);
				} else {
					output = connection.getOutputStream();
					writer.getDelegate().writeValue(output, emptyNode());
				}
			} finally {
				if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
			}
			try {
				if (connection.getResponseCode() >= 400) {
					System.err.println(connection.getResponseMessage());
					System.err.println(getRootNode(connection.getErrorStream()));
					throw new HTTPException(connection.getResponseCode());
				} else {
					return getDocumentURI(uri, connection.getInputStream());
				}
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static boolean isUpdate(URI uri) {
		if (uri.segmentCount() > 1) {
			try {
				HttpURLConnection connection = getGetConnection(uri);
				if (connection.getResponseCode() == 200) {
					return true;
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private static int checkResponse(InputStream inStream) {
		try {
			JsonNode node = getRootNode(inStream);
			if (node != null && node.isObject()) {
				return node.findValue("ok") != null ? 1 : 0;
			}
		} finally {
			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	private static JsonNode getRootNode(InputStream inStream) {
		final JsonParser parser = EJsUtil.getJsonParser(inStream);
		final ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(parser, JsonNode.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static JsonNode emptyNode() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.createObjectNode();
	}

	private static final String rev = "_rev";
	private static final String allDbs = "_all_dbs";
	private static final String POST = "POST";
	private static final String PUT = "PUT";
	private static final String DELETE = "DELETE";
}
