package tim.leetcode;

public class __404_SumofLeftLeaves {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        getLeftLeaves(root.left, false);
        getLeftLeaves(root.right, true);

        return sum;
        
    }

    public void getLeftLeaves(TreeNode root, boolean isRight) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (!isRight) {
                sum += root.val;
            }  
        } else {
            getLeftLeaves(root.left, false);
            getLeftLeaves(root.right, true);
        }

    }

}
