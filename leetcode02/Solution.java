//Time Complexity O(N)
//It seems that when you submit the code, you shouldn't include ListNode Class
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode answer = addTwoNumbers(l1,l2);
		System.out.println( answer.val + " " + answer.next.val + " " + answer.next.next.val);

	}

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	//Get the first number and first carry
    	int carry = ( l1.val+l2.val ) / 10;
        ListNode answer = new ListNode( (l1.val+l2.val)%10 );
   		ListNode returnValue = answer;
        //Do the next numbers
        while ( true ) {
        	if ( l1.next!=null && l2.next!=null ) {
        		l1 = l1.next;
        		l2 = l2.next;
        		answer.next = new ListNode( (l1.val+l2.val+carry)%10 );
        		carry = ( l1.val+l2.val+carry ) / 10;
        		answer = answer.next;
        		continue;
        	}
        	if ( l1.next==null && l2.next==null ) {
        		if ( carry == 1 )
        			answer.next = new ListNode(1);
        		break;
        	}
        	if ( l1.next==null ) {
        		while (l2.next != null) {
        			l2 = l2.next;
        			answer.next = new ListNode( (l2.val+carry)%10 );
        			carry = (l2.val+carry)/10;
        			answer = answer.next;
        		}
        		if (carry ==1)
        			answer.next = new ListNode(1);
        		break;
        	}
        	if ( l2.next==null ) {
        		while (l1.next != null) {
        			l1 = l1.next;
        			answer.next = new ListNode( (l1.val+carry)%10 );
        			carry = (l1.val+carry)/10;
        			answer = answer.next;
        		}
        		if (carry ==1)
        			answer.next = new ListNode(1);
        		break;
        	}
        	answer.next = null;
        }
        return returnValue;
    }
}