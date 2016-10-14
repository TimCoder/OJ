package tim.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class __144_BinaryTreePreorderTraversal {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }
    

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
        
    }
    
    /*
     * Non-Recursive 1.
     */
    /*
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }

        return result;
        
    }
    */

    /*
     * Recursive solution.
     */
    /*
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root != null) {
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        return result;
        
    }
    */

}
