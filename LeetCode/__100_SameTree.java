package tim.leetcode;

public class __100_SameTree {
    
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        } 

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
