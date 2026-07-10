class Solution {

    List<Integer> list = new ArrayList<>();

    public int lastStoneWeight(int[] stones) {

        for(int stone : stones){
            list.add(stone);
            upheap(list.size()-1);
        }

        while(list.size() > 1){

            int first = removeMax();
            int second = removeMax();

            if(first != second){
                list.add(first-second);
                upheap(list.size()-1);
            }
        }

        return list.isEmpty() ? 0 : list.get(0);
    }

    int parent(int i){
        return (i-1)/2;
    }

    int left(int i){
        return 2*i+1;
    }

    int right(int i){
        return 2*i+2;
    }

    void swap(int i,int j){
        int temp=list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    void upheap(int idx){

        if(idx==0) return;

        int p=parent(idx);

        if(list.get(p)<list.get(idx)){
            swap(p,idx);
            upheap(p);
        }
    }

    void downheap(int idx){

        int max=idx;

        int l=left(idx);
        int r=right(idx);

        if(l<list.size() && list.get(l)>list.get(max))
            max=l;

        if(r<list.size() && list.get(r)>list.get(max))
            max=r;

        if(max!=idx){
            swap(max,idx);
            downheap(max);
        }
    }

    int removeMax(){

        int ans=list.get(0);

        swap(0,list.size()-1);

        list.remove(list.size()-1);

        if(!list.isEmpty())
            downheap(0);

        return ans;
    }
}