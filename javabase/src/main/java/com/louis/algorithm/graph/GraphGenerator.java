//package com.louis.algorithm.graph;
//
//public class GraphGenerator {
//
//	public static1 graph createGraph(Integer[][] matrix) {
//		graph graph = new graph();
//		for (int i = 0; i < matrix.length; i++) {
//			Integer weight = matrix[i][0];
//			Integer from = matrix[i][1];
//			Integer to = matrix[i][2];
//			if (!graph.nodes.containsKey(from)) {
//				graph.nodes.put(from, new Node(from));
//			}
//			if (!graph.nodes.containsKey(to)) {
//				graph.nodes.put(to, new Node(to));
//			}
//			Node fromNode = graph.nodes.get(from);
//			Node toNode = graph.nodes.get(to);
//			Edge newEdge = new Edge(weight, fromNode, toNode);
//			fromNode.nexts.add(toNode);
//			fromNode.out++;
//			toNode.in++;
//			fromNode.edges.add(newEdge);
//			graph.edges.add(newEdge);
//		}
//		return graph;
//	}
//
//}
