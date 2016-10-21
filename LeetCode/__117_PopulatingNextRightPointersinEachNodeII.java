package tim.leetcode;

public class __117_PopulatingNextRightPointersinEachNodeII {

    class TreeLinkNode {
        int val;
        TreeLinkNode left; 
        TreeLinkNode right; 
        TreeLinkNode next; 
        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {

        if (root == null) {
            return ;
        }

        if (root.left == null && root.right == null) {
            return ;
        }

        TreeLinkNode curCur = root;
        TreeLinkNode curNext;
        if (root.left != null) {
            curNext = root.left;
        } else {
            curNext = root.right;
        }
        
        while (curCur != null && curNext != null) {

            TreeLinkNode preNext = null;
            while (curCur != null) { 
                if (curCur.left == null && curCur.right == null) {
                    curCur = curCur.next;
                    continue;
                }
                if (preNext == null) {
                    if (curCur.left != null) {
                        preNext = curCur.left;
                    } else {
                        preNext = curCur.right;
                    }
                } else {
                    if (curCur.left != null) {
                        preNext.next = curCur.left; 
                        preNext = preNext.next;
                    } else {
                        preNext.next = curCur.right; 
                        preNext = preNext.next;
                    } 
                     
                }

                if (preNext == curCur.left) {
                    if (curCur.right != null) {
                        preNext.next = curCur.right;
                        preNext = preNext.next;
                    } 
                } 
                curCur = curCur.next;
            }

            curCur = curNext;
            while (curCur != null && curCur.left == null && curCur.right == null) {
                curCur = curCur.next;
            }

            if (curCur == null) {
                break;
            }
            if (curCur.left != null) {
                curNext = curCur.left;
            } else {
                curNext = curCur.right;
            }
        }
                
    }
            
}
