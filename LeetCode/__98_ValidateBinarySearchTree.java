package tim.leetcode;

public class __98_ValidateBinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }
    

    public boolean isValidBST(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if (root.left != null) {
            int maxLeft = getMax(root.left); 
            if (root.val <= maxLeft) {
                return false;
            }
        }
        
        if (root.right != null) {
            int minRight = getMin(root.right);      
            if (root.val >= minRight) {
                return false;
            }
        }    
        
        return isValidBST(root.left) && isValidBST(root.right);

    }

    public int getMax(TreeNode root) {

        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            pre = cur;
            cur = cur.right;
        }

        return pre.val;

    } 

    public int getMin(TreeNode root) {

        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            pre = cur;
            cur = cur.left;
        }

        return pre.val;

    } 
    
}
