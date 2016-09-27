package tim.leetcode;

import tim.leetcode.__206_ReverseLinkedList.ListNode;

public class __234_PalindromeLinkedList {
    
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

    /*
     * Test Case:
     *      1. null
     *      2. 1
     *      3. 1,2
     *      4. 1,1
     *      5. 1,2,1
     *      6. 1,2,3
     *      7. 1,2,2
     *      8. 1,2,2,1
     *      9. 1,2,2,3,5
    */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        boolean isOdd = false;
        while (fast != null && fast.next != null)  {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = reverseList(slow.next);
        slow.next = null;
        ListNode firstCur = dummy.next;
        ListNode secondCur = secondHead;
        while (firstCur != null && secondCur != null) {
            if (firstCur.val != secondCur.val) {
                return false;
            }
            firstCur = firstCur.next;
            secondCur = secondCur.next;
        }
        
        return true;
    }

}
