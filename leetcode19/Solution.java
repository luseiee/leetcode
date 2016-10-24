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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode tmp = head;
        while ( tmp!=null ) {
            System.out.print( tmp.val + " " );
            tmp = tmp.next;
        }
        System.out.println();
        head = removeNthFromEnd( head, 2 );
        tmp = head;
        while ( tmp!=null ) {
            System.out.print( tmp.val + " " );
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode tmp = head;
        //Get the length of the List
        int length = 0;
        while (tmp!=null) {
            length ++;
            tmp = tmp.next;
        }
        //Boundary situation 1
        if ( length==0 ) return head;
        if ( n==0 ) return head;
        if ( length==1 && n==1 ) return null;
        if ( n==length ) return head.next;
        //Locate the previous node of the one need to be deleted
        tmp = head;
        for (int i=0; i<length-n-1; i++) {
            tmp = tmp.next;
        }
        //Boundary situation 2
        if ( n==1 ) 
            tmp.next = null;
        else 
            tmp.next = tmp.next.next;
        return head;

    }
}