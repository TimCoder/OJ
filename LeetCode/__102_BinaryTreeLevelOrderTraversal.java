package tim.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class __102_BinaryTreeLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    /*
     * 每循环一次while判断，就遍历一层。
     * 通过每次入队的元素数目，来确定每层的元素数目。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            //必须先取出size,不能写出i<q.size(),因为for循环会改变q.size().
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
            result.add(level);
        }
        return result;
    }

    /*
     * WA, Error Case: [1,2,null,3,null,4,null,5]
     */
    /*
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        q.offer(root);            
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            list.offer(node);
            if (node != null) {
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        int level = (int)(Math.log(list.size()) / Math.log(2)) + 1;
        for (int i = 0; i < level; ++i) {
            int maxJ = (int)Math.pow(2, i);
            List<Integer> l = new ArrayList<Integer>();
            for (int j = 0; j < maxJ; ++j) {
                if (list.isEmpty()) {
                    break;
                }
                TreeNode node = list.poll();
                if (node != null) {
                    l.add(node.val);
                }
            }
            if (l.size() > 0) {
                result.add(l);
            }
        }

        return result;
    }
    */

}
