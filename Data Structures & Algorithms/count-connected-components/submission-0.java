class Solution {
    public int countComponents(int n, int[][] edges) {
        //create a queue: store neighber nodes in one tree cinnection and a visit array :when visit then true 
        Queue<Integer> q=new LinkedList<>();
        boolean[] visit=new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int j=0;j<edges.length;j++){
            adj.get(edges[j][0]).add(edges[j][1]);
            adj.get(edges[j][1]).add(edges[j][0]);
        } 
        int c=0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                visit[i]=true;
                q.offer(i);
                bfs(adj,q,visit);
                c++;
            }
        }
        return c;
    }
    public void bfs(List<List<Integer>> adj,Queue<Integer>q,boolean[] visit){
        while(!q.isEmpty()){
            int p=q.poll();
          
            for(int a:adj.get(p)){
                // if(a==parent){
                //     continue;
                // }
                if(!visit[a]){
                    visit[a]=true;
                    q.offer(a);
                    bfs(adj,q,visit);
                }
            }
        }
    }
}
