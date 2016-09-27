package tim.leetcode;

public class __21_MergeTwoSortedLists {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    
    /*
     * Test Case:
     *      1. l1: null         l2:null
     *      2. l1: null         l2:1
     *      3. l1: null         l2:1, 3
     *      4. l1: 1            l2:3
     *      5. l1: 1            l2:1, 3
     *      6. l1: 1, 2         l2:1, 3
     *      7. l1: 1, 2, 4      l2:1, 3 
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode cur =  dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode node;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                node = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                node = new ListNode(p2.val);
                p2 = p2.next;
            }
            cur.next = node;
            cur = cur.next;
        }

        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
                    
        return dummy.next;
    }
        
}



