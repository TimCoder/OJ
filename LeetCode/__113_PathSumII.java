package tim.leetcode;

import java.util.ArrayList;
import java.util.List;

public class __113_PathSumII {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    private List<List<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> solution = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) {
            return result;
        }

        pathSumHelper(root, sum);

        return result;

    }

    public void pathSumHelper(TreeNode root, int sum) {
        
        if (root == null) {
            return;
        }

        sum = sum - root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                solution.add(root.val);
                result.add(new ArrayList<Integer>(solution));
                solution.remove(solution.size() - 1);
            }
            return ;
        }

        solution.add(root.val);
        pathSumHelper(root.left, sum);
        pathSumHelper(root.right, sum);
        solution.remove(solution.size() - 1);
        
    }


    /*
     *  each node new a temp ArrayList 
     *  cost more time
     */
    /*
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) {
            return result;
        }

        pathSumHelper(root, new ArrayList<Integer>(), 0, sum);

        return result;

    }

    public void pathSumHelper(TreeNode root, ArrayList<Integer> preList, int cur, int sum) {

        if (root == null) {
            return; 
        }

        ArrayList<Integer> curList = new ArrayList<>(preList);
        curList.add(root.val);
        cur = cur + root.val;
        if (root.left == null && root.right == null) {
            if (cur == sum) {
                result.add(curList);
            }
        }
        
        pathSumHelper(root.left, curList, cur, sum);
        pathSumHelper(root.right, curList, cur, sum);
    }
    */

}
