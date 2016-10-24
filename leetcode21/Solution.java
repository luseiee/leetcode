//Remember to remove class Listnode before Submit

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {

    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Boundary
        if ( l1==null ) return l2;
        if ( l2==null ) return l1;
        // Start and set the first node
        ListNode ret = new ListNode(0);
        if ( l1.val<l2.val ) {
            ret.val = l1.val;
            l1 = l1.next;
        }
        else {
            ret.val = l2.val;
            l2 = l2.next;
        }
        ListNode tmp = ret;
        // Start to sort until one list is null
        while ( true ) {
            if ( l1==null ) { tmp.next = l2; break;}
            if ( l2==null ) { tmp.next = l1; break;}
            if ( l1.val<l2.val ) {
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            }
            else {
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        return ret;
    }
}