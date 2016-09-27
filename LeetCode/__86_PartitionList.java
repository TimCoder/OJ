package tim.leetcode;

public class __86_PartitionList {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    /* 
     * Test Case:
     *      1. l: null  x: 1
     *      2. l: 1,    x: 0,1,2
     *      3. l: 1,1   x: 0,1,2,3
     *      4. l: 1,2   x: 0,1,2,3
     *      5. l: 2,1   x: 0,1,2,3
     *      6: l: 1,2,1 x: 0,1,2,3
     *      7: l: 2,1,1 x: 0,1,2,3
     *      8: l: 2,1,2 x: 0,1,2,3
    */
    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return head;
        }

        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);
        ListNode smallTail = smallDummy, bigTail = bigDummy;
        ListNode cur = head; 
        while (cur != null) {
            if (cur.val < x) {
                smallTail.next = cur;
                smallTail = smallTail.next;
            } else {
                bigTail.next = cur;
                bigTail = bigTail.next;
            }
            cur = cur.next;
        }

        bigTail.next = null;
        smallTail.next = bigDummy.next;
        
        return smallDummy.next;
    }

}
