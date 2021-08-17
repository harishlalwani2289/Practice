package harish.linkedlist;

import harish.linkedlist.core.LinkedList;
import harish.linkedlist.core.Node;

import java.util.Random;

public class LengthOfLinkedList {

    public static void main(String arg[]) {

        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++)
            linkedList.insertFirst(new Random().nextInt(20));

        // Display List Details
        linkedList.displayList();

        int count = getCount(linkedList.head);
        System.out.println("Length of Linked List is = " + count);
    }

    public static int getCount(Node head) {
        if(head != null)
            return 1+getCount(head.next);
        return 0;
    }
}
