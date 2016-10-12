package tim.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class __103_BinaryTreeZigzagLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        boolean isFromLeft = true;
        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (!isFromLeft) {
                Collections.reverse(level);
            } 
            result.add(level); 
            isFromLeft = !isFromLeft;
        }

        return result;
    }

}
