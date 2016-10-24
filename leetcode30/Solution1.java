import java.util.*;

public class Solution {

    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<Integer>();
        int l = words[0].length();
        int n = words.length;
        if ( s.length()<l*n ) return ret;
        for ( int i=0; i<=s.length()-l*n; i++ ) {

            String sub = s.substring(i, i+l*n);
            int[] show = new int[n]; //To check if the words have shown in s.
            int flag=1;
            for ( int j=0;j<n;j++ ) show[j]=0;
            //Start to check
            for ( int m=0;m<n;m++ ) { //check every length l
                String sub2 = sub.substring( m*l, (m+1)*l );
                for (int k=0;k<n;k++ ) {
                    if ( sub2.equals(words[k]) && show[k]==0 ) {
                        show[k]=1;break;
                    }
                }
            }
            for ( int j=0;j<n;j++ ) if (show[j]==0) flag=0;
            if (flag==1) ret.add(i);
        }
        return ret; 
    }
}
    