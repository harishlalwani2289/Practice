package harish.binarysearchtree;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] numbers = {12,25,37,50,62,75,87};
        binarySearchTree.root = binarySearchTree.construct(numbers, 0, numbers.length-1);
//        binarySearchTree.display(binarySearchTree.root);
//        System.out.println("Max element is  :" + binarySearchTree.max(binarySearchTree.root));

        binarySearchTree.inOrderTraversal(binarySearchTree.root);
    }
}
