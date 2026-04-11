class Solution {
    public boolean exist(char[][] board, String word) {
        return check(board,word,0,0,0);
    }
    public boolean check(char[][] board,String word,int r,int c,int cou){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) && dfs1(board,word,i,j,0)){
                    return true;
                }   
            }
        }
        return false;
    }
    public boolean dfs1(char[][] board,String word,int r,int c,int cou){
        //base case
        if(cou==word.length()){
            return true;
        }
        //return class
        if(r<0 || c<0 || r>=board.length || c>=board[0].length
        || board[r][c]!=word.charAt(cou)){
            return false;
        }
        //mack visit
        char ch=board[r][c];
        board[r][c]='#';

        //triversel
        boolean isTrue=dfs1(board,word,r+1,c,cou+1)||dfs1(board,word,r,c+1,cou+1)||
                            dfs1(board,word,r-1,c,cou+1)||dfs1(board,word,r,c-1,cou+1);

        //backtack
        board[r][c]=ch;
        return isTrue;
    }
    
}
