package harish.binarytree;

import java.util.Stack;

public class BinaryTree {
    Node root;

    public void construct(Integer[] input) {

        Stack<Pair> stack = new Stack<>();
        root = new Node(input[0], null, null);
        Pair rootPair = new Pair(root, 1);
        stack.push(rootPair);

        for (int i = 1; i < input.length; i++) {
            if (stack.peek().state == 3) {
                stack.pop();
                i--;
            } else if (input[i] == null) {

                if (stack.peek().state == 1) {
                    stack.peek().node.left = null;
                } else if (stack.peek().state == 2) {
                    stack.peek().node.right = null;
                }
                stack.peek().state++;

            } else {

                if (stack.peek().state == 1) {
                    Node leftNode = new Node(input[i], null, null);
                    stack.peek().node.left = leftNode;
                    Pair leftPair = new Pair(leftNode, 1);
                    stack.peek().state++;
                    stack.push(leftPair);
                }
                if (stack.peek().state == 2) {
                    Node rightNode = new Node(input[i], null, null);
                    stack.peek().node.right = rightNode;
                    Pair rightPair = new Pair(rightNode, 1);
                    stack.peek().state++;
                    stack.push(rightPair);
                }
            }
        }
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


    public void construct2(Integer[] input) {

        Stack<Pair> stack = new Stack<>();
        int idx = 0;
        insertFirstNode(input, stack, idx);
        while (stack.size() > 0) {
            Pair top = stack.peek();
            if (top.state == 1) {
                // We are going to insert the left child of top
                insertToLeft(input, stack, ++idx, top);
            } else if (top.state == 2) {
                // We are going to insert the right child of top
                insertToRight(input, stack, ++idx, top);
            } else {
                stack.pop();
            }
        }

    }

    private void insertFirstNode(Integer[] input, Stack<Pair> stack, int idx) {
        root = new Node(input[idx], null, null);
        Pair rootPair = new Pair(root, 1);
        stack.push(rootPair);
    }

    private void insertToRight(Integer[] input, Stack<Pair> stack, int idx, Pair top) {
        top.state++;
        if (input[idx] != null) {
            Node rightNode = new Node(input[idx], null, null);
            top.node.right = rightNode;
            Pair rightPair = new Pair(rightNode, 1);
            stack.push(rightPair);
        } else {
            top.node.right = null;
        }
    }

    private static void insertToLeft(Integer[] input, Stack<Pair> stack, int idx, Pair top) {
        top.state++;
        if (input[idx] != null) {
            Node leftNode = new Node(input[idx], null, null);
            top.node.left = leftNode;
            Pair leftPair = new Pair(leftNode, 1);
            stack.push(leftPair);
        } else {
            top.node.left = null;
        }
    }

    public int size(Node node) {

        if (node == null)
            return 0;
        int treeSize = 0;
        int leftSize = size(node.left);
        int rightSize = size(node.right);

        treeSize = leftSize + rightSize + 1;
        return treeSize;
    }

    public int sum(Node node) {

        if(node == null) {
            return  0;
        }
        int treeSum = 0;
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        treeSum = leftSum + rightSum + node.data;
        return treeSum;
    }

    public int max(Node node) {

        if(node == null){
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;

        int leftMax = max(node.left);
        int rightMax = max(node.right);

        int interimMax = Math.max(leftMax, rightMax);
        max = Math.max(interimMax, node.data);
        return max;
    }

    public int min(Node node) {

        if(node == null){
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;

        int leftMin = min(node.left);
        int rightMin = min(node.right);

        int interimMin = Math.min(leftMin, rightMin);
        min = Math.min(interimMin, node.data);
        return min;
    }
}
