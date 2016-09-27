package tim.leetcode;

public class __160_IntersectionofTwoLinkedLists {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        int countEndA = 0;
        int countEndB = 0;
        while (curA != curB && countEndA < 2 && countEndB < 2) {
            if (curA.next == null) {
                curA = headB;
                ++countEndA;
            } else {
                curA = curA.next;
            }

            if (curB.next == null) {
                curB = headA;
                ++countEndB;
            } else {
                curB = curB.next;
            }
        }
        if (curA == curB) {
            return curA;
        }

        return null;
    }

}
