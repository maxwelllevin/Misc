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
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new LinkedList<Double>();
        List<Double> result = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double avg = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                avg += curr.val;
                if (curr.left != null) {q.add(curr.left); }
                if (curr.right != null) {q.add(curr.right);}
            }
            result.add((1.0 * avg) / size);
        }
        return result;
    }
}
