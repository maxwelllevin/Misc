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
    public int closestValue(TreeNode root, double target) {
        return closestValue(root, target, root.val);
    }
    
    private int closestValue(TreeNode root, double target, int closest) {
        if (root == null) return closest;
        if (root.val == target) return root.val;
        if (Math.abs(root.val - target) < Math.abs(closest - target)) closest = root.val;
        if (target < root.val) return closestValue(root.left, target, closest);
        return closestValue(root.right, target, closest);
    }
}
