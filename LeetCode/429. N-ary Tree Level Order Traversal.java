/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (root == null) return results;
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                level.add(curr.val);
                for (Node child : curr.children) {
                    q.add(child);
                }
            }
            results.add(level);
        }
        return results;
    }
}
