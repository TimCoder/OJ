package tim.targetOffer;

public class reConstructBinaryTree {
    //pre: 1,2,4,7,3,5,6,8
    //in : 4,7,2,1,5,3,8,6
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null) {
            return null;
        }
        return reConstruct(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode reConstruct(int[] pre, int[] in, int s1, int e1, int s2, int e2) {
        if (s1 > e1 || s2 > e2) {
            return null;
        }

        TreeNode root = new TreeNode(pre[s1]);
        int mid = Integer.MAX_VALUE;
        for (int i = s2; i <= e2; ++i) {
            if (in[i] == pre[s1]) {
                mid = i;
                break;
            }
        }
        root.left = reConstruct(pre, in, s1 + 1, s1 + mid - s2, s2, mid - 1);
        root.right = reConstruct(pre, in, s1 + mid - s2 + 1, e1, mid + 1, e2);

        return root;
    }

}
