package com.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainGraph {

	public static void main(String[] args) {

		Graph graph = new Graph();

		NodeGraph madrid = new NodeGraph();
		madrid.setInfo("Madrid");
		
//		NodeGraph cuenca = new NodeGraph();
//		madrid.setInfo("Cuenca");

		NodeGraph barcelona = new NodeGraph();
		barcelona.setInfo("Barcelona");

		NodeGraph zaragoza = new NodeGraph();
		zaragoza.setInfo("Zaragoza");

		NodeGraph oviedo = new NodeGraph();
		oviedo.setInfo("Oviedo");

		// Oviedo Madrid distancia 500;
		Edge oviedoMadrid = new Edge();
		oviedoMadrid.setOrigin(oviedo);
		oviedoMadrid.setDestiny(madrid);
		oviedoMadrid.setDistance(400);

		Edge madridZaragoza = new Edge();
		madridZaragoza.setOrigin(madrid);
		madridZaragoza.setDestiny(zaragoza);
		madridZaragoza.setDistance(100);

		Edge zaragozaBarcelona = new Edge();
		zaragozaBarcelona.setOrigin(zaragoza);
		zaragozaBarcelona.setDestiny(barcelona);
		zaragozaBarcelona.setDistance(200);

		Edge oviedoZaragoza = new Edge();
		oviedoZaragoza.setOrigin(oviedo);
		oviedoZaragoza.setDestiny(zaragoza);
		oviedoZaragoza.setDistance(150);
		
//		Edge madridCuenca = new Edge();
//		madridCuenca.setOrigin(madrid);
//		madridCuenca.setDestiny(cuenca);
//		madridCuenca.setDistance(100);
		

		List<Edge> edgesOviedoMadrid = new ArrayList<Edge>();
		edgesOviedoMadrid.add(oviedoMadrid);
		edgesOviedoMadrid.add(oviedoZaragoza);
		oviedo.setEdges(edgesOviedoMadrid);

		List<Edge> edgesMadridZaragoza = new ArrayList<Edge>();
		edgesMadridZaragoza.add(madridZaragoza);
	//	edgesMadridZaragoza.add(madridCuenca);
		madrid.setEdges(edgesMadridZaragoza);

//		List<Edge> edgeszaragozaBarcelona = new ArrayList<Edge>();
//		edgeszaragozaBarcelona.add(zaragozaBarcelona);
//		zaragoza.setEdges(edgeszaragozaBarcelona);

		List<Edge> edgesZaragozaBarcelona = new ArrayList<Edge>();
		edgesZaragozaBarcelona.add(zaragozaBarcelona);
		zaragoza.setEdges(edgesZaragozaBarcelona);

		graph.getNodes().add(madrid);

		graph.getNodes().add(barcelona);

		graph.getNodes().add(zaragoza);

		graph.getNodes().add(oviedo);
		
		//graph.getNodes().add(cuenca);

		HashMap<NodeGraph, Integer> map = graph.dijkstra(oviedo);

		System.out.println("Fin");
	}

}
