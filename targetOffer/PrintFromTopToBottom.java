package tim.targetOffer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                TreeNode tmp = q.poll();
                level.add(tmp.val);
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            }
            res.addAll(level);
        }

        return res;
    }
}
