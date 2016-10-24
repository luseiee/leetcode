public class Solution {
    public static void main ( String[] args ) {
            // char[][] board = {  {'5','1','9','7','4','8','6','3','2'},
            //                     {'7','8','3','6','5','2','4','1','9'},
            //                     {'4','2','6','1','3','9','8','7','5'},
            //                     {'3','5','7','9','8','6','2','4','1'},
            //                     {'2','6','4','3','1','7','5','9','8'},
            //                     {'1','9','8','5','2','4','3','6','7'},
            //                     {'9','7','5','.','6','3','1','2','4'},
            //                     {'8','3','2','4','9','1','7','5','6'},
            //                     {'6','4','1','2','7','5','.','8','3'}, };
            // char[][] board = { {'.','.','.','.','.','.','.','.','.'},
            //                     {'.','.','.','.','.','.','.','.','.'},
            //                     {'.','.','.','.','.','.','.','.','.'},
            //                     {'.','.','.','.','.','.','.','.','.'},
            //                     {'.','.','.','.','.','.','.','.','.'},
            //                     {'.','.','.','.','.','.','.','.','.'},
            //                     {'.','.','.','.','.','.','.','.','.'},
            //                     {'.','.','.','.','.','.','.','.','.'},
            //                     {'.','.','.','.','.','.','.','.','.'}, };
            // System.out.println ( check(board, 78) );
            // solveSudoku( board );
        }

    public static void solveSudoku(char[][] board) {
        // This is the original board
        char[][] bod = new char[9][9]; 
        for ( int i=0; i<81; i++ ) bod[i/9][i%9] = board[i/9][i%9];
        // Start point, index, and valid flag
        int pos=0, pre=0, nxt=0; 
        boolean valid = true;
        for ( int i=0; i<81; i++ ) { if (bod[i/9][i%9]=='.') { pos=i; nxt=i; break;} }
        // Start to try
        while ( pos<=80 ) {
            // Find next block, if no, next will be 81. Find pre block.
            for ( int i=pos+1; i<81; i++ ) 
                { if (bod[i/9][i%9]=='.') { nxt=i; break; } }
            for ( int i=pos-1; i>=0; i-- ) 
                { if (bod[i/9][i%9]=='.') { pre=i; break; } }
            if ( nxt==pos ) nxt=81;
            // If the block hasn't been filled, fill it with 1, else fill the larger one
            if ( board[pos/9][pos%9]=='.' ) board[pos/9][pos%9] = '1';
            else board[pos/9][pos%9] = (char)(board[pos/9][pos%9]+1);
            // Start to check
                // The ascii after 9 is :, it means that need to trace back
            if ( board[pos/9][pos%9]==':' ) {
                board[pos/9][pos%9] = '.';
                pos = pre;
            }
            else if ( check(board, pos) ) {
                pos = nxt;
                continue;
            } 
            else continue;
        }
    }
    public static boolean check(char[][] board, int pos ) {
        int x=pos/9;
        int y=pos%9;
        char t = board[x][y];
        for ( int i=0; i<9; i++ ) {
            if ( board[x][i]==t && i!=y ) return false;
            if ( board[i][y]==t && i!=x ) return false;
        }
        for ( int i=x/3*3; i<x/3*3+3; i++ ) {
            for ( int j=y/3*3; j<y/3*3+3; j++ ) {
                if ( board[i][j]==t && ( i!=x || j!=y) )
                    return false;
            }
        }
        return true;
    }
}