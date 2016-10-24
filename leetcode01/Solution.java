public class Solution {
	public static void main (String []args) {

		int[] array = { 2,1,9,4,4,56,90,3 };
		System.out.println("Array:");
		for (int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
		int[] output = new int[2];
		output = twoSum(array, 8);
		System.out.println("\n" + output[0] + " " + output[1]);
	}

	public static int[] twoSum(int[] nums, int target) {

		int[] a = new int [nums.length];
		for (int i=0; i<nums.length; i++){
			a[i] = nums[i];
		}
		QuickSort( a,0,a.length-1 );
		int left = 0;
		int right = nums.length-1;
		int target1 = 0;
		int target2 = 0;
		int target11 = 0;
		int target22 = 0;
		while (left < right) {
			if (a[left] + a[right] == target) {
				target1 = a[left];
				target2 = a[right];
				break;
			}
			else if (a[left] + a[right] > target)
				right --;
			else if (a[left] + a[right] < target)
				left ++;
		}
        for (int i=0; i<nums.length ; i++){
        	if (nums[i] == target1){
        		target11 = i;
        		break;
        	}
        }
        for (int i=0; i<nums.length ; i++){
        	if (nums[i] == target2 && i !=target11){
        		target22 = i;
        	}
        }

        int[] output = new int [2];
        if (target11 < target22) {
        	output[0] = target11;
        	output[1] = target22;
        }
        else {
        	output[0] = target22;
        	output[1] = target11;
        }
        return output;
    }

	public static void QuickSort (int []a, int l, int r){

		int ll=l, rr=r;
		int tmp = a[l];
		while (l < r) {
			while (l < r && tmp <= a[r]) r--;
			a[l] = a[r];
			while (l < r && tmp >= a[l]) l++;
			a[r] = a[l];
		}
		a[l] = tmp;
		if (ll<l-1)
			QuickSort (a,ll,l-1);
		if (l+1<rr)
			QuickSort (a,l+1,rr);
	}
}