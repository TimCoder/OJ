package tim.targetOffer;

public class Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        while (cur1 != null) {
            cur.next = cur1;
            cur1 = cur1.next;
            cur = cur.next;
        }

        while (cur2 != null) {
            cur.next = cur2;
            cur2 = cur2.next;
            cur = cur.next;
        }

        return newHead.next;
    }
}
