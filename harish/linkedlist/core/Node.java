package practice.harish.linkedlist.core;

public class Node {

    public int data;

    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String displayNode() {
        return "Node{" +
                "value=" + data +
                '}';
    }
}
