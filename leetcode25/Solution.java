/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Boundary
        int length=0;
        ListNode t = head; //To get the length
        while ( t!=null ) { length++; t=t.next; };
        if ( length<k ) return head;
        if ( k<=1 ) return head;

        // Find the return node
        ListNode ret = head;
        for (int i=0; i<k-1; i++) ret=ret.next;
        // Start to reverse
        ListNode[] tmp = new ListNode[k+1]; //To store the k nodes
        tmp[k] = head;
        for ( int times=0; times<length/k; times++ ) {
            for ( int i=0; i<k; i++ ) // To put k nodes to tmp, and the next one to tmp[k]
                { tmp[i] = tmp[k]; tmp[k]=tmp[k].next; }
            for ( int i=k-1; i>0; i-- ) // To link the nodes except the first one
                { tmp[i].next = tmp[i-1]; }
            if ( times==length/k-1 ) // Discuss how the first node links
                tmp[0].next = tmp[k];
            else {
                ListNode nextK = tmp[k];
                for (int i=0; i<k-1; i++) nextK = nextK.next;
                tmp[0].next = nextK;
            }
        }
        return ret;
    }
}