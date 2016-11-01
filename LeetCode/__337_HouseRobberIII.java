package tim.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class __337_HouseRobberIII {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    /*
     * From bottom to top.
     * Deep First && Post Order traversal.
     * time: O(N). using 2ms.
    */
    public int rob(TreeNode root) {

        int[] ans = robHelper(root);

        return Math.max(ans[0], ans[1]);

    }

    public int robHelper(TreeNode root) {

        int[] res = new int[2];
        if (root == null) {
            return res;
        }

        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    /*
     * Recursion with memory, from top to bottom.
     * time:O(N). using 9ms. 
    */
    /*
    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int val = root.val;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        val =  Math.max(val, rob(root.left) + rob(root.right));
        map.put(root, val);

        return val;

    }
    */

    /*
     * Recursion, from top to bottom.
     *  time:O(N^2). using 1025ms. 
    */ 
    /*
    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int val = root.val;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val, rob(root.left) + rob(root.right));

    }
    */

    /*
     *  WA, time O(N), space O(N)
     *  test case: [3,1,5,2]
     */
    /*
    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int preRob = root.val, rob = preRob;
        int preSkip = 0, skip;
        
        Queue<TreeNode> q = new LinkedList<>();
        if (root.left != null) {
            q.offer(root.left);
        }
        if (root.right != null) {
            q.offer(root.right);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                levelSum += node.val;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            rob = Math.max(preSkip + levelSum, preRob);
            skip = preRob;

            preRob = rob;
            preSkip = skip;
        }

        return rob;

    }
    */

}
