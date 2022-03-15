package harish.binarytree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        Integer[] input = {50, 25, 12, null, null, 37, 30, null, null,
                null, 75, 62, null, 70, null, null, 87, null, null};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.construct2(input);
        binaryTree.display(binaryTree.root);
    }
}