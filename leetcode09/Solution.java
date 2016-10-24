public class Solution {

    public boolean isPalindrome(int x) {
        if ( x>=0 && reverse(x)==x )
        	return true;
        return false;
    }

    public int reverse(int x) {
    	int y=0;
    	while (x!=0) {
    		y = y*10 + x%10;
    		x /= 10;
    	}
    	return y;
    }

}