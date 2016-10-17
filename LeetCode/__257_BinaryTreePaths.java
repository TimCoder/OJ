package tim.leetcode;

import java.util.ArrayList;
import java.util.List;

public class __257_BinaryTreePaths {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    } 
    
    private List<String> result = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return result;
        }

        String s = String.valueOf(root.val);
        sb.append(s);
        getNodeInPath(root);
        
        return result;

    }

    public void getNodeInPath(TreeNode root) {
    
        if (root.left == null && root.right == null) {
            result.add(sb.toString()); 
            return ;
        } 
        
        if (root.left != null) {
            String s = "->" + root.left.val;
            sb.append(s);
            getNodeInPath(root.left);
            sb.delete(sb.length() - s.length(), sb.length());
        }

        if (root.right != null) {
            String s = "->" + root.right.val;
            sb.append(s);
            getNodeInPath(root.right); 
            sb.delete(sb.length() - s.length(), sb.length());
        }

    }
    
}
