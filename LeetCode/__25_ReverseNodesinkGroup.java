package tim.leetcode;

public class __25_ReverseNodesinkGroup {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }
 
    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        ListNode cur = tail.next;
        ListNode newHead = head;
        while (cur != null) {
            tail.next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = tail.next;
        }

        return newHead;
    }
    
    /*
     * Test Case:
     *      1. l: 1, 2, 3, 4, 5  k: 2  result: 2, 1, 4, 3, 5
     *      2. l: 1, 2, 3, 4, 5  k: 3  result: 3, 2, 1, 4, 5
    */
    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 1) {
            return head;
        }
        
        ListNode temp = head;
        int length = 0;
        while (temp != null) { 
            ++length;
            temp = temp.next;
        }
        int loopCount = length / k;
        ListNode resultHead = head;
        ListNode tail = head;
        ListNode preTail = tail;
        ListNode cur = head;
        ListNode curHead = head;
        for (int i = 0; i < loopCount; ++i) {
            if (cur != null) {
                cur = cur.next;
            }
            for (int j = 0; j < k - 1 && cur != null; ++j) {
                tail.next = cur.next;
                cur.next = curHead;
                curHead = cur;
                cur = tail.next;
            }
            if (i == 0) {
                resultHead = curHead; 
            } else {
                preTail.next = curHead;
            }
            preTail = tail;
            tail = cur;
            curHead = cur;
        }

        return resultHead;
    }

    public static void createList(ListNode head, int[] a) {
        for (int i = 0; i < a.length; ++i) {
            ListNode node = new ListNode(a[i]);
            head.next = node;
            head = node;
        }
    }
    
    public static void showList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        int[] a = {2,3,4,5};
        ListNode head = new ListNode(1);
        createList(head, a);
        showList(head);
        System.out.println();
        ListNode result = __25_ReverseNodesinkGroup.reverseKGroup(head, 2);
        showList(result);
    }

}
