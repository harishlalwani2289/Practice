package practice.harish.linkedlist;

import practice.harish.linkedlist.core.LinkedList;
import practice.harish.linkedlist.core.Node;

/**
 * Given two lists sorted in increasing order, create and return a new list representing the intersection of the two lists.
 * The new list should be made with its own memory — the original lists should not be changed.
 * Example:
 *
 * Input:
 * First linked list: 1->2->3->4->6
 * Second linked list be 2->4->6->8,
 * Output: 2->4->6.
 * The elements 2, 4, 6 are common in
 * both the list so they appear in the
 * intersection list.
 *
 * Input:
 * First linked list: 1->2->3->4->5
 * Second linked list be 2->3->4,
 * Output: 2->3->4
 * The elements 2, 3, 4 are common in
 * both the list so they appear in the
 * intersection list.
 */
public class IntersectionOfTwoLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.insertAndReturnNode(1);
        linkedList1.insertAndReturnNode(2);
        linkedList1.insertAndReturnNode(3);
        linkedList1.insertAndReturnNode(4);
        linkedList1.insertAndReturnNode(6);
        linkedList1.insertAndReturnNode(10);

        ReverseLinkedList.reverseLinkList(linkedList1);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insertLast(2);
        linkedList2.insertLast(4);
        linkedList2.insertLast(6);
        linkedList2.insertLast(8);

        findIntersectionOfTwoLinkedList(linkedList1,linkedList2);
    }

    public static void findIntersectionOfTwoLinkedList(LinkedList linkedList1, LinkedList linkedList2) {
        Node intersectHead = intersect(linkedList1.head, linkedList2.head);
        LinkedList linkedList = new LinkedList();
        linkedList.head = intersectHead;
        linkedList.displayList();
    }

    private static Node intersect(Node head1, Node head2) {

        if(head1 == null || head2 == null)
            return null;

        if(head1.data > head2.data)
            return intersect(head1,head2.next);

        if(head1.data < head2.data)
            return intersect(head1.next, head2);

        Node node = new Node(head1.data);

        node.next = intersect(head1.next, head2.next);
        return node;
    }


}
