package tim.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class __116_PopulatingNextRightPointersinEachNode {

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

        TreeLinkNode curCur = root;
        TreeLinkNode curNext = curCur.left;
        while (curCur != null && curNext != null) {
            TreeLinkNode preNext = null;
            while (curCur != null) {
                if (preNext == null) {
                    preNext = curCur.left;
                } else {
                    preNext.next = curCur.left;
                    preNext = preNext.next;
                }
                preNext.next = preNext.right;
                preNext = preNext.next;
                curCur = curCur.next;
            }
            curCur = curNext;
            curNext = curCur.next;
        }
        
    }
    


    /*
     * AC,but space O(N) and using more time
     */
    /*
    public void connect(TreeLinkNode root) {
        
        if (root == null) {
            return ;
        }

        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            TreeLinkNode pre = null;
            for (int i = 0; i < levelSize; ++i) {
                TreeLinkNode cur = q.poll();
                if (pre != null) {
                    pre.next = cur;
                }   
                pre = cur;

                if (cur.left != null) {
                    q.offer(cur.left);
                }   

                if (cur.right != null) {
                    q.offer(cur.right);
                }   

                if (i == levelSize - 1) {
                    cur.next = null;
                }   
            }   
        }   

    }
    */

}
