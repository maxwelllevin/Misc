# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head == None or head.next == None:
            return head;
        
        result = ListNode(-1)
        builder = result
        
        while head != None:
            if head.next != None and head.val == head.next.val:
                val = head.val
                while head != None and head.val == val:
                    head = head.next
            else:
                builder.next = head
                builder = builder.next
                head = head.next
                
        builder.next = None
        return result.next
        
