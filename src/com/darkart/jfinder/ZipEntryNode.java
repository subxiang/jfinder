package com.darkart.jfinder;

import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;

public class ZipEntryNode extends TreeNode {
	private final ZipEntry entry;

	public ZipEntryNode(ZipEntry entry, TreeNode parent) {
		super(parent);
		this.entry = entry;
	}

	@Override
	public List<TreeNode> getChildren() {
		return Collections.emptyList();
	}

	@Override
	public String toString() {
		return entry.getName();
	}
}
