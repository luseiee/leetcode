import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));

    }
    public static int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort( nums );
        int sum = nums[0] + nums[1] + nums[2];
        int dif = ( nums[0] + nums[1] + nums[2] - target) * ( nums[0] + nums[1] + nums[2] - target);
        for (int i=0; i<nums.length-2; i++) {

            int start = i + 1;
            int end = nums.length - 1;
            while (start<end) {
                int sumTmp = nums[i] + nums[start] +nums[end];
                if ( sumTmp >= target ) end--;
                else start++;
                if ((sumTmp - target) * (sumTmp - target) < dif) {
                    dif = (sumTmp - target) * (sumTmp - target);
                    sum = sumTmp;
                }
            }
        }
        return sum;
    }
}