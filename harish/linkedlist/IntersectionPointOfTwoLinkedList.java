package practice.harish.linkedlist;

import practice.harish.linkedlist.core.LinkedList;
import practice.harish.linkedlist.core.Node;

public class IntersectionPointOfTwoLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.insertLast(3);
        linkedList1.insertLast(6);
        linkedList1.insertLast(9);
        Node intersectionNode = linkedList1.insertLastAndReturnNode(15);
        linkedList1.insertLast(30);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insertAndReturnNode(10).next = intersectionNode;

        findIntersectionPoint(linkedList1,linkedList2);

    }

    private static void findIntersectionPoint(LinkedList linkedList1, LinkedList linkedList2) {

        // First we will count the numbers of node in each linked list
        int count1 = LengthOfLinkedList.getCount(linkedList1.head);
        int count2 = LengthOfLinkedList.getCount(linkedList2.head);

        Node head1 = linkedList1.head;
        Node head2 = linkedList2.head;


        // Now we traverse the longest list till |c1-c2|
        int count =0;
        while(count != Math.abs(count1-count2)) {
            if(count1 > count2) {
                head1 = head1.next;
            }
            else {
                head2 = head2.next;
            }
            count ++;
        }

        while (head1 != head2 && head1 != null && head2 != null) {
            head1 = head1.next;
            head2 = head2.next;
        }

        if( head1 == null || head2 == null) {
            System.out.println("No intersection");
        }
        else {
            System.out.println("Intersection at data :" + head1.data);
        }

    }
}
