package tim.leetcode;


public class __61_RotateList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }

    /*
     * Test Case:
     *      0. l: 1,2,3,4,5 k: 0,1,2,3,4,5,6,7    
     *      1. l: null;     k: 1        
     *      2. l: 1         k: 1,2
     *      3. l: 1,2       k: 1,2,3
    */
    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return head;
        }
         
        int length = getLength(head);
        k = k % length;   
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy; 
        for (int i = 0; i < k; ++i) { 
            //use newK to goto position instead of change fast by cycle.
            //Otherwise,when k is large,there will be too many cycle and takes a long time.
            //k is less than length
            // if (fast.next == null) {
            //     return head;
            // }
            fast = fast.next;  
        } 
        
        //make fast node point to the last node
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //when k equals the length of list, 
        //fast.next must point to dummy.next instead of head.
        //Otherwise,there will be a cycle.
        fast.next = dummy.next; 
        ListNode resultHead = slow.next;
        slow.next = null;

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
        int[] a = {2};
        ListNode head = new ListNode(1);
        createList(head, a);
        showList(head);
        System.out.println();
        ListNode result = __61_RotateList.rotateRight(head, 3);
        showList(result);
    }

    
}
