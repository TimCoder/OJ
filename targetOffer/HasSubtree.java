package tim.targetOffer;

public class HasSubtree {
    public boolean HasSubtree(TreeNode r1,TreeNode r2) {
        boolean res = false;
        if (r1 != null && r2 != null) {
            res = hasSubtreeHelper(r1, r2);
            if (!res) {
                res = HasSubtree(r1.left, r2);
            }
            if (!res) {
                res = HasSubtree(r1.right, r2);
            }
        }

        return res;
    }

    public boolean hasSubtreeHelper(TreeNode r1, TreeNode r2) {

        if (r2 == null) {
            return true; 
        }

        if (r1 == null) {
            return false;
        }

        if (r1.val != r2.val) {
            return false;
        }

        return hasSubtreeHelper(r1.left, r2.left) && hasSubtreeHelper(r1.right, r2.right); 
    }
}
