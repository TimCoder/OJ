package tim.leetcode;

import tim.leetcode.__21_MergeTwoSortedLists.ListNode;

public class __23_MergeKSortedLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }
    
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

    /*
     * k / 2 ,use mergeTwoLists() function
     * Test Case: 
     *      0. k = 2
     *      1. k = 3 
     *      2. k = 4
     *      3. k = 5
     *      [[2],[],[-1]]
    */ 
    public ListNode mergeKLists(ListNode[] lists) {

        int length = lists.length;
        if (lists == null || length == 0) {
            return null;
        }

        boolean isOdd;
        if (length % 2 != 0) {
            isOdd = true;
        } else {
            isOdd = false;
        }
        while (length > 1) {
            int j = 0;
            for (int i = 0; i + 1 < length; i = i + 2, ++j) {
                lists[j] = mergeTwoLists(lists[i], lists[i+1]);
            }

            if (isOdd) {
                lists[j] = lists[length-1];
                length = length / 2 + 1;
            } else {
                length = length / 2;
            }

            if (length % 2 != 0) {
                isOdd = true;
            } else {
                isOdd = false;
            }
        }

        return lists[0];
    }

}
