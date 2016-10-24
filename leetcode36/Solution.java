public class Solution {

    public static void main( String[] args ) {
        
    }

    public boolean isValidSudoku(char[][] board) {
        // check line
        for ( int i=0; i<9; i++ ) {
            int[] num = { 0,0,0,0,0,0,0,0,0,0 };
            for ( int j=0; j<9; j++ ) {
                if (board[i][j]=='.') continue;
                if (num[board[i][j]-'0']==1) return false;
                else num[board[i][j]-'0']++;
            }
        }
        // check column
        for ( int j=0; j<9; j++ ) {
            int[] num = { 0,0,0,0,0,0,0,0,0,0 };
            for ( int i=0; i<9; i++ ) {
                if (board[i][j]=='.') continue;
                if (num[board[i][j]-'0']==1) return false;
                else num[board[i][j]-'0']++;
            }
        }
        // check block
        for ( int i=0; i<9; i++ ) {
            int[] num = { 0,0,0,0,0,0,0,0,0,0 };
            int a=i%3, b=i/3;
            for ( int m=a*3; m<a*3+3; m++ )
                for ( int n=b*3; n<b*3+3; n++ ) {
                    if (board[m][n]=='.') continue;
                    if (num[board[m][n]-'0']==1) return false;
                    else num[board[m][n]-'0']++;
                }
        }
        return true;
    }
}