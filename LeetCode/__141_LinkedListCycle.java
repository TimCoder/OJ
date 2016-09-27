package tim.leetcode;

public class __141_LinkedListCycle {

    class ListNode {
        int val; 
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    /*
     * Test Case:
     *      1. l: null
     *      2. l: 1
     *      3. l: 1,2
     *      4. l: 1,1
     *      5. l: 1,2,3
     *      6. l: 1,2,1
     *      7. l: 1,2,2
     *      8. l: 1,2,3,1
     *      9. l: 1,2,3,2
     *     10. l: 1,2,3,4
    */
    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode(0);        
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
