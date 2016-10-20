package tim.leetcode;

public class __222_CountCompleteTreeNodes {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * time O(log N * log N)
    */
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lH = 0, rH = 0;
        TreeNode l = root;
        TreeNode r = root;
        while (l != null) {
            ++lH;
            l = l.left;
        }
        while (r != null) {
            ++rH;
            r = r.right;
        }
        if (lH == rH) {
            return (2 << (lH - 1)) - 1;
            //using Math.pow,TLE.
            //return Math.pow(2, lH) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);

    }

    /*
     *  using binary search, time O(log N * log N).
     */
    /*
    private int h;
    private int cnt;
    private int binCnt = 0;

    public int countNodes(TreeNode root) {

        getHeight(root);
        
        return divideAndConquer(root);
        
    }   
    
    public int divideAndConquer(TreeNode root) {
        
        if (root == null || (root.left == null && root.right == null)) {
            return cnt;
        }
        
        int lH = checkLastLeftMid(root.left);
        int rH = checkLastRightMid(root.right);
        ++binCnt;

        if (lH != rH) {
            cnt -= (1 << (h - 1 - binCnt));
            //cnt -=  Math.pow(2, h - 1 - binCnt); 
            return cnt;
        } else {
            if (rH == h - binCnt) {
                return divideAndConquer(root.right);
            } else {
                cnt -= (1 << (h - 1 - binCnt));
                //cnt -=  Math.pow(2, h - 1 - binCnt); 
                return divideAndConquer(root.left);
            }
        }
        
    }
    
    public void getHeight(TreeNode root) {
        
        h = 0;
        while (root != null) {
            ++h;
            root = root.left;
        }
        cnt = (1 << h) - 1;
        //cnt = (int)Math.pow(2, h) - 1;

    }


    public int checkLastLeftMid(TreeNode root) {

        int tmpH = 0;
        while (root != null) {
            ++tmpH;
            root = root.right;
        }

        return tmpH;

    }

    public int checkLastRightMid(TreeNode root) {

        int tmpH = 0;
        while (root != null) {
            ++tmpH;
            root = root.left;
        }

        return tmpH;

    }


   
    */

    
    /* O(N), TLE.
    private int cnt = 0;

    public int countNodes(TreeNode root) {

        if (root != null) {
            ++cnt;
            countNodes(root.left);
            countNodes(root.right);
        }

        return cnt;
                
    }
    */

}
