package tim.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class __101_SymmetricTree {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int x) {
            val = x;
        }
    }


    public boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }   

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if (left == null && right ==null) {
                continue;
            }
            
            if ((left != null && right == null) || (left == null && right != null) || (left.val != right.val)) {
                return false;
            }   
            
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }   

        return true;
         
    }



    /*
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isSymetricHelper(root.left, root.right);
    }

    public boolean isSymetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        
        return isSymetricHelper(left.left, right.right) && isSymetricHelper(left.right, right.left);
    }
    */



    /*
    //left and right traversal 2 times, compare the 2 sequence is equal?
    // Algorithm is Wrong!
    //e.g: [1,2,3,3,null,2,null]
    //     1
    //   2   3 
    //  3   2  
    List<Integer> list = new ArrayList<Integer>();

    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right); 
        }
        return;
    }
     
    List<Integer> list2 = new ArrayList<Integer>();

    public void reInorderTraversal(TreeNode root) {   
        if (root != null) {
            reInorderTraversal(root.right);
            list2.add(root.val);
            reInorderTraversal(root.left); 
        }
        return;
    } 
    
    public boolean isSymmetric2(TreeNode root) { 
        inorderTraversal(root);
        reInorderTraversal(root);
        if (list.size() != list2.size()) {
            return false;
        }
        int length = list.size();
        for (int i = 0; i < length; ++i) {
            if (list.get(i) != list2.get(i)) { 
                return false;
            }
        }
        return true;
    }
    */
}
