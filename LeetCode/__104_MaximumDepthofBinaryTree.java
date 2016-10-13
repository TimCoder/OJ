package tim.leetcode;

public class __104_MaximumDepthofBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } 

        return 1 + (int)Math.max(maxDepth(root.left), maxDepth(root.right)); 
        
    }

}
