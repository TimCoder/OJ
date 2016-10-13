package tim.leetcode;

public class __112_PathSum {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }


    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        return hasPathSumHelper(root, 0, sum);

    }

    public boolean hasPathSumHelper(TreeNode root, int cur, int sum) {

        if (root == null) {
            return false;
        }

        cur = cur + root.val;
        if (root.left == null && root.right == null) {
            if (cur == sum) {
                return true;
            }
        }

        return hasPathSumHelper(root.left, cur, sum) || hasPathSumHelper(root.right, cur, sum);

    }

}
