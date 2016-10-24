public class Solution {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int l = height.length;
        int tall = 0; // The index of the tallest one
        int ret = 0;
        for (int i = 0; i < l; i++) {
            tall = (height[i] > height[tall]) ? i : tall;
        }
        // Check from the left to the tallest.
        int start = 0;
        int end = 1;
        while (end <= tall) {
            if (height[end]<=height[start]) {
                ret += height[start] - height[end];
                end++;
            }
            else {
                start = end;
                end++;
            } 
        }
        // Check from the right to the tallest.
        end = l-1;
        start = end - 1;
        while (start >= tall) {
            if (height[start]<=height[end]) {
                ret += height[end] - height[start];
                start--;
            }
            else {
                end = start;
                start--;
            } 
        }
        return ret;
    }
}