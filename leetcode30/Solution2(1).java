import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ret = new ArrayList<Integer>();
        int sl = s.length();
        int l = words[0].length();
        int n = words.length;
        if ( s.length()<l*n ) return ret;
        // Map<String,Integer> map2 = new HashMap<String,Integer>();
        // map2 = (Map<String,Integer>) map.clone();
        // foo(map2);
        // System.out.println(map.get("foo"));
        // System.out.println(map2.get("foo"));
        for ( int i=0;i<=sl-l*n;i++ ) {
        	int flag=1;
        	String sub = s.substring(i, i+l*n);
        	Map<String,Integer> map = new HashMap<String,Integer>();
	        for (int j=0; j<n; j++) {
	        	map.put(words[j], map.get(words[j])==null ? 1 : map.get(words[j])+1 );
	        }
	        for ( int m=0;m<n;m++ ) {
	        	if ( map.get(sub.substring(m*l,(m+1)*l)) == null ) { flag=0; break; }
	        	else if ( map.get(sub.substring(m*l,(m+1)*l)) == 0 ) { flag=0; break; }
	        	else map.put ( sub.substring(m*l,(m+1)*l), map.get(sub.substring(m*l,(m+1)*l))-1 );
	        }
	        if ( flag==1 ) ret.add(i);
        }
        return ret;
    }
    // public static void foo (Map<String,Integer> map) {
    // 	map.put("foo",10);
    // }
}
