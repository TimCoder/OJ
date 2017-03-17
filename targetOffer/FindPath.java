package tim.targetOffer;

public class FindPath {

    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        findHelper(root, 0, target);
        return res;
    }

    
    public void findHelper(TreeNode cur, int sum, int target) {
        if (cur == null) {
            return ;
        }

        sum += cur.val;
        path.add(cur.val);
        if (cur.left == null && cur.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return ;
        }

        findHelper(cur.left, sum, target);
        findHelper(cur.right, sum, target);
        path.remove(path.size() - 1);

    }
}
