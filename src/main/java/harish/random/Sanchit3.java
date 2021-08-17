package harish.random;

import harish.linkedlist.core.LinkedList;
import harish.linkedlist.core.Node;

/*
Given Linked List
Remove alternate nodes starting rom node 2 and append it at last
10 20 30 40 50
Output
1. 10 30 50 20 40
2. 10 30 50 40 20
 */
public class Sanchit3 {

    public static void main (String arg[]) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList1 = new LinkedList();

        linkedList.insertFirst(50);
        linkedList.insertFirst(40);
        linkedList.insertFirst(30);
        linkedList.insertFirst(20);
        linkedList.insertFirst(10);

        System.out.println("Original Linked List : ");
        linkedList.displayList();

        deleteEvenNodes(linkedList,linkedList1);

        System.out.println("After deleting even nodes and appending Linked List : ");
        linkedList.displayList();
    }

    private static void deleteEvenNodes(LinkedList linkedList, LinkedList linkedList1) {
        Node current = linkedList.head;

        while(current != null && current.next != null){
            linkedList1.insertFirst(current.next.getData());
            current.next = current.next.next;
            current = current.next;
        }
        current.next = linkedList1.head;
    }
}
