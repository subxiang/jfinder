package com.darkart.jfinder;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeRetriever implements NodeRetriever {

	@Override
	public List<Node> retrieve(Node n) {
		List<Node> nodes = new ArrayList<Node>();
		nodes.addAll(((TreeNode)n).getChildren());
		return nodes;
	}

}
