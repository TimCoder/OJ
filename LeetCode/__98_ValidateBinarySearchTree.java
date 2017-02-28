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
    
    /*
     * time O(N) 
    */
    private TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {

        // Traverse the tree in inorder.  
        if (root != null) {
            // Inorder traversal: left first.  
            if (!isValidBST(root.left)) {
                return false;
            }

            // Compare it with the previous value in inorder traversal.
            if (pre != null && root.val <= pre.val) {
                return false;
            }

            // Update the previous.
            pre = root;

            // Inorder traversal: right last.  
            if (!isValidBST(root.right)) {
                return false;
            }
        }

        return true;
    }

    /*
     // time O(N^2) 
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
    */ 

}
