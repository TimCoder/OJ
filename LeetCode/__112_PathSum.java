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

        return hasPathSumHelper(root, sum);

    }

    public boolean hasPathSumHelper(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                return true;
            }
        }

        return hasPathSumHelper(root.left, sum) || hasPathSumHelper(root.right, sum);

    }

}
