package tim.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class __145_BinaryTreePostorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                map.put(cur, 1);
                cur = cur.left;
            }
            cur = stack.pop();
            int cnt = map.get(cur);
            if (cnt != 0) {
                map.put(cur, --cnt);  
                stack.push(cur);
                cur = cur.right; 
            } else {
                result.add(cur.val);
                cur = null;
            }
        }

        return result;

    }

}
