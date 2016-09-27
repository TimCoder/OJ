package tim.leetcode;

import tim.leetcode.__328_OddEvenLinkedList.ListNode;

public class __143_ReorderList {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }
    
    public ListNode reverseList(ListNode head) {

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

    public void reorderList(ListNode head) {
        
        if (head == null || head.next == null) {
            return;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //1,2,3,4,5,6
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        if (fast == null) {
            //length is odd
            slow = slow.next;
        } 
        ListNode secondDummy = new ListNode(0);
        secondDummy.next = slow;
        secondDummy.next = reverseList(secondDummy.next);
        
        ListNode oddP = dummy.next;  
        ListNode evenP = secondDummy.next;
        ListNode p = oddP ; 
        oddP = oddP.next;
        boolean isNextEven = true;
        //1,2
        //4,3
        while (oddP != null && evenP != null) {
            if (isNextEven) {
                p.next = evenP;
                evenP = evenP.next;
            } else {
                p.next = oddP;
                oddP = oddP.next;
            }
            p = p.next;
            isNextEven = !isNextEven;
        }
        if (evenP != null) {
            p.next = evenP;
            p = p.next;
        }

        return; 
    }


}
