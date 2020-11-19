package com.harish.linkedlist;

import com.harish.linkedlist.core.LinkedList;
import com.harish.linkedlist.core.Node;

public class PairWiseSwapElementsOfLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for(int i=1;i<=9;i++) {
            linkedList.insertFirst(10*i);
        }
        ReverseLinkedList.reverseLinkList(linkedList);
        pairWiseSwapNodes(linkedList.head);
        linkedList.displayList();
    }

    private static void pairWiseSwapNodes(Node head) {

        if(head !=null && head.next != null) {
            swapNodes(head,head.next);
            pairWiseSwapNodes(head.next.next);
        }
    }

    private static void swapNodes(Node head, Node next) {
        int temp = head.data;
        head.data = next.data;
        next.data = temp;
    }
}
