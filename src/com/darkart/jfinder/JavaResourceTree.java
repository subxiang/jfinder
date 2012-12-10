package com.darkart.jfinder;

import java.io.File;

public class JavaResourceTree extends Graph {
	public JavaResourceTree(File resource) {
		super(JavaResourceFactory.getInstance().create(resource, null), new TreeNodeRetriever());
	}
}
