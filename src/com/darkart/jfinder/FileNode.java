package com.darkart.jfinder;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class FileNode extends TreeNode {
	private final File resource;

	public FileNode(File resource, TreeNode parent) {
		super(parent);
		this.resource = resource;
	}

	@Override
	public List<TreeNode> getChildren() {
		return Collections.emptyList();
	}
	
	@Override
	public String toString() {
		return resource.getName();
	}
	
	public File getResource() {
		return resource;
	}
}
