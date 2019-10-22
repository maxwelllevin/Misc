/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// head: 1 2 3 4
// temp = head.next: 2
// head.next = head: 1
// head = temp: 2


class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode t = head.next;
        head.next = swapPairs(head.next.next);
        t.next = head;
        return t;
    }
}
