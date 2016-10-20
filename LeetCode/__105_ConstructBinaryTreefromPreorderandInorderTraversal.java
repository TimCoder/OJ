package tim.leetcode;

public class __105_ConstructBinaryTreefromPreorderandInorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length ==0) {            
            return null;
        }

        return getTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    //array include both start and end;
    public TreeNode getTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {

        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        int rootInorderIndex = findRootInorder(inorder, iStart, iEnd, root);

        int iStartL = iStart;
        int iEndL = rootInorderIndex - 1; 
        int pStartL = pStart + 1;
        int pEndL = pStartL + iEndL - iStartL;
        root.left = getTree(preorder, pStartL, pEndL, inorder, iStartL, iEndL);

        int iStartR = rootInorderIndex + 1;
        int iEndR = iEnd;
        int pStartR = pEndL + 1;
        int pEndR = pEnd;
        root.right = getTree(preorder, pStartR, pEndR, inorder, iStartR, iEndR);

        return root;
    }

    public int findRootInorder(int[] inorder, int start, int end, TreeNode root) {

        for (int i = start; i <= end; ++i) {
            if (inorder[i] == root.val) {
                return i;
            }
        }

        return Integer.MIN_VALUE;

    }
}
