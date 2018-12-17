package com.company.geeksForGeeks.graph;

public class GraphNodeWithWeights implements Comparable<GraphNodeWithWeights> {
    int name;

    int weight;

    public GraphNodeWithWeights(int name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "GraphNodeWithWeights{" +
                "name=" + name +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(GraphNodeWithWeights o) {
        return this.weight - o.weight;
    }
}
