package com.darkart.jfinder;

import java.util.List;

public interface Matcher {
	public boolean match(List<Node> path, Node node);
	public void setQuery(String query);
}
