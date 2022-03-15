package harish.generictree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTree {
    Node root;

    public void construct(int[] numbers) {
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == -1) {
                stack.pop();
            } else {
                Node node = new Node(numbers[i], new ArrayList<>());
                if (stack.size() > 0)
                    stack.peek().children.add(node);
                else
                    root = node;

                stack.push(node);
            }
        }
    }

    public void display(Node node) {
        String str = node.data + " -- ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        System.out.println(str);
        for (Node child : node.children) {
            display(child);
        }

    }

    public int size(Node node) {
        int size =0;
        for( Node element : node.children) {
            int childSize = size(element);
            size = size + childSize;
        }
        return size + 1;
    }
}
