package harish.tree;
/*
Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.

     10
   /   \
  5     40
 /  \      \
1    7      50

 */
public class TreeFromPreOrder {

    public int pIndex = 0;

    public static void main(String[] args) {
        TreeFromPreOrder treeFromPreOrder = new TreeFromPreOrder();
        int preOrder[] = new int[]{10, 5, 1, 7, 40, 50};
        Node root = treeFromPreOrder.constructTree(preOrder, preOrder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
        Tree tree = new Tree();
        tree.root = root;
        tree.inOrder(root);
    }

    public Node constructTree(int[] preOrder, int data, int minValue, int maxValue) {

        if(pIndex < preOrder.length) {
            if (preOrder[pIndex] > minValue && preOrder[pIndex] < maxValue) {
                Node root = new Node(data);
                pIndex++;

                if(pIndex < preOrder.length) {
                    root.leftChild = constructTree(preOrder, preOrder[pIndex], minValue , data);
                    root.rightChild = constructTree(preOrder, preOrder[pIndex], data , maxValue);
                }
                return root;
            }
        }
        return null;
    }
}
