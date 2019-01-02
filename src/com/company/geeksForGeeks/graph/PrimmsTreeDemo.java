package com.company.geeksForGeeks.graph;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.javafx.geom.Edge;

import java.util.*;

public class PrimmsTreeDemo {

    public static void main(String[] args) {
//        https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
        GeekGraph g = BuildGraph();

        GeekGraph mst_edge = prims(g);

        System.out.println(mst_edge);

        //Worst case O (n^2) -- or use head o(V+E logV) (doing this for ever single node)

    }

    private static GeekGraph prims(GeekGraph g) {
        GeekGraph mstGraph = new GeekGraph();

        int size = g.nodes.size() - 1;
        int node_idx = 0;

        while (mstGraph.nodes.size() != size) {
            Collections.sort(g.nodes);
            GraphNodeWithWeights node = g.nodes.get(node_idx);

            if (mstGraph.nodes.contains(node) == false) {
                GraphNodeWithWeights curMin = node;
                List<GraphEdge> adjacentEdges = g.findAdjacentEdges(curMin);
                Collections.sort(adjacentEdges);

                for (GraphEdge e : adjacentEdges) {
                    GraphNodeWithWeights to = e.to;
                    to.weight = e.weight;
                }
                mstGraph.nodes.add(curMin);
            } else {
                node_idx++;
            }
        }
        return mstGraph;
    }

    private static GeekGraph BuildGraph() {
        GraphNodeWithWeights n0 = new GraphNodeWithWeights(0, 0);
        GraphNodeWithWeights n1 = new GraphNodeWithWeights(1, Integer.MAX_VALUE);
        GraphNodeWithWeights n2 = new GraphNodeWithWeights(2, Integer.MAX_VALUE);
        GraphNodeWithWeights n3 = new GraphNodeWithWeights(3, Integer.MAX_VALUE);
        GraphNodeWithWeights n4 = new GraphNodeWithWeights(4, Integer.MAX_VALUE);


        GraphEdge a = new GraphEdge(n0, n1, 10);
        GraphEdge b = new GraphEdge(n0, n3, 9);
        GraphEdge c = new GraphEdge(n3, n1, 7);
        GraphEdge d = new GraphEdge(n2, n1, 6);
        GraphEdge e = new GraphEdge(n3, n4, 1);
        GraphEdge f = new GraphEdge(n4, n2, 5);

        List<GraphNodeWithWeights> nodes = new ArrayList<>();
        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);

        List<GraphEdge> edges = new ArrayList<>();
        edges.add(a);
        edges.add(b);
        edges.add(c);
        edges.add(d);
        edges.add(e);
        edges.add(f);


        return new GeekGraph(nodes, edges);

    }
}
