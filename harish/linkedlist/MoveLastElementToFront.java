package practice.harish.linkedlist;

import practice.harish.linkedlist.core.LinkedList;
import practice.harish.linkedlist.core.Node;

public class MoveLastElementToFront {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for(int i=1;i<=9;i++) {
            linkedList.insertFirst(10*i);
        }
        ReverseLinkedList.reverseLinkList(linkedList);
        moveLastElementToFirst(linkedList);
        linkedList.displayList();
    }

    private static void moveLastElementToFirst(LinkedList linkedList) {

        Node prev = linkedList.head;
        Node curr = prev.next;

        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        curr.next = linkedList.head.next;
        linkedList.head = curr;
        prev.next = null;
    }
}
