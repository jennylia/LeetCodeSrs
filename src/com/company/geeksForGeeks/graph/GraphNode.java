package com.company.geeksForGeeks.graph;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class GraphNode {
    int val;
    List<GraphNode> children;


    public GraphNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "val=" + val +
                '}';
    }

    public GraphNode(int val, List<GraphNode> children) {
        this.val = val;
        this.children = children;
    }

    static GraphNode constructPeaceGeekTree() {
        GraphNode g2 = new GraphNode(2);
        GraphNode g0 = new GraphNode(0);
        GraphNode g1 = new GraphNode(1);
        GraphNode g3 = new GraphNode(3);


        g2.addEdge(g0);
        g2.addEdge(g3);
        g0.addEdge(g2);
        g0.addEdge(g1);
        g1.addEdge(g2);
        g3.addEdge(g3); // loop
        return g2;
    }

    private void addEdge(GraphNode child) {
        this.children.add(child);
    }


    public static void main(String[] args) {
        GraphNode root = constructPeaceGeekTree();
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> toVisit = new LinkedList<>();
//        BFS(root, visited, toVisit);

        DFS(root, visited);

    }

    private static void DFS(GraphNode root, Set<GraphNode> visited) {
        if (root == null){
            return;
        }
        System.out.println("Visiting " + root);
        visited.add(root);
        for (GraphNode g: root.children){
            if (visited.contains(g) == false){
                DFS(g, visited);
            }
        }
    }

    private static void BFS(GraphNode root, Set<GraphNode> visited, Queue<GraphNode> toVisit) {

        if (root == null) {
            System.out.println("graph is empty");
            return;
        }

        // A Queue to manage who to visit next
        System.out.println("Visiting: " + root);
        visited.add(root);
        for (GraphNode g : root.children){
            if (visited.contains(g) == false){
                toVisit.add(g);
            }
        }
        GraphNode next = toVisit.poll();
        BFS(next, visited, toVisit);
    }


}
