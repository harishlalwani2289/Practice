package com.harish.linkedlist;

import com.harish.linkedlist.core.LinkedList;

import java.util.Random;

public class LinkedListApp {

    public static void main(String arg[]) {

        LinkedList linkedList = new LinkedList();
        for(int i=0; i<10; i++)
            linkedList.insertFirst(new Random().nextInt(20));

        // Display List Details
        linkedList.displayList();

        // Delete first element in linked list
        linkedList.deleteFirst();

        System.out.println("After deletion");
        // display list after deletion
        linkedList.displayList();


        System.out.println("Inserting last and making linked list");
        LinkedList linkedList1 = new LinkedList();
        linkedList1.insertLast(10);
        linkedList1.insertLast(20);
        linkedList1.insertLast(30);

        linkedList1.displayList();

    }
}
