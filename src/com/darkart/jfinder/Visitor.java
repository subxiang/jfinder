package com.darkart.jfinder;

import java.util.List;

public interface Visitor {
	public void visit(List<Node> path, Node node);
}
