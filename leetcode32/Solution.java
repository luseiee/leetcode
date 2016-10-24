public class Solution {
	public static void main(String[] args) {
		System.out.println( longestValidParentheses("(((())") );
	}
    public static int longestValidParentheses(String s) {
        int start=0, end=0, ret=0, left=0, right=0, l=s.length();
        if ( l<=1 ) return 0;
        while ( end<l ) {
   	        System.out.println( start+" "+end );
        	char ch = s.charAt( end );
        	if ( ch=='(' ) { left++; end++; continue;}
        	if ( ch==')' ) {
        		if ( left>right ) { right++; end++; continue; }
        		else if ( left==right ) {
        			ret = ret < (end-start) ? (end-start) : ret;
        			while ( left<=right ) { 
        				if (s.charAt(start)=='(') { left--; start++; }
        				else { right--; start++; } 
        			}
        			end++; right++; continue;
        		}
        	}
        }
        while ( left>right && start<end ) { 
        				if (s.charAt(start)=='(') { left--; start++; }
        				else { right--; start++; } 
        			}
        ret = ret < (end-start) ? (end-start) : ret;
        return ret;
    }
}