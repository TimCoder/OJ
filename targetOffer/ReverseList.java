package tim.targetOffer;

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode newHead = new ListNode(0);
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next =  newHead.next;
            newHead.next = cur;
            cur = tmp;
        }

        return newHead.next;
    }
}
