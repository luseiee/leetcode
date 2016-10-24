import java.util.*;

public class Solution {
    public static void main(String[] args) {
        
    }
    public static boolean canJump(int[] nums) {
        int min = 0;
        int max = 0;
        while (max < nums.length - 1) {
            int maxT = max;
            for (int i = min; i <= maxT; i++) {
                if (i + nums[i] > max) max = i + nums[i];
            }
            min = maxT + 1;
            if (max == maxT) return false;
        }
        return true;
    }
}