package tim.interview;

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class DistanceInTree { 
    
    private StringBuilder maxcodec;
    private StringBuilder mincodec;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    
    public int getDis(TreeNode root) {
        
        preOrder(root, '0', new StringBuilder());
        
        int max = Math.max(maxcodec.length(), mincodec.length());
        int i = 0;
        for (; i < max; ++i) {
            if (maxcodec.charAt(i) != mincodec.charAt(i)) {
                break;
            }
        }
        
        int res = maxcodec.length() - i + mincodec.length() - i;
        
        return res;
    }   

     public void preOrder(TreeNode node, char c, StringBuilder sb) {
        if (node != null) {
            sb.append(c);
            if (node.left == null && node.right == null) {
                if (node.val > max) {
                    max = node.val;
                    maxcodec = sb;
                    return ;
                }   
                if (node.val < min) {
                    min = node.val;
                    mincodec = sb;
                    return ;
                }   
            }   

            if (node.left != null) {
                preOrder(node.left, '1', new StringBuilder(sb));
            }

            if (node.right != null) {
                preOrder(node.right, '0', new StringBuilder(sb));
            }
        }
    }

}