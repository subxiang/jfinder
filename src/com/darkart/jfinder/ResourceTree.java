package com.darkart.jfinder;

import java.io.File;

public class ResourceTree extends Graph {
	public ResourceTree(File resource) {
		super(ResourceNodeFactory.getInstance().create(resource, null), new TreeNodeRetriever());
	}
}
