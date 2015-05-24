/*
 * Copyright (c) 2015 Guillaume Hillairet.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Guillaume Hillairet - initial API and implementation
 *
 */
package org.emfjson.gwt.junit.server;

import org.eclipse.emf.common.util.URI;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class ModelHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 4629402018087311006L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		URI uri = URI.createURI(req.getRequestURI());
		String modelPath = uri.lastSegment();
		URL url = ModelHttpServlet.class.getResource("tests/" + modelPath);

		java.net.URI fileURI = null;
		try {
			fileURI = url.toURI();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		if (fileURI != null) {
			File file = new File(fileURI);
			FileReader reader = new FileReader(file);
			PrintWriter writer = resp.getWriter();

			try {
				int c = 0;
				while ((c = reader.read()) != -1) writer.write(c);
				resp.setContentType("application/json");
				resp.setContentLength((int) file.length());
			} finally {
				writer.flush();
				reader.close();
				writer.close();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		URI uri = URI.createURI(req.getRequestURI());
		ServletInputStream inStream = req.getInputStream();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int c;
		while ((c = inStream.read()) != -1) {
			out.write(c);
		}

		super.doPost(req, resp);
	}

}
