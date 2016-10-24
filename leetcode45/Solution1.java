import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5,6,4,4,6,9,4,4,7,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        // Use DFS, And use list as the global var, since global var is invalid for leetcode
        List<Integer> a = new ArrayList<Integer>();
        a.add(0); // Record the current position
        a.add(0); // Record the current number of jumps
        a.add(10000000); // Record the current best return number
        jump(nums, a);
        return a.get(2);
    }
    public static void jump(int[] nums, List<Integer> a) {
        int pos = a.get(0); 
        int jumps = a.get(1);
        int ret = a.get(2);
        int l = nums.length;
        if (pos == l - 1 && jumps < ret) {
            a.set(2, jumps);
            return;
        }
        for (int i = 1; i <= nums[pos]; i++) {
            if (pos + i <= l-1) {
                a.set(0, pos + i);
                a.set(1, jumps + 1);
                jump(nums, a);
                a.set(0, pos);
                a.set(1, jumps);
            }
        }
    }
}