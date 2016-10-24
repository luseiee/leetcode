public class Solution {
    public static void main(String[] args) {
        int[] nums = {9,0,-2,-2,-3,-4,0,1,-4,5,-8,7,-3,7,-6,-4,-7,-8};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int start = 0;
        int end = 0;
        int l = nums.length;
        int sum = 0;
        int ret = -10000000;
        while (end < l) {
            if (nums[end] >= 0) {
                sum += nums[end];
                ret = sum > ret ? sum : ret;
                end++;
            }
            else if (nums[end] < 0 && sum + nums[end] >= 0) {
                sum += nums[end];
                end++;
            }
            else {
                sum = 0;
                start = end + 1;
                end++;
            }
        }
        // Notice the situation of [-1,-2], you need to compare the ret with the largest number in the array
        int max = nums[0];
        for (int i = 0; i < l; i++) max = nums[i] > max ? nums[i] : max;
        if (max > ret) return max;
        return ret;
    }
}