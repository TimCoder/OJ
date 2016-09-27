package tim.leetcode;

public class __82_RemoveDuplicatesfromSortedListII {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        //input check
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        ListNode post = cur.next;
        //1,1
        boolean isDup = false;
        while (post != null) {
            if (post.val == cur.val) {
                isDup = true;
                post = post.next;
            } else {
                if (!isDup) {
                    pre = pre.next;
                    cur = cur.next;
                } else {
                    cur = post;
                    pre.next = cur;         
                }
                isDup = false;
                post = post.next;
            }
        }
        //when last node still duplicate
        if (isDup) {
            pre.next = null;
        }

        return dummy.next; 
    } 

}
