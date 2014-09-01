package org.eclipselabs.emfjson.junit.model.server;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.common.util.URI;

public class ModelHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 4629402018087311006L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		URI uri = URI.createURI(req.getRequestURI());
		String modelPath = uri.lastSegment();
		URL url = ModelHttpServlet.class.getResource("tests/"+modelPath);

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
				while((c = reader.read()) != -1) writer.write(c);
				resp.setContentType("application/json");
				resp.setContentLength((int) file.length());
			}
			finally {
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

		System.out.println(new String(out.toByteArray()));

		super.doPost(req, resp);
	}

}
