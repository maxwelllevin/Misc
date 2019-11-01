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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList<List<Integer>>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean zig = false;
        while (!q.isEmpty()) {
            List<Integer> r = new LinkedList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                r.add(curr.val);
                if (curr.left != null) {q.add(curr.left); }
                if (curr.right != null) {q.add(curr.right);}
            }
            if (zig) Collections.reverse(r);
            zig = !zig;
            result.add(r);
        }
        return result;
    }
}
