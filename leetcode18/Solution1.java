//O(N3),May not be the best solution

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {};
        int target = 0;
        System.out.println ( fourSum(nums,target) );
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int numsL = nums.length;
        Arrays.sort(nums);
        //Boundary
        if ( numsL<4 ) return ret;
        //Start, fix two numbers
        for ( int m=0; m<numsL-3; m++ ) {

            if ( m>0 && nums[m]==nums[m-1] ) continue; //To avoid repeatness
            for ( int n=m+1; n<numsL-2; n++) {
                if ( n>m+1 && nums[n]==nums[n-1] ) continue; //To avoid repeatness
                int start = n+1;
                int end = numsL-1;
                while ( start<end ) {
                    int sum = nums[m] + nums[n] + nums[start] +nums[end];
                    if ( sum<target ) {
                        start ++;
                        while ( start<end && nums[start] == nums[start-1] ) start++; //To avoid repeatness
                    }
                    if ( sum>target ) {
                        end --;
                        while ( start<end && nums[end] == nums[end+1] ) end--; //To avoid repeatness
                    }
                    if ( sum==target ) {
                        List<Integer> sum4 = new ArrayList<Integer>();
                        sum4.add(nums[m]);
                        sum4.add(nums[n]);
                        sum4.add(nums[start]);
                        sum4.add(nums[end]);
                        ret.add(sum4);
                        start ++;
                        while ( start<end && nums[start] == nums[start-1] ) start++; //To avoid repeatness
                        end --;
                        while ( start<end && nums[end] == nums[end+1] ) end--; //To avoid repeatness
                    }
                }
            }
        }
        return ret;
    }
}