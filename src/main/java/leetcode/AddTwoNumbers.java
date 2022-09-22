package leetcode;

import harish.linkedlist.core.LinkedList;
import harish.linkedlist.core.Node;

/**
 * @see  <a href="https://leetcode.com/problems/add-two-numbers/">...</a>
 * {@link <a href="https://leetcode.com/problems/add-two-numbers/">...</a>}
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.insertFirst(2);
        linkedList1.insertFirst(7);
        linkedList1.insertFirst(3);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insertFirst(2);
        linkedList2.insertFirst(7);
        linkedList2.insertFirst(3);

        addTwoNumbers(linkedList1.head, linkedList2.head);
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        // Head of each linked list
        Node firstCurrent = l1;
        Node secondCurrent = l2;
        LinkedList resultList = new LinkedList();

        int carry = 0;
        while(firstCurrent != null && secondCurrent != null) {
            int interimResult = (carry + firstCurrent.data + secondCurrent.data)%10;
            carry = (carry + firstCurrent.data + secondCurrent.data)/10;
            resultList.insertLast(interimResult);

            firstCurrent = firstCurrent.next;
            secondCurrent = secondCurrent.next;
        }
        while(firstCurrent != null) {
            int interimResult = (carry + firstCurrent.data)%10;
            carry = (carry + firstCurrent.data)/10;
            resultList.insertLast(interimResult);

            firstCurrent = firstCurrent.next;
        }
        while(secondCurrent != null) {
            int interimResult = (carry + secondCurrent.data )%10;
            carry = (carry + secondCurrent.data)/10;
            resultList.insertLast(interimResult);

            secondCurrent = secondCurrent.next;
        }
        if(carry == 1)
            resultList.insertLast(1);

        return resultList.head;
    }
}

