public class Solution {
    public static void main(String[] args){
        System.out.println(multiply("9", "9"));
    }
    public static String multiply(String num1, String num2) {
        String ret = "";
        if (num1.equals("0") || num2.equals("0")) return "0"; // Prevent from returning "0000"
        int l1 = num1.length(), l2 = num2.length();
        // m1,m2 saves the digits
        int[] m1 = new int[l1]; 
        int[] m2 = new int[l2];
        // res saves the intermediate result, for example: 34 * 67 = 18 (24+21) 28, res saves 18, 45, 28
        int[] res = new int[l1 + l2];
        for (int i = 0; i < l1; i++) {
            m1[i] = num1.charAt(l1 - i - 1) - '0';
        }
        for (int i = 0; i < l2; i++) {
            m2[i] = num2.charAt(l2 - i - 1) - '0';
        }
        for (int i = 0; i< l1 + l2; i++) {
            res[i] = 0;
        }
        // Start to calculate
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                res[i + j] += m1[i] * m2[j];
            }
        }
        // Convert the intermediate result to the right answer.
        for (int i = 0; i < l1 + l2 - 1; i++) {
            res[i + 1] += res[i] / 10;
            res[i] = res[i] % 10;
        }
        if (res[l1 + l2 - 1] > 0) ret += (char)('0' + res[l1 + l2 - 1]);
        for (int i = l1 + l2 - 2; i >= 0; i--) {
            ret += (char)('0' + res[i]);
        }
        return ret;
    }
}