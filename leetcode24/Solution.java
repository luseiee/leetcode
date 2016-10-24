/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {
        if ( head==null ) return head;
        if ( head.next==null ) return head;
        ListNode ret = head.next;
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        while (true) {
            if (l2.next!=null) l3=l2.next;
            if (l3.next!=null) l4=l3.next;
            if (l2.next==null) {
                l2.next = l1;
                l1.next = null;
                break;
            }
            else if (l2.next.next==null) {
                l1.next = l2.next;
                l2.next = l1;
                break;
            }
            else {
                l1.next = l2.next.next;
                l2.next = l1;
            }
            l1 = l3;
            l2 = l4;
        }
        return ret;
    }
}