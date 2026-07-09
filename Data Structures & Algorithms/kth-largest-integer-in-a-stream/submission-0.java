class KthLargest {

    int k;
    ArrayList<Integer> list;
    public KthLargest(int k, int[] nums) {
         this.k=k;
        list=new ArrayList<>();
        for(int i:nums){
            list.add(i);
            upheap(list.size()-1);
            if(list.size()>k){
                remove();
            }
        }
       
    }
    
    public int add(int val) {
        list.add(val);
        upheap(list.size()-1);
        if(list.size()>k){
            for(int i=0;i<(list.size()-k);i++){
                remove();
            }
        }
        return list.get(0);
    }
    public int left(int idx){
        return 2*idx+1;
    }
    public int right(int idx){
        return 2*idx+2;
    }
    public int parent(int idx){
        if(idx==0)return 0;
        return (idx-1)/2;
    }
    public void swap(int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }
    public void upheap(int idx){
        if(idx==0)return;
        int pidx=parent(idx);
        if(list.get(pidx)>list.get(idx)){
            swap(pidx,idx);
            upheap(pidx);
        }
    }
    public void downheap(int idx){
        int min=idx;
        int left=left(idx);
        int right=right(idx);
        if(left<list.size() && list.get(left)<list.get(min)){
            min=left;
        }
        if(right<list.size() && list.get(right)<list.get(min)){
            min=right;
        }
        if(min!=idx){
            swap(min,idx);
            downheap(min);
        }
    }
    public void remove(){
        int temp=list.get(0);
        int last=list.remove(list.size()-1);

        if(!list.isEmpty()){
            list.set(0,last);
            downheap(0);
        }
    }
    
}
