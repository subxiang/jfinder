package com.darkart.jfinder;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipNode extends FileNode {
	private final File resource;

	public ZipNode(File resource, TreeNode parent) {
		super(resource, parent);
		this.resource = resource;
	}

	@Override
	public List<TreeNode> getChildren() {
		try {
			List<TreeNode> nodes = new ArrayList<TreeNode>();
			ZipFile file = new ZipFile(resource);
			Enumeration<? extends ZipEntry> entries = file.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				nodes.add(JavaResourceFactory.getInstance().create(entry, this));
			}
			return nodes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
