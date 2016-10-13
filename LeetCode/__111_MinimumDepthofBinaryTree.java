package tim.leetcode;

public class __111_MinimumDepthofBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }
    
    boolean isRoot = true;
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        
        if (isRoot) {
            isRoot = !isRoot;
            if (root.left == null) {
                return 1 + minDepth(root.right);
            }
            if (root.right == null) {
                return 1 + minDepth(root.left);
            }
        }
        
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        
    }

}
