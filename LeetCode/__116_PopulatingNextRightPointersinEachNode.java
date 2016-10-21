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

}
