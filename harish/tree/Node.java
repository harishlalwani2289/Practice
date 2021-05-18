package practice.harish.tree;

public class Node {
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public Node(int i, double v) {
        this.iData = i;
        this.dData = v;
    }

    public Node(int i) {
        this.iData = i;
    }

    public Node() {
    }

    public void displayNode() {
        System.out.println("{" + iData + ", " + dData + "}" );
    }

    @Override
    public String toString() {
        return "Node{" +
                "iData=" + iData +
                ", dData=" + dData +
                '}';
    }
}
