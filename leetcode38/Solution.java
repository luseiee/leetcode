public class Solution {
    public String countAndSay(int n) {

        if ( n==1 ) return "1";
        if ( n==2 ) return "11";
        String a = "1";
        String ret = "";
        for ( int i=2; i<=n; i++ ) {
            ret = "";
            int count = 1;
            char num = a.charAt(0);
            for ( int m=1; m<a.length(); m++ ) {
                if ( a.charAt(m)==num ) {
                    count++;
                }
                else if ( a.charAt(m)!=num ) {
                    ret += (char)('0'+count);
                    ret += num;
                    num = a.charAt(m);
                    count = 1;
                }
            }
            ret += (char)('0'+count);
            ret += num;
            a = ret;
        }
        return ret;
    }
}