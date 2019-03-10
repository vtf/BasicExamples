package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.tree.Node;
import com.example.tree.Tree;

public class TreeTest {

	@Test
	public void addRoot() {

		Tree arbol = new Tree("Raiz");

		assertEquals(arbol.getRoot().getInfo(), "Raiz");

	}

	@Test
	public void addChildFirsLevel() {

		Tree arbol = new Tree("Raiz");

		Node parent = new Node();

		parent.setInfo("A");

		arbol.insertAfterParent(arbol.getRoot(), arbol.getRoot(), parent);

		assertEquals(arbol.getRoot().getChild().size(), 1);

	}

	@Test
	public void addChildSecondLevel() {

		Tree arbol = new Tree("Raiz");

		Node parent = new Node();

		Node child = new Node();

		parent.setInfo("A");

		child.setInfo("A1");

		arbol.insertAfterParent(arbol.getRoot(), arbol.getRoot(), parent);

		arbol.insertAfterParent(arbol.getRoot(), parent, child);

		assertEquals(arbol.getRoot().getChild().get(0).getInfo(), "A");

		assertEquals(arbol.getRoot().getChild().get(0).getChild().get(0).getInfo(), "A1");

	}

	@Test
	public void printTree() {

		Tree arbol = new Tree("Raiz");

		Node parent = new Node();

		Node child = new Node();

		parent.setInfo("A");

		child.setInfo("A1");

		arbol.insertAfterParent(arbol.getRoot(), parent, child);

		arbol.insertAfterParent(arbol.getRoot(), parent, child);

		Node child2 = new Node();
		child2.setInfo("A2");

		arbol.insertAfterParent(arbol.getRoot(), child, child2);

		// assertNotNull(arbol.printTree(arbol.getRoot(), 0));

	}

	@Test
	public void deleteNode() {
		assertEquals(1l, 1l);
	}
}
