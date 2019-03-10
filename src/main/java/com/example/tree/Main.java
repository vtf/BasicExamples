package com.example.tree;

public class Main {

	public static void main(String[] args) {

		Tree arbol = new Tree("Raiz");
		
		Node parent = new Node();

		Node parent2 = new Node();
		
		Node child = new Node();

		Node childA22 = new Node();

		Node childB = new Node();
		
		parent.setInfo("A");
		
		child.setInfo("A1");
		
		childA22.setInfo("A22");
		

		parent2.setInfo("B");
		childB.setInfo("B1");
		

		
		arbol.insertAfterParent(arbol.getRoot(),arbol.getRoot(), parent);
		
		
		arbol.insertAfterParent(arbol.getRoot(),parent, child);
		
		
		Node child2 = new Node();
		child2.setInfo("A2"); 
		
		arbol.insertAfterParent(arbol.getRoot(),child, child2);
		

		arbol.insertAfterParent(arbol.getRoot(),parent, childA22);

		arbol.insertAfterParent(arbol.getRoot(),arbol.getRoot(), parent2);

		
		
		arbol.insertAfterParent(arbol.getRoot(),parent2, childB);
		
		arbol.printTree(arbol.getRoot(),0);
		
		
		
	}

}
