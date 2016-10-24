public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("  hello  "));
    }
    public static int lengthOfLastWord(String s) {
        int ret = 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        int start = -1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ')
                start = i;
        }
        return s.length() - start - 1;
    }
}