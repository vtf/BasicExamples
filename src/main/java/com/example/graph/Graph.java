package com.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

//algorithm: https://www.codingame.com/playgrounds/7656/los-caminos-mas-cortos-con-el-algoritmo-de-dijkstra/el-algoritmo-de-dijkstra

public class Graph {

	private List<NodeGraph> nodes = new ArrayList<NodeGraph>();

	public List<NodeGraph> getNodes() {
		return nodes;
	}

	public void setNodes(List<NodeGraph> nodes) {
		this.nodes = nodes;
	}

	// devuelve una lista de caminos minimos desde un nodo ciudad al resto.
	// Los camnios mas cortos del origen al resto
	public HashMap<NodeGraph, Integer> dijkstra(NodeGraph origin) {

		List<NodeGraph> noVisted = this.nodes;

		noVisted = deleteElements(noVisted, origin);

		HashMap<NodeGraph, Integer> totalWeight = new HashMap<NodeGraph, Integer>();
		totalWeight.put(origin, 0);

		// must be improved
		// nodos visitados y nodos revisar algoritmo. mieter cola de prioridad en vez de
		// eliminar elementos con una lista
		while (noVisted.size() > 0 && origin.getInfo() != null) {

			//Actualizo todas las distancias los posibles destinos
			updateTotalWeight(totalWeight, visitNeighbours(origin), origin);

			//Calculo el siguiente nodoa visitar (no visitado con menor distancia).
			origin = findNextNodeToVisit(origin, noVisted);

			noVisted = deleteElements(noVisted, origin);

		}
		return totalWeight;
	}

	private NodeGraph findNextNodeToVisit(NodeGraph origin, List<NodeGraph> noVisted) {

		int min = 1000;
		NodeGraph toret = new NodeGraph();

		if (origin.getEdges() != null) {
			for (int i = 0; i < origin.getEdges().size(); i++) {

				if (isNotVisted(noVisted, origin.getEdges().get(i).getDestiny())) {
					if (origin.getEdges().get(i).getDistance() < min) {
						min = origin.getEdges().get(i).getDistance();
						toret = origin.getEdges().get(i).getDestiny();
					}
				}
			}
		}

		return toret;
	}

	private boolean isNotVisted(List<NodeGraph> noVisted, NodeGraph node) {

		for (int i = 0; i < noVisted.size(); i++) {

			if (noVisted.get(i) == node) {
				return true;
			}
		}
		return false;

	}

	private HashMap<NodeGraph, Integer> updateTotalWeight(HashMap<NodeGraph, Integer> generalList,
			HashMap<NodeGraph, Integer> newList, NodeGraph origin) {

		if (newList != null) {
			for (Map.Entry<NodeGraph, Integer> entry : newList.entrySet()) {
				
				generalList.put(entry.getKey(), entry.getValue() + generalList.get(origin));
				Integer total = entry.getValue() + generalList.get(origin);
				System.out.println(entry.getKey().getInfo() + " " + total);

			}
		}
		return generalList;
	};

	private HashMap<NodeGraph, Integer> visitNeighbours(NodeGraph origin) {

		HashMap<NodeGraph, Integer> weight = new HashMap<NodeGraph, Integer>();

		if (origin.getEdges() != null) {
			for (int i = 0; i < origin.getEdges().size(); i++) {

				weight.put(origin.getEdges().get(i).getDestiny(), origin.getEdges().get(i).getDistance());
			}

		}
		return weight;

	}

	private List<NodeGraph> deleteElements(List<NodeGraph> listNodes, NodeGraph origin) {

		ListIterator<NodeGraph> iter = listNodes.listIterator();
		while (iter.hasNext()) {
			if (iter.next().equals(origin)) {
				iter.remove();
			}
		}
		return listNodes;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graph other = (Graph) obj;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		return true;
	}

}
