package tim.leetcode;

import java.util.HashMap;
import java.util.Map;

public class __83_RemoveDuplicatesfromSortedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    /*
     * Test Case:
     *      1. null
     *      2. 1
     *      3. 1,1
     *      4. 1,1,2
     *      5. 1,2,2,3 
     */

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode temp = dummy.next;
        while (temp != null) {
            if (temp == dummy.next) {
                temp = temp.next;
                pre = pre.next;
            } else if (temp.val == pre.val) {
                temp = temp.next;
                pre.next = temp;
            } else {
                temp = temp.next;
                pre = pre.next;
            }
        }

        return dummy.next;
    }

}
