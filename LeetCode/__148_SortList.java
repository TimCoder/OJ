package tim.leetcode;

public class __148_SortList {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }
    

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode cur =  head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode node;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                node = p1;
                p1 = p1.next;
            } else {
                node = p2;
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
                    
        return head.next;
    }

    /*
     * Test Case:
     *      1. null
     *      2. 1
     *      3. 1,3
     *      4. 3,1
     *      5. 1,3,5
     *      6. 1,5,3
     *      7. 3,1,5
     *      8. 3,5,1
     *      9. 5,1,3
     *     10. 5,3,1
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        //l: 3,1,5
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode firstHead = dummy.next, secondHead = slow.next;
        slow.next = null;
        firstHead = sortList(firstHead);
        secondHead = sortList(secondHead);
        return mergeTwoLists(firstHead, secondHead);
    }

}
