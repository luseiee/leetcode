public class Solution {
    public static void main(String[] args) {
        int[] nums = { 1,1,2 };
        System.out.println( removeDuplicates(nums) );
    }
    public static int removeDuplicates(int[] nums) {
        if ( nums.length==0 ) return 0;
        if ( nums.length==1 ) return 1;
        int tmp = nums[0];
        int ret = 1;
        int pos = 1;
        for ( int i=0; i<nums.length; i++ ) {
            if ( nums[i]!=tmp) {
                ret++;
                tmp = nums[i];
                nums[pos] = nums[i];
                pos++;
            }
        }
        return ret;
    }
}