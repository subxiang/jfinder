package com.darkart.jfinder;

import java.util.List;

public class FileNameMatcher implements Matcher {
	private String query;

	@Override
	public boolean match(List<Node> path, Node node) {
		String q = ".*" + query + ".*";
		return node.toString().matches(q);
	}

	public String getQuery() {
		return query;
	}
	
	@Override
	public void setQuery(String query) {
		this.query = query;
	}
}
