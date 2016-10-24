import java.util.*;


public class Solution {
	public static void main(String[] args) {
		int a[] = {5,4,3,2,1};
		nextPermutation( a );
	}

    public static void nextPermutation(int[] nums) {
    	int l = nums.length;
    	int tmp=0; // For tmp use
    	// Boundary situation
    	if ( l<=1 ) return;
    	if ( l==2 ) {
    		tmp = nums[0]; nums[0] = nums[1]; nums[1] = tmp; return;
    	}
    	// 1. Find the index of last increasement ( after which the list will be in descending order )
    	int inc=-1; 
        for ( int i=l-1; i>0; i--) {
        	if ( nums[i]>nums[i-1] ) { inc = i-1; break; }
        }
        // Boundary: The array is in descending order
        if ( inc==-1 ) { Arrays.sort(nums); return; }
        // 2. Exchange this number with the next larger number
        int nextL = inc + 1;
        for ( int i=inc+1; i<l; i++ ) {
        	if ( nums[i]<nums[nextL] && nums[i]>nums[inc] ) nextL=i;
        }
        tmp = nums[inc]; nums[inc] = nums[nextL]; nums[nextL] = tmp;
        // 3. Sort the array after inc
        Arrays.sort ( nums, inc+1, l);
        
		// String intArrayString = Arrays.toString(nums);
		// System.out.println(intArrayString);
    }
}