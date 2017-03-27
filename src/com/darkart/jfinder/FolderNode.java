package com.darkart.jfinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderNode extends TreeNode {
	private final File resource;

	public FolderNode(File resource, TreeNode parent) {
		super(parent);
		this.resource = resource;
	}

	@Override
	public List<TreeNode> getChildren() {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		File[] files = resource.listFiles();
		for (File f : files) {
			nodes.add((TreeNode)ResourceNodeFactory.getInstance().create(f, this));
		}
		
		return nodes;
	}
	
	@Override
	public String toString() {
		return resource.getName();
	}
}
