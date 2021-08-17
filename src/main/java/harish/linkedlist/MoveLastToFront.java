package harish.linkedlist;

import harish.linkedlist.core.LinkedList;
import harish.linkedlist.core.Node;

/*
Write a function that moves the last element to the front in a given Singly Linked List. For example, if the given Linked List is 1->2->3->4->5, then the function should change the list to 5->1->2->3->4.
Algorithm:
Traverse the list till last node. Use two pointers: one to store the address of last node and other for address of second last node. After the end of loop do following operations.
i) Make second last as last (secLast->next = NULL).
ii) Set next of last as head (last->next = *head_ref).
iii) Make last as head ( *head_ref = last)
 */
public class MoveLastToFront {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.insertLast(12);
        linkedList.insertLast(13);
        linkedList.insertLast(14);
        linkedList.insertLast(15);
        linkedList.insertLast(16);


        linkedList.displayList();
        moveLastToFront(linkedList);
        System.out.println("After moving last node to front : ");
        linkedList.displayList();

    }

    public static void moveLastToFront(LinkedList linkedList) {

        Node current = linkedList.head;
        Node prev = null;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        current.next = linkedList.head;
        linkedList.head = current;
        prev.next = null;
    }
}
