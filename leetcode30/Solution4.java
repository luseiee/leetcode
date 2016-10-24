import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {

        // Get some parameters
        List<Integer> ret = new ArrayList<Integer>();
        int sl = s.length();
        int l = words[0].length();
        int n = words.length;
        if ( s.length()<l*n ) return ret;

        // Create a hashmap to store all the words
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (String str : words) {
            map.put(str, map.containsKey(str) ? map.get(str)+1 : 1 );
        }

        // The start point of the target is k*l,k*l+1....k*l+l-1 (k*l+i).
        for ( int i=0; i<l; i++ ) {

            int start = i;
            int end = i;
            int count = 0;
            Map<String,Integer> tmp = new HashMap<String,Integer>();
            while ( end<=sl-l ) {
                // System.out.println(start+" "+end);
                String sub=s.substring( end,end+l );
                tmp.put(sub, tmp.containsKey(sub) ? tmp.get(sub)+1 : 1 );
                if ( !map.containsKey(sub) ) { //Not matched, start from the not match point
                    start=end+l; end+=l; tmp.clear();count=0;continue;
                }
                if ( map.get(sub) >= tmp.get(sub) ) { // Matched, end moves on
                    count++; end += l;
                }
                else if ( map.get(sub) < tmp.get(sub) ) { // Too many matched, start moves until not too many
                    while ( map.get(sub) < tmp.get(sub) ) {
                        tmp.put( s.substring(start,start+l), tmp.get(s.substring(start,start+l))-1 );
                        count--;
                        start+=l;
                    }
                    end += l;
                    count ++;
                } 
                if ( count==n ) { // Add to return
                    ret.add(start);
                    tmp.put( s.substring(start,start+l), tmp.get(s.substring(start,start+l))-1 );
                    count--;
                    start+=l;
                } 
            }
        }
        return ret;
    }
}
