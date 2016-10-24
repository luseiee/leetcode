public class Solution {
    public static void main(String[] args) {
        System.out.println(myPow(1.5,3));
    }
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return 1 / myPow(x, -n);
        return myPow(x, n / 2) * myPow(x, (n + 1) / 2);
    }
}