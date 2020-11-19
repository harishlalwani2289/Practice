package com.harish.linkedlist;

import com.harish.linkedlist.core.LinkedList;
import com.harish.linkedlist.core.Node;

/*
* Swap the given nodes of linked list without swapping the pointers or address
* Example input 10 20 30 40 50 60 is given linked list
* x= 20 and y=40
* Output 10 40 30 20 50 60
* */
public class SwapNodes {

    public static void main(String arg[]) {

        LinkedList linkedList = new LinkedList();
        for (int i = 1; i < 10; i++)
            linkedList.insertFirst(10*i);

        // Display List Details
        System.out.println("Original linked list");
        linkedList.displayList();

        int x=90, y= 60;
        System.out.println("");
        System.out.println("Linked list after swapping");
        swapNodes(linkedList,x,y);

        // After swapping Display List Details
        linkedList.displayList();
    }

    private static void swapNodes(LinkedList linkedList, int x, int y) {
        Node prevX=null,prevY= null;
        Node currX=linkedList.head,currY=linkedList.head;

        if (x == y)
            return;

        while(currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // Swapping the data now
        if(prevX != null)
            prevX.next = currY;
        else
            linkedList.head = currY;

        if (prevY != null)
            prevY.next = currX;
        else
            linkedList.head = currX;

        // Lets swap the pointers now
        Node temp = currY.next;
        currY.next = currX.next;
        currX.next = temp;
    }
}
