// Time complexity O(N2)

public class Solution {

	public static void main(String[] args) {
		String s = "deduuuuabcbaffffff";
		System.out.println( longestPalindrome(s) );
	}

    public static String longestPalindrome(String s) {

    	if ( s.length()==0 )
    		return " ";
    	//Start Finding Odd Situation
    	int start = 0;
    	int end = 0;
    	int longest = 0;
        for (int i=0; i<s.length(); i++) {
        	int count = 1;
        	while ( i-count>=0 && i+count<s.length() && s.charAt(i-count)==s.charAt(i+count) ) {
        		count ++;
        	}
        	if ((count-1)*2+1>longest) {
        		longest = (count-1)*2+1;
        		start = i-count+1;
        		end = i+count-1;
        	}
        }
        //Start Finding Even Situation
        for (int i=0; i<s.length()-1; i++) {
        	int count = 0;
        	while ( i-count>=0 && i+1+count<s.length() && s.charAt(i-count)==s.charAt(i+1+count) ) {
        		count ++;
        	}
        	if (count*2>longest) {
        		longest = count*2;
        		start = i-count+1;
        		end = i+count;
        	}
        }
        String answer = s.substring(start, end+1);
        return answer;
    }

}