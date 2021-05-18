package practice.harish.graph;

import practice.harish.stacks.Stack;

public class Graph {

    private Vertex[] vertices;
    private int[][] adjacentMatrix;
    private final int MAX_SIZE;
    private int nVertices;
    Stack stack;

    public Graph(int max_size) {
        this.MAX_SIZE = max_size;
        this.vertices = new Vertex[MAX_SIZE];
        this.adjacentMatrix = new int[MAX_SIZE][MAX_SIZE];
        nVertices = 0;
        stack = new Stack();
    }

    public void insertVertex(char value) {
        vertices[nVertices++] = new Vertex(value);
    }

    public void addEdge(int start, int end){
        adjacentMatrix[start][end] = 1;
        adjacentMatrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertices[v]);
    }


}
