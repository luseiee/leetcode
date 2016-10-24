import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(divide(1,1));
    }

    public static int divide(int dividend, int divisor) {
        // Consider all the boundary
        if ( divisor==0 ) return Integer.MAX_VALUE;
        if ( divisor==Integer.MIN_VALUE && dividend == Integer.MIN_VALUE ) return 1;
        if ( divisor==Integer.MIN_VALUE ) return 0;
        if ( dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        if ( dividend==Integer.MIN_VALUE && divisor==1) return Integer.MIN_VALUE;
        if ( dividend==Integer.MIN_VALUE && divisor>1) return 0-posDivide(0-(dividend+divisor), divisor)-1;
        if ( dividend==Integer.MIN_VALUE && divisor<-1) return posDivide(0-(dividend-divisor), 0-divisor)+1;
        // Normal Situation
        if ( dividend>=0 && divisor>0 ) return posDivide(dividend, divisor);
        if ( dividend>=0 && divisor<0 ) return 0-posDivide(dividend, 0-divisor);
        if ( dividend<=0 && divisor>0 ) return 0-posDivide(0-dividend, divisor);
        else return posDivide(0-dividend, 0-divisor);
    }

    public static int posDivide(int dividend, int divisor) {

        // Form a list of divisor's doubles
        List<Integer> num = new ArrayList<Integer>();
        List<Integer> time = new ArrayList<Integer>();
        long a = divisor;
        long b = 1;
        while ( a<=dividend ) {
            num.add( (int)a );
            time.add( (int)b );
            a = a+a;
            b = b+b;
        }
        // Begin from the last of the list and get the answer
        int ret=0;
        for (int i=num.size()-1; i>=0; i--) {
            if ( dividend>=num.get(i) ) {
                dividend -= num.get(i);
                ret += time.get(i);
            }
        }
        return ret;
        
    }
}