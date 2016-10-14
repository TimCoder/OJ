package tim.leetcode;

public class __235_LowestCommonAncestorofaBinarySearchTree {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (p == q) {
            return p;
        }

        if (p == root || q == root) {
            return root;
        }

        TreeNode small, large;
        if (p.val < q.val) {
            small = p;
            large = q;
        } else {
            small = q;
            large = p;
        }

        if (large.val < root.val) { 
            return lowestCommonAncestor(root.left, p, q);
        } else if (small.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
        
    }

}
