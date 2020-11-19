package com.harish.linkedlist;

import com.harish.linkedlist.core.LinkedList;
import com.harish.linkedlist.core.Node;

import java.util.HashSet;

public class RemoveDuplicatesFromUnsortedLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(30);
        linkedList.insertFirst(40);
        linkedList.insertFirst(30);
        linkedList.insertFirst(20);
        linkedList.insertFirst(40);
        linkedList.insertFirst(10);

        linkedList.displayList();

        //removeDuplicates(linkedList);
        removeDuplicatesUsingHashSet(linkedList);

        System.out.println("After removing duplicates :");
        linkedList.displayList();
    }

    private static void removeDuplicates(LinkedList linkedList) {
        Node curr = linkedList.head;

        while(curr != null) {
            Node temp = curr;

            while(temp.next != null) {
                if(temp.next.data == curr.data)
                    temp.next = temp.next.next;
                else
                    temp = temp.next;
            }
            curr = curr.next;
        }
    }

    public static void removeDuplicatesUsingHashSet(LinkedList linkedList) {

        Node current = linkedList.head;
        Node previous = null;

        HashSet<Integer> hashSet = new HashSet<>();

        while(current != null) {

            if(hashSet.contains(current.data)) {
                previous.next = current.next;
            }
            else {
                hashSet.add(current.data);
                previous = current;
            }
            current = current.next;
        }


    }
}
