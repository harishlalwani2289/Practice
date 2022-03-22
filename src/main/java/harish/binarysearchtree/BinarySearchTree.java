package harish.binarysearchtree;

public class BinarySearchTree {
    Node root;

    public Node construct(int[] numbers, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        int data = numbers[mid];
        Node lc = construct(numbers, low, mid - 1);
        Node rc = construct(numbers, mid + 1, high);
        Node node = new Node(data, lc, rc);
        return node;
    }

    public void display(Node node) {

        if (node == null) {
            return;
        }
        String str = (node.left == null ? "" : node.left.data)
                + " -- " + node.data + " -- "
                + (node.right == null ? "" : String.valueOf(node.right.data));

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public int max(Node node) {
        if(node.right != null) {
            return max(node.right);
        }
        else {
            return node.data;
        }
    }

    public Node add(Node node,int data) {

        if(node == null) {
            return new Node(data, null, null);
        }
        if(data > node.data) {
           node.right =  add(node.right, data);
        }
        else if (data < node.data) {
            node.left = add(node.left, data);
        }
        else {
            return node;
        }
        return node;
    }


    public void inOrderTraversal(Node node) {

        if(node == null) return;
        inOrderTraversal(node.left);
            System.out.println("Pre Order :" + node.data);
        inOrderTraversal(node.right);

    }

    public void postOrderTraversal(Node node) {

        if(node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println("Pre Order :" + node.data);

    }
}

