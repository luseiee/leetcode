# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        if head == None:
            return head
        tmp = head
        count = 1
        while tmp.next != None:
            count += 1
            tmp = tmp.next
        tmp.next = head
        tmp = head
        for i in range(count - k % count - 1):
            tmp = tmp.next
        ret = tmp.next
        tmp.next = None
        return ret
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        