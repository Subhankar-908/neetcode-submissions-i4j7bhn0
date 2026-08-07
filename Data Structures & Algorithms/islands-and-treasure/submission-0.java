class Solution {
    public void islandsAndTreasure(int[][] grid) {
        //0 is gate count distent between gate each empty space
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0 ) {
                    q.offer(new pair(i,j,0));
                    // bfs(i,j,grid,q);
                }
            }
        }bfs(grid,q);
    }
    public void bfs(int[][] grid,Queue<pair> q){
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!q.isEmpty()){
            pair p=q.poll();
            for(int k=0;k<4;k++){
                int nrow=drow[k]+p.i;
                int ncol=dcol[k]+p.j;
                int qc=p.c+1;
                if(nrow >= 0 && nrow<grid.length && ncol>=0 
                && ncol<grid[0].length &&
                grid[nrow][ncol]==  Integer.MAX_VALUE){
                    grid[nrow][ncol]=qc;
                    q.offer(new pair(nrow,ncol,qc));
                }
            }
           
        }

    }
}
class pair{
    int i;
    int j;
    int c;
    public pair(int i,int j,int c){
        this.i=i;
        this.j=j;
        this.c=c;
    }
}
