/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSum(root, sum, 0);
    }
    
    private boolean hasPathSum(TreeNode root, int target, int currentPathSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val + currentPathSum == target;
        return hasPathSum(root.left, target, currentPathSum + root.val) || hasPathSum(root.right, target, currentPathSum + root.val);
    }
}
