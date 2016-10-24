import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) nums[i] = 1;
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int ret = 0;
        int min = 0;
        int max = 0;
        while (max < nums.length - 1) {
            int maxT = max;
            for (int i = min; i <= maxT; i++) {
                if (i + nums[i] > max) max = i + nums[i];
            }
            min = maxT + 1;
            ret++;
        }
        return ret;
    }
}