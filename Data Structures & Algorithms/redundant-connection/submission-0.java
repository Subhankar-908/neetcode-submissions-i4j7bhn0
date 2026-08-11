class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
       
        List<List<Integer>> adj=new ArrayList<>();
        
        
        for(int i=0;i<edges.length+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            boolean[]visit=new boolean[edges.length+1];
            if(dfs(u,v,adj,visit)){
                return edge;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return new int[0];
    }
    
    
    public boolean dfs(int parent ,int target,List<List<Integer>> adj,boolean[] visit){
        if(parent==target){
            return true;
        }
        visit[parent]=true;
        for(int a:adj.get(parent)){
            if(!visit[a]){
                if(dfs(a,target,adj,visit)){
                    return true;
                }
            }
        }
        return false;
    }
}
