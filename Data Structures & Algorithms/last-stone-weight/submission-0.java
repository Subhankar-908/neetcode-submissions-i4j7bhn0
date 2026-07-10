class Solution {
    List<Integer> list=new ArrayList<>();
    public int lastStoneWeight(int[] stones) {
        addvalue(stones);
        return check();
    }
    public void addvalue(int[] arr){
        for(int i:arr){
            list.add(i);
            upheap(list.size()-1);
        }
    }
    public int parent(int idx){
        if(idx==0)return 0;
        return (idx-1)/2;
    }
    public int left(int idx){
        return 2*idx+1;
    }
    public int right(int idx){
        return 2*idx+2;
    }
    public void swap(int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }
    public void upheap(int idx){
        if(idx==0)return;
        int pidx=parent(idx);
        if(list.get(pidx)<list.get(idx)){
            swap(pidx,idx);
            upheap(pidx);
        }
    }
    public void downheap(int idx){
        int min=idx;
        int left=left(idx);
        int right=right(idx);
        if(left<list.size() && list.get(left)>list.get(min)){
            min=left;
        }
        if(right<list.size() && list.get(right)>list.get(min)){
            min=right;
        }
        if(min!=idx){
            swap(min,idx);
            downheap(min);
        }
    }
    public int check(){

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
    public int removeMax(){

    int ans = list.get(0);

    swap(0, list.size()-1);

    list.remove(list.size()-1);

    if(!list.isEmpty()){
        downheap(0);
    }

    return ans;
}
}
