package tim.leetcode;

public class __199_BinaryTreeRightSideView {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();  
                if (i == 0) {
                    result.add(cur.val);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
            }
        }
                
        return result;

    }

}
