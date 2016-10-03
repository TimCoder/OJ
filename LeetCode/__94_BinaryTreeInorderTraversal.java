package tim.leetcode; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class __94_BinaryTreeInorderTraversal {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }
    
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) { 
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);  
            cur = cur.right; 
        }

        return list;
    }


    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right); 
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            while (cur.left != null && !set.contains(cur.left)) {
                stack.push(cur.left);
                cur = cur.left;
            }
            list.add(cur.val);
            set.add(cur);
            stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        return list;
    }

    class TreeNodeVisit extends TreeNode{
        boolean isVisited;
        TreeNodeVisit(int x) {
            super(x);
        }

        TreeNodeVisit(TreeNode node) {
            super(node.val);
            this.left = node.left;
            this.right = node.right;
        }
    }
    
    // Memory Limit Exceeded
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNodeVisit> stack = new Stack<TreeNodeVisit>();
        if (root == null) {
            return list;
        }
        stack.push(new TreeNodeVisit(root));
        while (!stack.isEmpty()) {
            TreeNodeVisit cur = stack.peek();
            while (cur.left != null && cur.isVisited == false) {
                stack.push(new TreeNodeVisit(cur.left));
                cur = new TreeNodeVisit(cur.left);
            }
            list.add(cur.val);
            cur.isVisited = true;
            stack.pop();
            if (cur.right != null) {
                stack.push(new TreeNodeVisit(cur.right));
            }
        }

        return list;
    }
    
}
