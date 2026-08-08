class Solution {
    int[][] direction={
        {-1,0},{0,1},{1,0},{0,-1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] PacificO =new boolean[m][n];
        boolean[][] AtlanticO  =new boolean[m][n];
        boolean[][] visit=new boolean[m][n];
        List<List<Integer>> result=new ArrayList<>();
        for(int j=0;j<n;j++){
            dfs(0,j,Integer.MIN_VALUE,heights,PacificO);
             dfs(m-1,j,Integer.MIN_VALUE,heights,AtlanticO);
        }
        for(int i=0;i<m;i++){
            dfs(i,0,Integer.MIN_VALUE,heights,PacificO);
             dfs(i,n-1,Integer.MIN_VALUE,heights,AtlanticO);
        }
        for(int i=0;i<m;i++){
            
            for(int j=0;j<n;j++){
                if(PacificO[i][j] && AtlanticO[i][j]){
                    result.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return result;

    }

    public void dfs(int i,int j,int prevValue,int[][] height,boolean[][] visit){
        if(i<0 || i>=height.length 
        ||j<0 || j>=height[0].length){
            return;
        }

        if(height[i][j] < prevValue || visit[i][j]){
            return ;
        }

        visit[i][j]=true;
        for(int[] a:direction){
            int i_=i+a[0];
            int j_=j+a[1];

            dfs(i_,j_,height[i][j],height,visit);
        }
    }
}
