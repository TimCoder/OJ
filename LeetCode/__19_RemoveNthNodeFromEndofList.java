package tim.leetcode;

public class __19_RemoveNthNodeFromEndofList {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    /*
     * Test Case: 
     *      1. l: null   n: 1
     *      2. l: 1      n: 1
     *      3. l: 1, 2   n: 1
     *      4. l: 1, 2   n: 2
     *      5. l: 1, 2, 3   n: 3
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; ++i) {
            if (fast == null) {
                return dummy.next;
            }
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }
                    
        return dummy.next;
    }
}
