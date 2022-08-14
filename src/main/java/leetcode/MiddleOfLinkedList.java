package leetcode;

import harish.linkedlist.core.LinkedList;
import harish.linkedlist.core.Node;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertLast(10);
        linkedList.insertLast(20);
        linkedList.insertLast(30);
        linkedList.insertLast(40);
        linkedList.insertLast(50);
        linkedList.insertLast(60);

        System.out.println(middleNode(linkedList.head).data);
    }

    private static Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return fast.next == null ? slow : slow.next;
    }
}
