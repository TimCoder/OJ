package tim.leetcode;

public class __203_RemoveLinkedListElements {
  
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
     *      2. l: 1     val:0,1
     *      3. l: 1,2   val:0,1,2
     *      4. l: 1,2,1   val:0,1,2
    */
    public ListNode removeElements(ListNode head, int val) { 

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

}
