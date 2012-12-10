package com.darkart.jfinder;

public interface Traversable {
	public void traverse(Visitor visitor, Matcher ignore);
}
