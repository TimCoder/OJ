package tim.leetcode;

public class __129_SumRoottoLeafNumbers {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    private int sum = 0;

    public int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }

        getSum(root, 0);

        return sum;

    }

    public void getSum(TreeNode root, int path) {

        path = path * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += path;
            return ;
        }

        if (root.left != null) {
            getSum(root.left, path);
        }

        if (root.right != null) {
            getSum(root.right, path);
        }

        return ;

    }

}
