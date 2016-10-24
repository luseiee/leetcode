// Use Java Api Stack
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String s = "{[]}[";
        System.out.println( isValid(s) );

    }
    public static boolean isValid(String s) {

        int length = s.length();
        // Boundary
        if ( length==0 ) return true;
        // Create a stack
        Stack<Character> paren = new Stack<Character>();
        // Start the algorithm
        for (int i=0; i<length; i++) {
            char ch = s.charAt(i);
            if ( ch=='{' || ch=='[' || ch=='(' ) {
                paren.push( ch );
                continue;
            }
            if (paren.empty()) return false;
            char ch2 = paren.pop();
            if ( ch=='}' && ch2!='{' ) return false;
            if ( ch==']' && ch2!='[' ) return false;
            if ( ch==')' && ch2!='(' ) return false;
        }
        if (paren.empty()) return true;
        return false;
    }
}