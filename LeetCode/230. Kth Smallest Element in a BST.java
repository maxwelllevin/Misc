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
    
    /**
    ** Returns the kth smallest value in a binary seach tree.
    ** @param {TreeNode} root   The binary search tree.
    ** @param {int} k           Indicates the kth smallest element to return.
    */
    public int kthSmallest(TreeNode root, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        if (buildStack(root, k, stack)) {return stack.pop();}
        return Integer.MIN_VALUE;  // There are less than k elements in the tree
    }
    
    /**
    ** Populates the given Deque object until it reaches size k.
    ** Elements are added from a binary search tree root in ascending order.
    ** @param {TreeNode} root           The binary search tree.
    ** @param {int} k                   The number of elements permitted in the Deque object.
    ** @param {Deque<Integer>} stack    The LIFO stack to add elements to.
    */
    private boolean buildStack(TreeNode root, int k, Deque<Integer> stack) {
        if (root == null) return false;
        boolean left = buildStack(root.left, k, stack);
        if (stack.size() != k) stack.push(root.val);
        if (left || stack.size() == k) return true;
        return buildStack(root.right, k, stack);
    }
}
