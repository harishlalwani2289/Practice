package com.harish.linkedlist;

import com.harish.linkedlist.core.LinkedList;
import com.harish.linkedlist.core.Node;

public class RemoveDuplicatesFromSortedLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(40);
        linkedList.insertFirst(40);
        linkedList.insertFirst(40);
        linkedList.insertFirst(30);
        linkedList.insertFirst(30);
        linkedList.insertFirst(20);
        linkedList.insertFirst(10);

        linkedList.displayList();

        removeDuplicates(linkedList);

        System.out.println("After removing duplicates :");
        linkedList.displayList();
    }

    private static void removeDuplicates(LinkedList linkedList) {
        Node current = linkedList.head;

        while (current != null) {
            Node temp = current;

            while (temp != null && temp.data == current.data) {
                temp = temp.next;
            }

            current.next = temp;
            current = temp;
        }
    }
}
