package tim.leetcode;

public class __109_ConvertSortedListtoBinarySearchTree {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST (ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        ListNode preSlow = new ListNode(0);
        preSlow.next = slow;
        //1,2,3,4
        //1
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            preSlow = preSlow.next;
        }
        preSlow.next = null;
        TreeNode root = new TreeNode(slow.val);
        ListNode left = head, right = slow.next;
        if (slow == head) {
            left = null;
        }
        root.left = sortedListToBST(left);
        root.right = sortedListToBST(right);

        return root;
    }

}
