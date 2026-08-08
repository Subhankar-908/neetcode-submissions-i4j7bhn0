class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int m=prerequisites.length;
        int[] visit=new int[numCourses];
        int[] pathvisit=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(visit[i]==0){
                visit[i]=1;
                pathvisit[i]=1;
                if(dfs(i,visit,pathvisit,adj)){
                    return false;
                }
            }else{
                continue;
            }
        }
        return true;
    }
    public boolean dfs(int node,int[]visit,int []pathvisit,List<List<Integer>> adj){
        for(Integer a:adj.get(node)){
            if(visit[a]==0){
               
                    visit[a]=1;
                    pathvisit[a]=1;
                    if(dfs(a,visit,pathvisit,adj)){
                        return true;
                    }
                
            }else{
                if(pathvisit[a]==1){
                    return true;
                }
            }
        }
        pathvisit[node]=0;
        return false;
    }
}
