//Time Complexity O(N2)

//Learning Tips: String Class: String s:
//s.length();
//s.charAt(int index);

public class Solution {

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.print( lengthOfLongestSubstring(s) );
	}

    public static int lengthOfLongestSubstring(String s) {

    	if (s.length()==0) return 0;

    	//Use an array to count the exist times of a char, use space to earn time
    	int[] ascii = new int[128];
    	int longest = 0;

    	//Start from the first char
    	for (int i=0; i<s.length(); i++) {
    		for (int j=0; j<128; j++)
    			ascii[j] = 0;
    		int count = 0;
    		int index = i;
    		while ( index<s.length() ){
    			ascii[ s.charAt(index) ]++;
    			if ( ascii[ s.charAt(index) ] == 2 )
    				break;
    			count++;
    			index++;
    		}
    		if ( count>longest )
    			longest = count;
    	}
        return longest;
    }
}