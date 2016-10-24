import java.util.*;

public class Solution {

    public static void main(String[] args) {


        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {

        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("sa", 3);





        List<Integer> ret = new ArrayList<Integer>();
        int sl = s.length();
        int l = words[0].length();
        int n = words.length;
        int start = 0; int end = 0;
        int[] show = new int[n]; //To check if the words have shown in s.
        for ( int j=0;j<n;j++ ) show[j]=0;
        while ( start <= sl-l*n ) {
            start++;
        }
        return ret; 
    }
}
    