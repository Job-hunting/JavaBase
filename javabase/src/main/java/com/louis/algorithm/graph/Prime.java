package com.louis.algorithm.graph;

public class Prime {
//    public static1 class EdgeComparator implements ComparatorUtils<Edge> {
//
//        @Override
//        public int compare(Edge o1, Edge o2) {
//            return o1.weight - o2.weight;
//        }
//
//    }
//
//    public static1 Set<Edge> primMST(graph graph) {
//        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
//                new EdgeComparator());
//        HashSet<Node> set = new HashSet<>();
//        Set<Edge> result = new HashSet<>();
//        for (Node node : graph.nodes.values()) {
//            if (!set.contains(node)) {
//                set.add(node);
//                for (Edge edge : node.edges) {
//                    priorityQueue.add(edge);
//                }
//                while (!priorityQueue.isEmpty()) {
//                    Edge edge = priorityQueue.poll();
//                    Node toNode = edge.to;
//                    if (!set.contains(toNode)) {
//                        set.add(toNode);
//                        result.add(edge);
//                        for (Edge nextEdge : toNode.edges) {
//                            priorityQueue.add(nextEdge);
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }

}
