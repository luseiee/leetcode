public class Solution {
    public static void main(String[] args) {
        System.out.println(myPow(1.5, -3));
    }
    public static double myPow(double x, int n) {
        double ret = 1.0;
        if (n == Integer.MIN_VALUE) 
            return 1 / (myPow(x, Integer.MAX_VALUE) * x);
        if (n < 0)
            return 1 / myPow(x, -n);
        while (n != 0) {
            if (n % 2 == 1) ret *= x;
            x *= x;
            n = n >> 1;
        }
        return ret;
    }
}