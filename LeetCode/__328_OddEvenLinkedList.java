package tim.leetcode;

public class __328_OddEvenLinkedList {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    } 
    
    /*
     * Test Case:
     *      1. null 
     *      2. 1    
     *      3. 1,2
     *      4. 1,2,3
     *      5. 1,2,3,4
    */
    public ListNode oddEvenList(ListNode head) { 

        ListNode oddHead = new ListNode(0);
        oddHead.next = head;
        ListNode oddCur = oddHead;

        ListNode evenHead = new ListNode(0);
        evenHead.next = head;
        ListNode evenCur = evenHead;
        int count = 1;
        boolean isOdd = true;
        ListNode cur = head; 
        while (cur != null) {
            if (isOdd) {
                oddCur.next = cur;
                oddCur = oddCur.next;
                isOdd = !isOdd;
            } else {
                evenCur.next = cur;
                evenCur = evenCur.next;
                isOdd = !isOdd;
            }
            cur = cur.next;
        }
        evenCur.next = null;
        oddCur.next = evenHead.next; 

        return oddHead.next; 
    }

}
