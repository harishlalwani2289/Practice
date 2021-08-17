package harish.tree;

public class TreeApp {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(29,2.5);
        tree.insert(65, 6.8);
        tree.insert(12, 67.0);
        tree.insert(14, 9.4);
        tree.insert(45, 88.6);
        tree.insert(18, 55.55);
        tree.insert(42, 33.3);
        tree.insert(3, 33.3);
        tree.insert(23, 33.3);
        tree.insert(98, 33.3);
        tree.insert(10, 33.3);
        tree.insert(32, 33.3);
        tree.insert(19, 33.3);

        System.out.println(tree.findNode(12));

        System.out.println("Maximum key in the tree is :" + tree.findMax(tree.root));
        System.out.println("Minimum key in the tree is :" + tree.findMin(tree.root));

        System.out.println(tree.findNode(45));

        tree.inOrder(tree.root);

        // Here we are printing all the nodes in tree in the given range
        System.out.println(" \n\n");
        System.out.println("Data in given range is");
        tree.printNodesInGivenRange(tree.root, 23, 45);

    }
}
