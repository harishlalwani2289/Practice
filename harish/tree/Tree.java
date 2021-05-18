package practice.harish.tree;

public class Tree {

    Node root;

    public void insert(int iData, double dData){

        Node newNode = new Node();
        newNode.iData = iData;
        newNode.dData = dData;

        if(root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while(true) {
                parent = current;
                if (iData < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findNode(int iData) {
        Node current = root;

        if(current == null)
            return null;
        while (current != null) {
            if (current.iData == iData)
                return current;
            if(current.iData < iData)
                current = current.rightChild;
            if(current.iData > iData)
                current = current.leftChild;
        }
        return null;
    }

    public Node findMax(Node root) {
        Node current = root;
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current;
    }

    public Node findMin(Node root) {
        Node current = root;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }

    // Deleting a node with give iData
    public Node deleteNode(Tree tree, int iData) {
        Node current = root;
        Node parent = null;
        // Denotes if the current node i.e the node to be deleted is left child or right child
        // of its parent
        boolean isLeftChild = false;

        while(current.iData != iData) {
            parent = current;
            if(current.iData > iData) {
                current = current.leftChild;
                isLeftChild =true;
            }
            if(current.iData < iData) {
                current = current.rightChild;
                isLeftChild = false;
            }
        }

        // Case where current node is a leaf node
        if(current.rightChild == null && current.leftChild == null){
            if(isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }

        // Case when current node has left child and no right child
        else if(current.rightChild == null)
        {
            if(current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        }

        // Case when current node has right child and no left child
        else if(current.leftChild == null)
        {
            if(current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }

        // Case when current node has right child as well as left child
        else {

            Node successor = getSuccessor(current);

            // connecting parent of current to successor
            if(current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;

            successor.leftChild = current.leftChild;
        }

        return current;
    }

    private Node getSuccessor(Node delNode) {
        Node successor = delNode;
        Node successorParent = delNode;
        Node current = delNode.rightChild;

        while(current != null)
        {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return  successor;

    }

    public void inOrder(Node root) {
        if( root != null) {
            inOrder(root.leftChild);
            System.out.print(root.iData + " ");
            inOrder(root.rightChild);
        }

    }

    public void printNodesInGivenRange(Node root, int k1, int k2) {

        if(root == null)
            return;
        if(root.iData > k1)
            printNodesInGivenRange(root.leftChild, k1, k2);
        if(root.iData <= k2 && root.iData >= k1)
            System.out.print(root.iData + " ");
        if(root.iData < k2)
            printNodesInGivenRange(root.rightChild, k1, k2);
    }

    public int findKthSmallestElementInTree (Node root, int k) {
        int[] nums = new int[2];
        kthSmallestElement(root, nums, k);
        return nums[1];
    }

    private void kthSmallestElement(Node root, int[] nums,  int k) {
        if( root == null)
            return;

        kthSmallestElement(root.leftChild, nums, k);
        if(++nums[0] == k) {
            nums[1] = root.iData;
            return;
        }
        kthSmallestElement(root.rightChild, nums, k);
    }
}
