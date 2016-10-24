public class Solution {
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;
        int i = 0;
        // Switch the int to right position, for example, if l=5, then 4 should be in index 3, and 6,-1 can be whereever
        while (i < l) {
            while (nums[i] <= l && nums[i] > 0 && nums[i] != i + 1) {
                int des = nums[i] - 1;
                int tmp = nums[i];
                if ( nums[i]==nums[des] ) break; // To prevent situation like [1,1]
                nums[i] = nums[des];
                nums[des] = tmp;
            }
            i++;
        }
        // Check the position
        for (i = 0; i <= l; i++) {
            if ( i == l ) return l + 1;
            if ( nums[i] != i+1 ) return i + 1;
        }
        return 1;
    }
}