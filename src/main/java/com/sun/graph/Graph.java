package com.sun.graph;

import java.util.*;

public class Graph {
    public Map<Integer, Node> nodeMap = new HashMap<>();
    public Set<Edge> edgeSet = new HashSet<>();
}

class Node {
    public int value;
    public int in;
    public int out;
    public List<Node> adjacentNodes = new ArrayList<>();
    public List<Edge> edges = new ArrayList<>();

    public Node(int in) {
        this.value = in;
    }
}

class Edge {
    public int weight;
    public Node form;
    public Node to;

    public Edge(int weight, Node form, Node to) {
        this.weight = weight;
        this.form = form;
        this.to = to;
    }
}
