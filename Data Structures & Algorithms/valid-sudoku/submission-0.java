class Solution {
    public boolean isValidSudoku(char[][] board) {
        return ss(board,0,0);
    }
    public boolean ss(char[][] board,int r,int c){
        if(r==9){
            return true;
        }
        int newrow=r;
        int newcol=c+1;
        if(c==8){
            newrow+=1;
            newcol=0;
        }
        if(board[r][c]!='.'){
            if(!isSafe(board,r,c)){
                return false;
            }
        }
        return ss(board,newrow,newcol);

    }
    public boolean isSafe(char[][]board,int r,int c){
        char a=board[r][c];
        //horizental
        int row=r;
        for(int i=0;i<9;i++){
            
            if(i!=c && board[row][i]==a){
                return false;
            }
        }
        //vertical
        row=r;
        for(int i=0;i<9;i++){
           
            if(i!=r && board[i][c]==a){
                return false;
            }
        }
        //3x3 box
        int strow=(r/3)*3;
        int stcol=(c/3)*3;
        for(int i=strow;i<strow+3;i++){
            for(int j=stcol;j<stcol+3;j++){
                if((i!=r && j!=c) && board[i][j]==a){
                    return false;
                }
            }
        }
        return true;
    } 
}
