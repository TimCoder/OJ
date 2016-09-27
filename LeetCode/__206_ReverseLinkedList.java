package tim.leetcode; 

public class __206_ReverseLinkedList {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }
 
    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode tail = head;
        ListNode cur = tail.next;
        ListNode newHead = head;
        while (cur != null) {
            tail.next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = tail.next;
        }

        return newHead;
    }
}

