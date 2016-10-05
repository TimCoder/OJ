package tim.leetcode;

import java.util.ArrayList;
import java.util.List;

public class __101_SymmetricTree {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int x) {
            val = x;
        }
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isSymetricHelper(root.left, root.right);
    }



    /*
    //left and right traversal 2 times, compare the 2 sequence is equal?
    // Algorithm is Wrong!
    //e.g: [1,2,3,3,null,2,null]
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
