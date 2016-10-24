public class Solution {
    public static void main(String[] args) {
        String[] strs = { "abcsdd", "abc823", "abc820131", "abc123122" };
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        String common = "";
        if ( strs.length<1 ) return common;
        if ( strs.length==1) return strs[0];
        int count = 0;
        int flag = 1;
        while ( flag==1 ) {
            for ( int i=1; i<strs.length; i++ ) {
                if ( count == strs[i].length() ||count == strs[0].length() ) {
                    flag = 0;
                    break;
                }

                if ( strs[i].charAt(count) != strs[0].charAt(count) ) {
                    flag = 0;
                    break;
                }                   
            }
            if (flag==1) common += strs[0].charAt(count);
            count++;
        }
        return common;
    }
}