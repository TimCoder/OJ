package tim.leetcode;

public class __237_DeleteNodeinaLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    /*
     * Test Case:
     *      1. l:null
     *      2. l:1      k:1
     *      3. l:1,2    k:1,2   
    */
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    } 

}
