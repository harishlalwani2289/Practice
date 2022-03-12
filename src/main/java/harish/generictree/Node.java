package harish.generictree;

import java.util.ArrayList;

public class Node {
    int data;
    ArrayList<Node> children;

    public Node(int data, ArrayList<Node> children) {
        this.data = data;
        this.children = children;
    }
}
