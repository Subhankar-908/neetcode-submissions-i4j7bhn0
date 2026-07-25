class MedianFinder {
    PriorityQueue<Integer> queue;
    public MedianFinder() {
        queue=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
            queue.offer(num);
    }
    
    public double findMedian() {
        List<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
            list.add(queue.poll());
        }
        for(int a:list){
            queue.offer(a);
        }
        int n=list.size();
        if(n%2==0){
            return (double)(list.get((n/2)-1)+list.get((n/2)))/2.0;
        }else if(n%2!=0){
            return (double)list.get(list.size()/2);
        }
        return 0.0;
    }
}
