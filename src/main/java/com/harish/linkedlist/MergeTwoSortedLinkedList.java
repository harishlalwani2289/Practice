package com.harish.linkedlist;

import com.harish.linkedlist.core.LinkedList;
import com.harish.linkedlist.core.Node;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(10);
        linkedList.insertFirst(7);
        linkedList.insertFirst(4);
        linkedList.insertFirst(1);

        LinkedList linkedList1 = new LinkedList();
        linkedList1.insertFirst(14);
        linkedList1.insertFirst(13);
        linkedList1.insertFirst(8);
        linkedList1.insertFirst(3);
        linkedList1.insertFirst(2);

        LinkedList mergedLinkedList = mergeTwoSortedLinkedList(linkedList,linkedList1);
        mergedLinkedList.displayList();

    }

    public static LinkedList mergeTwoSortedLinkedList(LinkedList linkedListA, LinkedList linkedListB) {
        Node A = linkedListA.head;
        Node B = linkedListB.head;

        Node prevA = A;

        while(A != null && B != null) {

            if(A.data < B.data) {
                prevA = A;
                A = A.next;
            }

            else if (A.data >= B.data) {
                Node temp = B.next;
                B.next = A;
                prevA.next = B;
                B = temp;
                prevA = prevA.next;
            }
        }
        if(A == null) {
            while(B != null) {
                A = B;
                B = B.next;
                prevA.next = A;
                A.next = null;
                prevA = prevA.next;
            }
        }
        return linkedListA;
    }
}
