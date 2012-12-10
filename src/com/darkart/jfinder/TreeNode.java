package com.darkart.jfinder;

import java.util.List;

public abstract class TreeNode implements Node {
	private final TreeNode parent;
	
	public TreeNode(TreeNode parent) {
		this.parent = parent;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	
	public abstract List<TreeNode> getChildren();
}
