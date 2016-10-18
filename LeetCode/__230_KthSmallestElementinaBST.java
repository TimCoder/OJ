package tim.leetcode;

public class __230_KthSmallestElementinaBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {

        int i = getIndex(root.left) + 1;
        if (k == i) {
            return root.val;
        } else if (k < i) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - i); 
        }
        
    }

    public int getIndex(TreeNode root) {

        if (root == null) { 
            return 0;
        }

        return 1 + getIndex(root.left) + getIndex(root.right);

    }

}
