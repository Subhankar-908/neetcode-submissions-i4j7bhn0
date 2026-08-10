class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        //1.visit 1st and last row and colom
        int[][] visit=new int[m][n];
        for(int i=0;i<m;i++){
            bfs(i,0,board,visit);
            bfs(i,n-1,board,visit);
        }
        for(int i=0;i<n;i++){
            bfs(0,i,board,visit);
            bfs(m-1,i,board,visit);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && visit[i][j]==0){
                    board[i][j]='X';
                    
                }
            }
        }
    }
    public void bfs(int i,int j,char[][] board,int[][] visit){
        if(board[i][j]=='O'){
            visit[i][j]=1;
            int[] drow={-1,0,1,0};
            int[] dcol={0,1,0,-1};
            for(int k=0;k<4;k++){
                int i_=drow[k]+i;
                int j_=dcol[k]+j;
                
                if(i_>=0 && j_>=0 && i_<board.length && j_<board[0].length && board[i_][j_]=='O' && visit[i_][j_]==0){
                    // visit[i_][j_]=1;
                    bfs(i_,j_,board,visit);
                }
            }
        }
    }
}

