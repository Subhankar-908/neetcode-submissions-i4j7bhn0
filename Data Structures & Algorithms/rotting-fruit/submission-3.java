class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int tc=0;
        Queue<pair> q=new LinkedList<>();
        boolean[][] visit=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j,0));
                    visit[i][j]=true;
                }else{
                    visit[i][j]=false;
                }
                if(grid[i][j]==1){
                    tc++;
                }
            }
        }
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int tcm=0;
        int cm=0;
        while(!q.isEmpty()){
            pair p=q.poll();
            for(int i=0;i<4;i++){
                int nrow=p.row + drow[i];
                int ncol=p.col + dcol[i];
                int c=p.c;
                cm=Math.max(cm,c);
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol <grid[0].length && grid[nrow][ncol]==1 && visit[nrow][ncol]==false){
                    q.offer(new pair(nrow,ncol,c+1));
                    grid[nrow][ncol]=2;
                    visit[nrow][ncol]=true;
                    tcm++;
                }
            }
        }
        return tc!=tcm ? -1 :cm;
    }
}
class pair{
    int row;
    int col;
    int c;
    public pair(int row,int col,int c){
        this.row=row;
        this.col=col;
        this.c=c;
    }
}