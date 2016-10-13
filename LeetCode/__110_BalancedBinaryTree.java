package tim.leetcode;

public class __110_BalancedBinaryTree {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    /*
     * bottom to top
     * using less time, but stackoverflow.
     */
    /*
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        isBalanced(root.left);
        isBalanced(root.right);
        int lH = getHeight(root.left);
        int rH = getHeight(root.right);
        if (Math.abs(lH - rH) > 1) {
            return false;
        }
    }
    */

    /*
     * top to bottom
     * using more time 
     */
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int lH = getHeight(root.left);
        int rH = getHeight(root.right);
        if (Math.abs(lH - rH) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int getHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + (int)Math.max(getHeight(root.left), getHeight(root.right));

    }
}
