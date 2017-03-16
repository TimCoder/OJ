package tim.targetOffer;

public class Mirror {
    public void Mirror(TreeNode r) {
        if (r != null) {
            TreeNode tmp = r.left;
            r.left = r.right;
            r.right = tmp;

            Mirror(r.left);
            Mirror(r.right);
        }
    }
}
