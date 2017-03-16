package tim.targetOffer;

public class HasSubtree {
    public boolean HasSubtree(TreeNode r1,TreeNode r2) {
        if (r1 != null && r2 != null) {
            if (hasSubtreeHelper(r1, r2)) {
                return true;
            }
            boolean res1 = false;
            if (r1.left != null) {
                res1 = HasSubtree(r1.left, r2);
            }
            boolean res2 = false;
            if (r1.right != null) {
                res2 = HasSubtree(r1.right, r2);
            }
            return res1 || res2;
        }

        return false;
    }

    public boolean hasSubtreeHelper(TreeNode r1, TreeNode r2) {

        if (r2 == null) {
            return true; 
        }

        if (r1 == null) {
            return false;
        }

        if (r1.val == r2.val) {
            return hasSubtreeHelper(r1.left, r2.left) && hasSubtreeHelper(r1.right, r2.right); 
        }

        return false;
    }
}
