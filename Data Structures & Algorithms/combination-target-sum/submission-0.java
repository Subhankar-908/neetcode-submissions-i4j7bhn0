class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        find(nums,0,target,l,li);
        return l;
    }

    void find(int[] a,int i,int b,List<List<Integer>> l,List<Integer> li){
        if(b==0){
            l.add(new ArrayList<>(li));
            return;
        }
        if(a.length<=i || b<0){
            return;
        }
        // while(b-a[i]>=0 && a.length>i){
            li.add(a[i]);
            find(a,i,b-a[i],l,li);
            // i++;
            li.remove(li.size()-1);
        // }
        find(a,i+1,b,l,li);
    }
}
