package com.darkart.jfinder;

import java.io.File;
import java.util.zip.ZipEntry;

public class ResourceNodeFactory {
	private static final ResourceNodeFactory instance = new ResourceNodeFactory();
	
	public static ResourceNodeFactory getInstance() {
		return instance;
	}
	
	public Node create(File resource, TreeNode parent) {
		Node node;
		if (resource.isDirectory()) {
			node = new FolderNode(resource, parent);
		} else {
			if (isZip(resource)) {
				node = new ZipNode(resource, parent);
			} else {
				node = new FileNode(resource, parent);
			}
		}
		return node;
	}

	private boolean isZip(File resource) {
		return resource.getName().matches("(?i:.+[.](jar|war|ear|zip))");
	}

	public TreeNode create(ZipEntry entry, TreeNode parent) {
		return new ZipEntryNode(entry, parent);
	}
}
