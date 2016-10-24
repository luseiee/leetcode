import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates, 8));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> s =  new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, s, ret);
        return ret;
    }
    // If you add one, you need to remove one.
    // When find a new answer, create a new object.
    public static void combinationSum(int[] candidates, int target, int st, List<Integer> s, List<List<Integer>> ret ) {
        if (target==0) {
            List<Integer> tmp =  new ArrayList<Integer>(s);
            ret.add(tmp);
            return;
        }
        for ( int i=st; i<candidates.length; i++ ) {
            if (target<candidates[i])
                return;
            else {
                s.add(candidates[i]);
                combinationSum(candidates, target-candidates[i], i+1, s, ret);
                s.remove(s.size()-1);
                // The only difference
                while (i<candidates.length-1&&candidates[i]==candidates[i+1])
                    i++;
            }

        }
    }
}