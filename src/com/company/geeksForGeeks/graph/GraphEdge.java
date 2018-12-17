package com.company.geeksForGeeks.graph;

public class GraphEdge implements Comparable<GraphEdge>{
    GraphNodeWithWeights from;
    GraphNodeWithWeights to;
    int weight;

    public GraphEdge(GraphNodeWithWeights from, GraphNodeWithWeights to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "GraphEdge{" +
                "from=" + from +
                ", to=" + to +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(GraphEdge o) {
        return this.weight - o.weight;
    }

    public GraphNodeWithWeights findOtherNode(GraphNodeWithWeights curNode) {
        if (this.from == curNode){
            return this.to;
        }else{
            return this.from;
        }
    }
}
