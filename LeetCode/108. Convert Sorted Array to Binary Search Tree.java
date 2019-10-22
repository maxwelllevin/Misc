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
    
    public TreeNode sortedArrayToBST(int[] nums) {
        // optimal solution seems like root node is the middle element of array
        // left child is middle element of left half of the array
        // right child is middle element of right half of the array
        if (nums.length == 0) return null;
        return helper(0, nums.length - 1, nums);
    }
    
    private TreeNode helper(int left, int right, int[] nums) {
        if (left == right) return new TreeNode(nums[left]);
        if (left > right) return null;
        int mid = (right + left) / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = helper(left, mid - 1, nums);
        curr.right = helper(mid + 1, right, nums);
        return curr;
    }    
}
