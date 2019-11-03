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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int encounters = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.val == x) encounters++;
                if (curr.val == y) encounters++;
                if (encounters == 2) return true;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)) return false;
                }
            }
            if (encounters == 1) return false;
        }
        return false;
    }
}
