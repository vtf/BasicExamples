package com.example.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private Node root;


	public Tree(String info) {
		Node node = new Node();
		node.setInfo(info);
		root = node;

	}

	public void insertAfterParent(Node root, Node parent, Node child) {

		if (root.getInfo() == parent.getInfo() || root.getInfo().isEmpty()) {

			root.setChild(createChild(root, child));
		}

		else {

			if (root.getChild() != null) {
				for (Node n : root.getChild()) {
					insertAfterParent(n, parent, child);
				}
			}
		}

	}

	private List<Node> createChild(Node parent, Node child) {

		if (parent.getChild() != null) {
			parent.getChild().add(child);
			return parent.getChild();
		} else {
			List<Node> childs = new ArrayList<Node>();
			childs.add(child);
			return childs;
		}
	}

	public void printTree(Node nodo, Integer level) {

		presentateTree(nodo.getInfo(), level);

		if (nodo.getChild() != null) {
			for (Node n : nodo.getChild()) {
				printTree(n, level + 1);
			}

		}

	}

	public void presentateTree(String info, Integer level) {

		for (int i = 0; i < level; i++) {
			System.out.print(" ");
		}

		System.out.println("Level: " + level + " Info: " + info);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}
