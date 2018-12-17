package com.company.geeksForGeeks.graph;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.javafx.geom.Edge;

import java.util.*;

public class DijkstraDemo {
    public static void main(String[] args) {
        System.out.println("hello");

        //Wikipedia graph
        GraphNodeWithWeights n1 = new GraphNodeWithWeights(1, 0);
        GraphNodeWithWeights n2 = new GraphNodeWithWeights(2, Integer.MAX_VALUE);
        GraphNodeWithWeights n3 = new GraphNodeWithWeights(3, Integer.MAX_VALUE);
        GraphNodeWithWeights n4 = new GraphNodeWithWeights(4, Integer.MAX_VALUE);
        GraphNodeWithWeights n5 = new GraphNodeWithWeights(5, Integer.MAX_VALUE);
        GraphNodeWithWeights n6 = new GraphNodeWithWeights(6, Integer.MAX_VALUE);


        List<GraphNodeWithWeights> nodes = new ArrayList<>();
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);

        GraphEdge e12 = new GraphEdge(n1, n2, 7);
        GraphEdge e16 = new GraphEdge(n1, n6, 14);
        GraphEdge e13 = new GraphEdge(n1, n3, 9);
        GraphEdge e23 = new GraphEdge(n2, n3, 10);
        GraphEdge e24 = new GraphEdge(n2, n4, 15);
        GraphEdge e63 = new GraphEdge(n6, n3, 2);
        GraphEdge e34 = new GraphEdge(n3, n4, 11);
        GraphEdge e65 = new GraphEdge(n6, n5, 9);
        GraphEdge e45 = new GraphEdge(n5, n4, 6);

        List<GraphEdge> edges = new ArrayList<>();
        edges.add(e12);
        edges.add(e16);
        edges.add(e13);
        edges.add(e23);
        edges.add(e24);
        edges.add(e63);
        edges.add(e65);
        edges.add(e34);
        edges.add(e45);

        GeekGraph g = new GeekGraph(nodes, edges);

        //n1 has the smallest value which indicate it should begin

        List<GraphNodeWithWeights> ans = dijkstraDemo(g);//all the nodes with their weight indicating their weight from a
        for (GraphNodeWithWeights n : ans) {
            System.out.printf("n " + n.toString());
        }
    }

    private static List<GraphNodeWithWeights> dijkstraDemo(GeekGraph g) {
        List<GraphNodeWithWeights> nodes = new ArrayList<>();

        Set<GraphNodeWithWeights> visited = new HashSet<>();

        Collections.sort(g.nodes);
        int nodeIndex = 0;// start from the 0th node

        while (nodes.size() < g.nodes.size()) {
            GraphNodeWithWeights curNode = g.nodes.get(nodeIndex);
            if (visited.contains(curNode) == false) {
                visited.add(curNode);

                // Get all the current nodes adj
                Set<GraphEdge> adjacentEdgesBothDir = g.findAdjacentEdgesBothDir(curNode);
                for (GraphEdge e : adjacentEdgesBothDir) {
                    GraphNodeWithWeights otherNode = e.findOtherNode(curNode);
                    if (visited.contains(otherNode) == false) {
                        otherNode.weight = Math.min(curNode.weight + e.weight, otherNode.weight);
                    }
                }
                System.out.println("updated curNode " + curNode.toString());
                nodes.add(curNode);
                Collections.sort(g.nodes);
            }
            nodeIndex++;
        }
        return nodes;

    }
}
