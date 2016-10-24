// Time complexity is O(N2)
import java.util.*;
public class Solution {
	
	public static void main(String[] args){

		int[] nums = {-1, 0, 1, 2, -1, -4};
		threeSum(nums);
		List<List<Integer>> answer = threeSum(nums);
		for (int i=0;i<answer.size();i++){
			System.out.println(answer.get(i).get(0)+" "+answer.get(i).get(1)+" "+answer.get(i).get(2));
		}
	}

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        // Consider the boundary condition
       	if (nums.length < 3)
       		return answer;
       	// Fix one number, and find the next two, the time complexity will be O(N2)
    	int[] three = { -1, -1, -1};
       	for (int i = 0; i< nums.length-2; i++){
       		if (i>0 && nums[i]==nums[i-1]) continue;
    		int start = i+1;
    		int end = nums.length-1;
    		while (start<end){
    			if (nums[i]+nums[start]+nums[end] > 0) {
    				end--;
    				continue;
    			}
    			if (nums[i]+nums[start]+nums[end] < 0) {
    				start++;
    				continue;
    			}
    			if (nums[i]+nums[start]+nums[end] == 0) {
    				// Check repeatness with the previous answer
    				List<Integer> sum3 = new ArrayList<Integer>();
    				sum3.add(nums[i]);
    				sum3.add(nums[start]);
    				sum3.add(nums[end]);
    				answer.add(sum3);
    				while (start<end && nums[start+1] == nums [start]) start++;
    				while (start<end && nums[end-1] == nums [end]) end--;
    				start++;
    				end--;
    				continue;				
    			}
    		}
       	}
        return answer;
    }
}