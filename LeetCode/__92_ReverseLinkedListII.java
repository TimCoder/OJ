package tim.leetcode;

import tim.leetcode.__206_ReverseLinkedList.ListNode;

public class __92_ReverseLinkedListII {
   
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstTail = dummy;
        for (int i = 0; i < m - 1; ++i) {
            firstTail = firstTail.next;
        }
        head = firstTail.next;
        int length = n - m;
        ListNode tail = head;
        ListNode cur = tail.next;
        ListNode newHead = head;
        while (length > 0 && cur != null) {
            tail.next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = tail.next;
            --length;
        }
        firstTail.next = newHead;

        return dummy.next;
    }

}

