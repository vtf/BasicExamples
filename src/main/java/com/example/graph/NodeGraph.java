package com.example.graph;

import java.util.List;

public class NodeGraph {
	
	
	private String info;
	private List<Edge> edges;

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
