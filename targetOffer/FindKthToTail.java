package tim.targetOffer;

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; ++i) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
