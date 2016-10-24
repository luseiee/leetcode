import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<Integer>();
        permute(nums, 0, a, ret);
        return ret;
    }
    public static void permute(int[] nums, int idx, List<Integer> a, List<List<Integer>> ret) {
        if (idx == nums.length) {
            List<Integer> b = new ArrayList<Integer>(a);
            ret.add(b);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            int tmp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = tmp;
            a.add(nums[idx]);
            permute(nums, idx + 1, a, ret);
            nums[i] = nums[idx];
            nums[idx] = tmp;
            a.remove(a.size() - 1);
        }
    }
}