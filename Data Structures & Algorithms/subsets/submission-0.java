class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int a:nums){
            int n=outer.size();
            for(int j=0;j<n;j++){
                List<Integer> inner=new ArrayList<>(outer.get(j));
                inner.add(a);
                outer.add(inner);
            }
        }
        return outer;
    }
}
