import java.util.*;
public class Solution {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
    public static int totalNQueens(int n) {
        int ret = 0;
        // The i(th) row's queen is at column q[i].
        int[] q = new int[n];
        for (int i = 0; i < n; i++) q[i] = -1;
        // The c stores if the column has been ocupied, the d1, d2 check if the diagonal has been occupied
        int[] c = new int[n];
        for (int i = 0; i < n; i++) c[i] = 0;
        int[] d1 = new int[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++) d1[i] = 0;
        int[] d2 = new int[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++) d2[i] = 0;
        // Store the current valid row and the corres col
        int row = 0; 
        // Start the backtracking
        while (row >= 0) { // If row is -1, all the situations have been tried.
            // If row is n, it means a succeed layout, store the result
            if (row == n) {
                ret++;
                row--;
                continue;
            }
            // Try to put a queen on the row
            boolean valid = false;
            int col = q[row];
            if (col >= 0) { // Delete the previous put.
                c[col] = 0;
                d1[row - col + n - 1] = 0;
                d2[row + col] = 0;
                q[row] = -1;
            }
            for (int i = col + 1; i < n; i++) {
                if (c[i] == 0 && d1[row - i + n - 1] == 0 && d2[row + i] == 0) {
                    q[row] = i;
                    c[i] = 1;
                    d1[row - i + n - 1] = 1;
                    d2[row + i] = 1;
                    valid = true;
                    break;
                }
            }
            // If succeed, continue, else backtrack
            if (valid) row++;
            else row--;
        }
        return ret;
    }
}