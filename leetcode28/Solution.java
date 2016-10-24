public class Solution {
    public static void main(String[] args) {
        System.out.println("bc".equals("abcc".substring(1,3)));

    }
    public int strStr(String haystack, String needle) {
        
        //Boundary
        int l1 = haystack.length();
        int l2 = needle.length();
        if (l1<l2) return -1;
        if (l2==0) return 0;
        for (int i=0; i<l1-l2+1; i++) {
            if ( needle.equals( haystack.substring(i, i+l2)) )
                return i;
        }
        return -1;
    }
}