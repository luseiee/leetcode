public class Solution {
    public static void main ( String[] args ) {

    }
    public void solveSudoku(char[][] board) {
        int count=0;
        while ( count!=81 ) {
            count = 0;
            for ( int i=0; i<9; i++ ) for ( int j=0; j<9; j++ ) {
                if ( board[i][j]=='.' ) {
                    // Check if a space can be filled
                    int[] num = { 0,0,0,0,0,0,0,0,0 };
                    for ( int m=0; m<9; m++ ) {
                        if ( board[i][m]!='.' ) num[board[i][m]-'1']=1;
                        if ( board[m][j]!='.' ) num[board[m][j]-'1']=1;
                    }
                    for ( int m=(i/3)*3; m<(i/3)*3+3; m++ )
                        for ( int n=(j/3)*3; n<(j/3)*3; n++ ) {
                            if ( board[m][n]!='.' ) num[board[m][n]-'1']=1;
                    }
                    int answer=-1;
                    for ( int m=0; m<9; m++) {
                        if ( num[m]==0&&answer==-1 ) answer=m;
                        else if ( num[m]==0&&answer!=-1 ) answer=-2;
                    }
                    if ( answer>=0 ) {
                        System.out.println( i+" "+j+" "+(answer+1) );
                        board[i][j] = (char)('1'+answer);
                        count++;
                    }
                }
                else { count++;continue; }
            }
        }
    }
}