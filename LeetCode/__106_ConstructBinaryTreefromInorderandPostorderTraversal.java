package tim.leetcode;

public class __106_ConstructBinaryTreefromInorderandPostorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length != postorder.length) {
            return null;
        }

        return getTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    //include both start and end
    public TreeNode getTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {

        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pEnd]);
        int rootInorderIndex = findRootInorderIndex(inorder, iStart, iEnd, root);

        int iStartL = iStart;
        int iEndL = rootInorderIndex - 1;
        int pStartL = pStart;
        int pEndL = pStartL + iEndL - iStartL;
        root.left = getTree(inorder, iStartL, iEndL, postorder, pStartL, pEndL);

        int iStartR = rootInorderIndex + 1;
        int iEndR = iEnd;
        int pStartR = pEndL + 1;
        int pEndR = pEnd - 1;
        root.right = getTree(inorder, iStartR, iEndR, postorder, pStartR, pEndR);

        return root;

    }

    public int findRootInorderIndex(int[] inorder, int start, int end, TreeNode root) {

        for (int i = start; i <= end; ++i) {
            if (inorder[i] == root.val) {
                return i;
            }
        }

        return Integer.MIN_VALUE;

    }

}
