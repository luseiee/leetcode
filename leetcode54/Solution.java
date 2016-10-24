import java.util.*;
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int m = matrix.length;
        if (m == 0) return ret;
        int n = matrix[0].length;
        int flag = 0;
        int shang = 0;
        int xia = m - 1;
        int zuo = 0;
        int you = n - 1;
        while (zuo <= you && xia >= shang) {
            ret.add(matrix[i][j]);
            if (flag == 0) {
                if (j == you) {
                    flag = 1;
                    shang++;
                    i++;
                    continue;
                }
                else {
                    j++;
                    continue;
                }
            }
            if (flag == 1) {
                if (i == xia) {
                    flag = 2;
                    you--;
                    j--;
                    continue;
                }
                else {
                    i++;
                    continue;
                }
            }  
            if (flag == 2) {
                if (j == zuo) {
                    flag = 3;
                    xia--;
                    i--;
                    continue;
                }
                else {
                    j--;
                    continue;
                }
            }  
            if (flag == 3) {
                if (i == shang) {
                    flag = 0;
                    zuo++;
                    j++;
                    continue;
                }
                else {
                    i--;
                    continue;
                }
            } 
        }
        return ret;
    }
}