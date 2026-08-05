class Solution {
    public int numIslands(char[][] grid) {
        int [][] visit=new int[grid.length][grid[0].length];
        int c=0;
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                   if(visit[i][j]==0){
                        q.offer(new pair(i,j));
                        c+=bfs(grid,visit,q);
                    }
                }
            }
        }    
        return c;
    }
    public int bfs(char[][] grid,int[][] visit,Queue<pair> q){
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!q.isEmpty()){
            pair p=q.poll();
            int r=p.r;
            int c=p.c;
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length 
                && visit[nrow][ncol]==0 && grid[nrow][ncol]==('1')){
                    q.offer(new pair(nrow,ncol));
                    visit[nrow][ncol]=1;
                }
            }
        }
        return 1;

    }

}
class pair{
    int r;
    int c;
    public pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
