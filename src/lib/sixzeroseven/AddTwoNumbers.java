package lib.sixzeroseven;


/**
 * @auther: WJoe
 * @Description:You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @Date : 20:16 2018/6/28
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            n1 = l1.val + l2.val + n2;
            n2 = n1 / 10;
            temp.next = new ListNode(n1 % 10);
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
            if (l1 == null && l2 == null) {
                break;
            }
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
        }
        if (n2 != 0){
            temp.next  = new ListNode(n2);
        }

    return  head.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
