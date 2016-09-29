package tim.leetcode; 

import java.util.ArrayList;
import java.util.List;

public class __94_BinaryTreeInorderTraversal {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }

        List<Integer> list = new ArrayList<Integer>();

        public List<Integer> inorderTraversal2(TreeNode root) {
            if (root != null) {
                inorderTraversal2(root.left);
                list.add(root.val);
                inorderTraversal2(root.right); 
            }
            return list;
        }



        public List<Integer> inorderTraversal(TreeNode root) {
            if (root != null) {
                inorderTraversal(root.left);
                list.add(root.val);
                inorderTraversal(root.right); 
            }
            return list;
        }
    }
    
}
