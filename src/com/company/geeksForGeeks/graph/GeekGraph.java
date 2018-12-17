package com.company.geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeekGraph {
    List<GraphNodeWithWeights> nodes;

    List<GraphEdge> edges;

    public GeekGraph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public GeekGraph(List<GraphNodeWithWeights> nodes, List<GraphEdge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

//    GraphNodeWithWeights n0 = new GraphNodeWithWeights(0, 0);
//    GraphNodeWithWeights n1 = new GraphNodeWithWeights(1, Integer.MAX_VALUE);
//    GraphNodeWithWeights n2 = new GraphNodeWithWeights(2, Integer.MAX_VALUE);
//    GraphNodeWithWeights n3 = new GraphNodeWithWeights(3, Integer.MAX_VALUE);
//    GraphNodeWithWeights n4 = new GraphNodeWithWeights(4, Integer.MAX_VALUE);
//
//
//    GraphEdge a = new GraphEdge(n0, n1, 10);
//    GraphEdge b = new GraphEdge(n0, n3, 9);
//    GraphEdge c = new GraphEdge(n3, n1, 7);
//    GraphEdge d = new GraphEdge(n2, n1, 6);
//    GraphEdge e = new GraphEdge(n3, n4, 1);


    public List<GraphEdge> findAdjacentEdges(GraphNodeWithWeights node) {
        List<GraphEdge> edges = new ArrayList<>();
        for (GraphEdge e : this.edges) {
            if (e.from == node) {
                edges.add(e);
            }
        }

        return edges;
    }

    public Set<GraphEdge> findAdjacentEdgesBothDir(GraphNodeWithWeights node) {
        Set<GraphEdge> edges = new HashSet<>();
        for (GraphEdge e : this.edges) {
            if (e.from == node || e.to == node) {
                edges.add(e);
            }
        }

        return edges;
    }
}
