package practice.harish.linkedlist;

import practice.harish.linkedlist.core.LinkedList;
import practice.harish.linkedlist.core.Node;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(12);
        linkedList.insertFirst(13);
        linkedList.insertFirst(14);
        linkedList.insertFirst(15);

        linkedList.displayList();

        System.out.println("After reversing the linked list");
        
        reverseLinkList(linkedList);
        linkedList.displayList();
    }

    public static void reverseLinkList(LinkedList linkedList) {

        Node current = linkedList.head;
        Node prev = null;
        Node next;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        linkedList.head = prev;
    }
}
