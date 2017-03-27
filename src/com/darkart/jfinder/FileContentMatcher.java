package com.darkart.jfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class FileContentMatcher implements Matcher {
	private String query;

	@Override
	public boolean match(List<Node> path, Node node) {
		String q = ".*" + query + ".*";
		try {
			if (node instanceof FileNode) {
				File file = ((FileNode) node).getResource();
				BufferedReader reader = new BufferedReader(new FileReader(file));
				try {					
					for (String line; (line = reader.readLine()) != null; ) {
						if (line.matches(q)) {
							return true;
						}
					}
				} finally {
					reader.close();
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public void setQuery(String query) {
		this.query = query;
	}
	
	public String getQuery() {
		return query;
	}
}
