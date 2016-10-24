public class Solution {
	public static void main(String[] args) {
		System.out.println( longestValidParentheses("()(()") );
	}
    public static int longestValidParentheses(String s) {
        
        // Start from the Left Side
        int start=0, end=0, ret=0, left=0, right=0, l=s.length();
        if ( l<=1 ) return 0;
        while ( end<l ) {
   	        System.out.println( start+" "+end+" "+left+" "+right );
        	char ch = s.charAt( end );
        	if ( ch=='(' ) { 
                if ( left==right )
                    ret = ret < (end-start) ? (end-start) : ret;
                left++; end++; continue; 
            }
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
        if ( left==right ) ret = ret < (end-start) ? (end-start) : ret;

        // Start from the right side
        start=l-1; end=l-1; left=0; right=0; l=s.length();
        while ( end>=0 ) {
            System.out.println( start+" "+end );
            char ch = s.charAt( end );
            if ( ch==')' ) { 
                if ( left==right )
                    ret = ret < (start-end) ? (start-end) : ret;
                right++; end--; continue;
            }
            if ( ch=='(' ) {
                if ( right>left ) { left++; end--; continue; }
                else if ( left==right ) {
                    ret = ret < (start-end) ? (start-end) : ret;
                    while ( left>=right ) { 
                        if (s.charAt(start)==')') { right--; start--; }
                        else { left--; start--; } 
                    }
                    end--; left++; continue;
                }
            }
        }

        if ( left==right ) ret = ret < (start-end) ? (start-end) : ret;
        return ret;
    }
}