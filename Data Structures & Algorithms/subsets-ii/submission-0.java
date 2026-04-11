class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        int st=0;
        int en=0;
        for(int i=0;i<nums.length;i++){
            st=0;
            if(i>0 && nums[i]==nums[i-1]){
                st=en+1;
            }
            en=outer.size()-1;
            
            for(int j=st;j<=en;j++){
                List<Integer> inner=new ArrayList<>(outer.get(j));
                inner.add(nums[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
