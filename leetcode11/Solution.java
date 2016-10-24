//A better solution with O(N) complexity

public class Solution {
	public static void main(String[] args) {
		int[] height = {2,3,0,1};
		System.out.println(maxArea(height));
	}
    public static int maxArea(int[] height) {
        int area=0;

        //Boundary
        if (height.length<=1)	return 0;

        //Start
        int start = 0;
        int end = height.length - 1;
        while (start<end) {
        	int left = height[start];
        	int right = height[end];
        	int newArea = (end-start)*(left<right?left:right);
        	if ( newArea>area ) area=newArea;
        	if ( left<=right ) {
        		while ( start<end && height[start]<=left )
        			start++;
        	}
        	else if ( left>right ) {
        		while ( start<end && height[end]<=right )
        			end--;
        	}
        }
        return area;
    }
}