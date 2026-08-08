class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[]visit=new int[numCourses];
        int[]pvisit=new int[numCourses];
        List<Integer> anslist=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(visit[i]==0){
                visit[i]=1;
                pvisit[i]=1;
                if(dfs(i,adj,anslist,visit,pvisit)){
                    return new int[0];
                }
            }
        }
        
    int[] ans = new int[anslist.size()];
    Collections.reverse(anslist);

    for(int i = 0; i < anslist.size(); i++){
        ans[i] = anslist.get(i);
    }
        return ans;
    }
    public boolean dfs(int node,List<List<Integer>> adj,List anslist,int[] visit,int[] pvisit){
        for(Integer a:adj.get(node)){
            if(visit[a]==0){
                visit[a]=1;
                pvisit[a]=1;
                if(dfs(a,adj,anslist,visit,pvisit)){
                    return true;
                }
            }else{
                if(pvisit[a]==1){
                    return true;
                }
            }
        }
        pvisit[node]=0;
        anslist.add(node);
        return false;
    }
}
