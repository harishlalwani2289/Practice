package harish.tree;

public class CeilAndFloor {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(29,2.5);
        tree.insert(65, 6.8);
        tree.insert(12, 67.0);
        tree.insert(14, 9.4);
        tree.insert(45, 88.6);
        tree.insert(18, 55.55);

        int ceil = findCeil(tree.root, 19);
        System.out.println("Ceil is :" + ceil);

        int floor = findFloor(tree.root, 19);
        System.out.println("Floor is: " + floor);
    }

    public static int findFloor(Node root, int input) {
        if( root == null)
            return Integer.MAX_VALUE;

        if(root.iData == input)
            return root.iData;

        if(root.iData > input)
            return findFloor(root.leftChild ,input);

        int floor = findFloor(root.rightChild, input);

        return floor <= input ? floor : root.iData;

    }

    public static int findCeil(Node root, int input) {

        if (root == null)
            return -1;

        if(root.iData == input)
            return root.iData;

        if(root.iData < input)
            return findCeil(root.rightChild, input);

        int ceil = findCeil(root.leftChild, input);

        return ceil >= input ? ceil : root.iData;
    }
}
