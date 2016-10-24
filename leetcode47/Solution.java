import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<Integer>();
        permuteUnique(nums, 0, a, ret);
        return ret;
    }
    public static void permuteUnique(int[] nums, int idx, List<Integer> a, List<List<Integer>> ret) {

        if (idx == nums.length) {
            List<Integer> b = new ArrayList<Integer>(a);
            ret.add(b);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            int flag = 1;
            for (int j = idx; j < i; j++) {
                if (nums[j] == nums[i]) flag = 0;
            }
            if (flag == 0) continue;
            int tmp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = tmp;
            a.add(nums[idx]);
            permuteUnique(nums, idx + 1, a, ret);
            nums[i] = nums[idx];
            nums[idx] = tmp;
            a.remove(a.size() - 1);
        }
    }
}