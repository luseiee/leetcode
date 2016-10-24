public class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
    public static int binarySearch(int[] nums, int start, int end, int target) {
    	int mid = (start+end)/2;
    	if ( nums[mid] == target ) return mid;
    	if ( start==end && target < nums[mid] ) return start;
    	if ( start==end && target > nums[mid] ) return start+1;
    	if ( target < nums[mid] ) return binarySearch(nums, start, mid, target);
    	if ( target > nums[mid] ) return binarySearch(nums, mid+1, end, target);
    	return 0;
    }
}