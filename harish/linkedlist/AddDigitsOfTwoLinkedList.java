package practice.harish.linkedlist;

import practice.harish.linkedlist.core.LinkedList;
import practice.harish.linkedlist.core.Node;

public class AddDigitsOfTwoLinkedList {

    public static void main(String[] args) {

        LinkedList linkedList1 = new LinkedList();
        linkedList1.insertLast(9);
        linkedList1.insertLast(5);
        linkedList1.insertLast(8);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insertLast(2);
        linkedList2.insertLast(6);
        linkedList2.insertLast(5);

        LinkedList resultLinkedList = add(linkedList1,linkedList2);

        resultLinkedList.displayList();
    }

    private static LinkedList add(LinkedList linkedList1, LinkedList linkedList2) {

        LinkedList resultLinkedList = new LinkedList();
        Integer length1 = LengthOfLinkedList.getCount(linkedList1.head);
        Integer length2 = LengthOfLinkedList.getCount(linkedList2.head);

        Node pointer1 = linkedList1.head;
        Node pointer2 = linkedList2.head;



        while(pointer1 != null && pointer2 != null) {
            resultLinkedList.insertLast(pointer1.data + pointer2.data);
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        ReverseLinkedList.reverseLinkList(resultLinkedList);

        Node pointer = resultLinkedList.head;

        int carry = 0;
        while(pointer != null) {

            pointer.data = pointer.data + carry;
            if(pointer.data >= 10){
                pointer.data = pointer.data%10;
                carry = 1;
            }
            else {
                carry = 0;
            }

            pointer = pointer.next;
        }
        if(carry == 1) {
            resultLinkedList.insertLast(1);
        }

        ReverseLinkedList.reverseLinkList(resultLinkedList);
        return resultLinkedList;
    }
}
