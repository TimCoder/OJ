package tim.leetcode;

public class __24_SwapNodesinPairs {

    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    /*
     *  Test Case:
     *       0. null
     *       1. 1
     *       2. 1, 2
     *       3. 1, 2, 3
     *       4. 1, 2, 3, 4
     *       5. 1, 2, 3, 4, 5
     *
    */  
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode post;
        while (cur != null && cur.next != null) {
            post = cur.next;
            pre.next = post;
            pre = cur;
            cur.next = post.next;
            post.next = cur;
            cur = cur.next;  
        }

        return dummy.next;
    } 

}
