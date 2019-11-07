/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        ListNode res = new ListNode(-1);
        res.next = head;
        
        ListNode I = res, J = head;
        
        // Advance J by n places (So I is n+1 away from J)
        for (int j = 0; j < n; j++) { J = J.next; }
        
        // Advance I and J until J reaches the end
        while (J != null) {
            I = I.next;
            J = J.next;
        }
        
        I.next = I.next.next;
        
        return res.next;
    }
}
