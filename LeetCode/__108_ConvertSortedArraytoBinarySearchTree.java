package tim.leetcode;

public class __108_ConvertSortedArraytoBinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return buildTree(nums, 0, nums.length - 1);
    }

    // include start, end
    public TreeNode buildTree(int[] nums, int start, int end) {
        
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, start, mid - 1);
        node.right = buildTree(nums, mid + 1, end);
        
        return node;

    }
    
}
