/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.HashSet;

class Solution {

    public boolean findTarget(TreeNode root, int target) {
        Set<Integer> seen = new HashSet();
        return search(root, target, seen);
    }
    
    private boolean search(TreeNode root, int target, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(target - root.val)) return true;
        set.add(root.val);
        return search(root.left, target, set) || search(root.right, target, set);
    }
    
}
