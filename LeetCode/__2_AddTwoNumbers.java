package tim.leetcode;

/*
 *
 * Test Case: 
 *      1. l1: null  l2: null
 *      2. l1: null  l2: 0 
 *      3. l1: null  l2: 0, 1 
 *      4. l1: 0     l2: 0 
 *      5. l1: 1     l2: 9 
 *      6. l1: 0     l2: 0, 0 
 *      7. l1: 9     l2: 1, 0 
 *      8. l1: 9     l2: 1, 9 
 *      9. l1: 9, 0   l2: 1, 9 
*/

public class __2_AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int v, v1, v2;
        int inc = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            v1 = p1.val;
            v2 = p2.val;
            v = v1 + v2 + inc;  
            ListNode node = new ListNode(v % 10);
            inc = v / 10; 
            cur.next = node;
            cur = node;
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode p = null; 
        if (p1 != null) {
            p = p1;
        } else if (p2 != null) {
            p = p2;
        } 

        while (p != null) {
            v = p.val + inc;
            ListNode node = new ListNode(v % 10);
            inc = v / 10;
            cur.next = node;
            cur = node;
            p = p.next;
        }

        if (inc != 0) {
            ListNode node = new ListNode(inc);
            cur.next = node;
        }

        return pre.next;
    }
    
}
