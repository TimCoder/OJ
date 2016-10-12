package tim.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class __103_BinaryTreeZigzagLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }


    //using 2 stack, more space less time than second algorithm.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        
        currLevel.push(root);
        boolean normalOrder = true;

        while (!currLevel.isEmpty()) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);

                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }

            result.add(currLevelResult);
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }

        return result;
    }

    //using queue, and reverse list, more time less spqce than first algorithm.
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
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
