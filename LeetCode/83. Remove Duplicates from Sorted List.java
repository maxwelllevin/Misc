/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode traverse = head.next;
        ListNode previous = head;
        while (traverse != null) {
            if (previous.val == traverse.val) {
                traverse = traverse.next;
            }
            else {
                previous.next = traverse;
                previous = previous.next;
            }
        }
        previous.next = null;
        return head;
       
    }
}
