package com.darkart.jfinder;

import java.io.File;

public class ClasspathResource implements Traversable {
	private String[] pathElements;
	
	public ClasspathResource(String[] pathElements) {
		this.pathElements = pathElements;
	}

	@Override
	public void traverse(Visitor visitor, Matcher ignore) {
		for (String pathElement : pathElements) {
			File resource = new File(pathElement);
			new JavaResourceTree(resource).traverse(visitor, ignore);
		}
	}

}
