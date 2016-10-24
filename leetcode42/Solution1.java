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
            while (height[end]<height[start]) end++;
            ret += water(height, start, end);
            start = end;
            end++;
        }
        // Check from the right to the tallest.
        end = l-1;
        start = end - 1;
        while (start >= tall) {
            while (height[start]<height[end]) start--;
            ret += water(height, start, end);
            end = start;
            start--;
        }
        return ret;
    }
    public static int water(int[] height, int start, int end) {
        int sum = 0;
        int ref = (height[start] < height[end]) ? height[start] : height[end];
        for (int i = start + 1; i < end; i++) {
            sum += ref - height[i];
        }
        return sum;
    }
}