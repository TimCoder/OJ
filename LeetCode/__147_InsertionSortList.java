package tim.leetcode;

public class __147_InsertionSortList {

    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    public int getLength(ListNode head) {

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            ++length; 
            cur = cur.next;
        }
        return length;
    }

    /*
     * Test Case:
     *      1. null
     *      2. 1
     *      3. 1,3
     *      4. 3,1
     *      5. 1,2,3
     *      6. 1,3,2
     *      7. 2,1,3
     *      8. 2,3,1
     *      9. 3,1,2
     *     10. 3,2,1
     */
    public ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preTemp = dummy;
        ListNode curTemp = preTemp.next;
        ListNode pre = head;
        ListNode cur = pre.next;
        //2,1,3
        //3,2,1
        while (cur != null) {
            preTemp = dummy;
            curTemp = preTemp.next;
            while (curTemp != cur) {
                if (cur.val <= curTemp.val) {
                    ListNode node = new ListNode(cur.val);
                    node.next = curTemp;
                    preTemp.next = node;
                    break; 
                }
                preTemp = preTemp.next;
                curTemp = curTemp.next;
            }
            if (curTemp != cur) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        pre.next = null;

        return dummy.next;
    }
}
