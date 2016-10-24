public class Solution {
    public static void main( String[] args ) {
        // int[] nums = { 5,7,7,8,8,10 };
        // System.out.println ( searchRange( nums, 8 )[0] + " " + searchRange( nums, 8 )[1] );
    }

    public static int[] searchRange(int[] nums, int target) {
        int l=nums.length;
        int left, right;
        int[] ret = { -1,-1 };
        if ( l==0 ) return ret;
        ret[0] = searchLeft( nums, 0, l-1, target );
        ret[1] = searchRight( nums, 0, l-1, target );
        return ret;
    }

    public static int searchLeft( int[] nums, int start, int end , int target ) {
        int mid = ( start+end )/2;
        if ( start==end && nums[start]!=target ) return -1;
        if ( nums[mid]==target && mid==0 ) return mid;
        else if ( nums[mid]==target && nums[mid-1]<target ) return mid;
        else if ( nums[mid]==target && nums[mid-1]==target ) return searchLeft( nums, start, mid, target );
        else if ( nums[mid]<target ) return searchLeft( nums, mid+1, end, target );
        else if ( nums[mid]>target ) return searchLeft( nums, start, mid, target );
        return -1;
    }

    public static int searchRight( int[] nums, int start, int end , int target ) {
        int mid = ( start+end )/2;
        if ( start==end && nums[start]!=target ) return -1;
        if ( nums[mid]==target && mid==nums.length-1 ) return mid;
        else if ( nums[mid]==target && nums[mid+1]>target ) return mid;
        else if ( nums[mid]==target && nums[mid+1]==target ) return searchRight( nums, mid+1, end, target );
        else if ( nums[mid]<target ) return searchRight( nums, mid+1, end, target );
        else if ( nums[mid]>target ) return searchRight( nums, start, mid, target );
        return -1;
    }
}