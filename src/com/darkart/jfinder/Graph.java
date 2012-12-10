package com.darkart.jfinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Graph implements Traversable {
	private NodeRetriever retriever;
	private Node root;
	
	public Graph(Node root, NodeRetriever retriever) {
		this.root = root;
		this.retriever = retriever;
	}
	
	public List<Node> retrieve(Node n) {
		return retriever.retrieve(n);
	}
	
	@Override
	public void traverse(Visitor visitor, Matcher ignore) {
		Queue<Node> q = new LinkedList<Node>();
		Queue<List<Node>> paths = new LinkedList<List<Node>>();
		
		List<Node> p = Collections.singletonList(root);
		if (ignore == null || !ignore.match(p, root)) {
			q.add(root);
			paths.add(p);
			visitor.visit(p, root);
		}
		while (!q.isEmpty()) {
			Node node = q.remove();
			List<Node> path = paths.remove();
			List<Node> nodes = retrieve(node);
			
			for (Node n : nodes) {
				p = new ArrayList<Node>(path);
				p.add(n);
				if (ignore == null || !ignore.match(p, n)) {
					q.add(n);
					paths.add(p);
					visitor.visit(p, n);
				}
			}
		}
	}
}
