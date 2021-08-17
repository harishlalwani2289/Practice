package harish.circularlinkedlist;

import harish.circularlinkedlist.core.CircularLinkedList;
import harish.circularlinkedlist.core.Node;

public class SplitCircularLinkedListInTwo {

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        CircularLinkedList circularLinkedList1 = new CircularLinkedList();
        CircularLinkedList circularLinkedList2 = new CircularLinkedList();

        circularLinkedList.insert(12);
        circularLinkedList.insert(13);
        circularLinkedList.insert(14);
        circularLinkedList.insert(15);
        circularLinkedList.insert(16);

        circularLinkedList.displayList();

        splitInTwoHalves(circularLinkedList, circularLinkedList1, circularLinkedList2);
    }

    private static void splitInTwoHalves(CircularLinkedList circularLinkedList, CircularLinkedList circularLinkedList1, CircularLinkedList circularLinkedList2) {

        Node slowPointer = circularLinkedList.head;
        Node fastPointer = circularLinkedList.head;

        do {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        } while(fastPointer.next != circularLinkedList.head &&
                fastPointer.next.next != circularLinkedList.head);

        if(fastPointer.next != circularLinkedList.head) {
            fastPointer = fastPointer.next;
        }


        // set the head of second half
        fastPointer.next = slowPointer.next;
        circularLinkedList2.head = fastPointer.next;

        // set the head of first half
        slowPointer.next = circularLinkedList.head;
        circularLinkedList1.head = circularLinkedList.head;

        System.out.println("First Half :");
        circularLinkedList1.displayList();

        System.out.println("Second half : ");
        circularLinkedList2.displayList();
    }

}
