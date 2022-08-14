package leetcode;

import harish.linkedlist.core.LinkedList;
import harish.linkedlist.core.Node;

public class PalindromeLinkedList {
    static LinkedList linkedList = new LinkedList();
    static Node frontPointer = linkedList.head;

    public static void main(String[] args) {

        linkedList.insertLast(10);
        linkedList.insertLast(20);
        linkedList.insertLast(30);
        linkedList.insertLast(30);
        linkedList.insertLast(20);
        linkedList.insertLast(10);

        frontPointer = linkedList.head;
        System.out.println(isPalindrome(linkedList.head));
    }

    public static boolean isPalindrome(Node currentNode) {
        if (currentNode != null) {
            if(!isPalindrome(currentNode.next)) return false;
            if(currentNode.data !=  frontPointer.data) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }
}
