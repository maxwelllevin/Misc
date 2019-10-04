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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return doublePreOrderTraverseSum(t1, t2);
    }
    
    private TreeNode doublePreOrderTraverseSum(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = doublePreOrderTraverseSum(t1.left, t2.left);
        t1.right = doublePreOrderTraverseSum(t1.right, t2.right);
        return t1;
    }
    
    // If modifying existing TreeNode not allowed:
    // private TreeNode doublePreOrderTraverseSum(TreeNode t1, TreeNode t2) {
    //     if (t1 == null) return t2;
    //     if (t2 == null) return t1;
    //     TreeNode curr = new TreeNode(t1.val + t2.val);
    //     curr.left = doublePreOrderTraverseSum(t1.left, t2.left);
    //     curr.right = doublePreOrderTraverseSum(t1.right, t2.right);
    //     return curr;
    // }
    
}
