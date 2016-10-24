//The next time use string you can just use string + char to expand a string

public class Solution {

	public static void main(String args[]){

		String s = "PAYPALISHIRING";
		System.out.println( convert(s,2) );

	}

    public static String convert(String s, int numRows) {

    	// Consider Boundary Situations
    	if (s.length() == 0) return s;
    	if (numRows ==1) return s;

    	// Start Calculating the corresponding Index
    	char [][] zigZag = new char[numRows][1000];

    	// Put the original string to the corresponding position
    	int types = numRows*2 - 2;
    	for (int i=0; i<s.length(); i++) {
    		if ( i%types<numRows )
    			zigZag[i%types][(i/types)*2] = s.charAt(i);
    		else {
    			zigZag[2*numRows-i%types-2][(i/types)*2+1] = s.charAt(i);
    		}
    	}

    	// Put the zigZag into a new String
    	char[] convert = new char[s.length()];
    	int count = 0;
    	for (int i=0; i<numRows; i++){
    		for (int j=0; j<1000; j++) {
    			if (zigZag[i][j]!='\0') {
    				convert[count] = zigZag[i][j];
    				count++;
    			}
    		}
		}
    	return new String(convert);
    }
}