package tim.targetOffer;

public class Convert {

    private TreeNode last;

    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }

        conHelper(root);

        return cur;
    }

    public void conHelper(TreeNode node) {
        if (node == null) {
            return ;
        }

        if (node.left != null) {
            conHelper(node.left);
        }
        //set last node
        node.left = last;
        if (last != null) {
            last.right = node;
        }
        last = node;

        if (node.right != null) {
            conHelper(node.right);
        }
    }
}
