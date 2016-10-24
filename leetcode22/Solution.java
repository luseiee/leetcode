import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ret =  new ArrayList<String>();
        // Boundary
        if ( n==0 ) 
            return ret;
        // Start 
        String s = "";
        generate( s, n, n, ret);
        return ret;
    }

    public static void generate( String s, int left, int right, List<String> ret) {
        if (left==0 && right==0) ret.add(s);
        if ( left>0 ) generate( s+"(", left-1, right, ret );
        if ( right>left ) generate( s+")", left, right-1, ret );
    }
}