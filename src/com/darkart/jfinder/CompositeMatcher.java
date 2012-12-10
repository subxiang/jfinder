package com.darkart.jfinder;

import java.util.Iterator;
import java.util.List;

public class CompositeMatcher implements Matcher {
	private List<Matcher> matchers;
	
	public void setMatchers(List<Matcher> matchers) {
		this.matchers = matchers;
	}

	@Override
	public boolean match(List<Node> path, Node node) {
		boolean ret = false;
		Iterator<Matcher> iter = matchers.iterator();
		while (iter.hasNext() && !ret) {
			Matcher m = iter.next();
			ret = ret || m.match(path, node);
		}
		return ret;
	}

	@Override
	public void setQuery(String query) {
		// TODO Auto-generated method stub

	}

}
