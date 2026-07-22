class Solution {
    public int leastInterval(char[] tasks, int n) {
        //1.create map to store char,count
        Map<Character,Integer> frequMap=new HashMap<>();
        for(char c:tasks){
            frequMap.put(c,frequMap.getOrDefault(c,0)+1);
        }

        //2.create PriorityQueue
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)-> b-a);
        queue.addAll(frequMap.values());

        //3.calulate time  
        int time=0;
        while(!queue.isEmpty()){
            //create a list
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n+1;i++){
                if(!queue.isEmpty()){
                    list.add(queue.poll());
                }
            }

            //decrise frequency by one
            for(int frqu:list){
                if(--frqu > 0){
                    queue.add(frqu);
                }
            }
            //add time
            time+=queue.isEmpty()?list.size():n+1;
        }
        return time;



    }
}
