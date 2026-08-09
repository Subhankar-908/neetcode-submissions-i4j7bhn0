class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int j=0;j<edges.length;j++){
            adj.get(edges[j][0]).add(edges[j][1]);
            adj.get(edges[j][1]).add(edges[j][0]);
        }
        int[] visit=new int[n];
        if(dfs(adj,0,visit,-1)){
            return false;
        }
        for(int i=0;i<n;i++){
            if(visit[i]==0){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>>adj,int node,int[] visit,int parent){
        visit[node]=1;
        for(Integer a:adj.get(node)){
            if(a==parent){
                continue;
            }
            if(visit[a]==1 ){
                return true;
            }
            if(dfs(adj,a,visit,node)){
                return true;
            }
            
            
        }
        
        return false;
    }
}
