package generictree;

import java.util.Stack;

public class GenericTree {

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root =  null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];
                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
        traversals(root);
    }

    // 10 will print itself and its family
    // d(20), d(30) and d(40) will print themselves and their families
    // d(10) = s(10) + d(20) + d(30) + d(40)
    public static void display(Node node) {
        String str = node.data + "-->";
        for(Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for(Node child : node.children) {
            display(child);
        }
    }

    public static int size(Node node) {
        int s =0;
        for(Node child : node.children) {
            int cs = size(child);
            s = s + cs;
        }
        s = s + 1;

        return s;
    }

    public static int maximum(Node node) {
        int max = node.data;

        for(Node child : node.children) {
            int cmax = maximum(child);
            if(cmax > max) {
                max = cmax;
            }
        }

        return  max;
    }

    public static int height(Node node) {
        int height = 0;
        for(Node child : node.children) {
            int childHeight = height(child);
            height = Math.max(height,childHeight);
        }

        return ++height;
    }

    public static void traversals(Node node){
        // write your code here
        System.out.println("Node Pre " + node.data);
        for(Node child: node.children) {
            //edge pre
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
            //edge post
        }
        System.out.println("Node Post " + node.data);
    }
}
