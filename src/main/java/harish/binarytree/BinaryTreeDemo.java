package harish.binarytree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        Integer[] input = {50, 25, 12, null, null, 37, 30, null, null,
                null, 75, 62, null, 70, null, null, 87, null, null};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.construct2(input);
        binaryTree.display(binaryTree.root);
        System.out.println("Size of tree : " + binaryTree.size(binaryTree.root));
        System.out.println("Sum of tree : " + binaryTree.sum(binaryTree.root));
        System.out.println("Max of tree : " + binaryTree.max(binaryTree.root));
    }
}