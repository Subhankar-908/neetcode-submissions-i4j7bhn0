class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> outer=new ArrayList<>();
        helper(nums, 0, outer);
        return outer;
    }
    public void helper(int arr[],int idx,List<List<Integer>> ans){

        if(idx==arr.length){
            List<Integer> a=new ArrayList<>();
            for(int aa:arr){
                a.add(aa);
            }
            ans.add(a);
            return;
        }
        for(int i=idx;i<arr.length;i++){
            swap(arr,idx,i);
            helper(arr,idx+1,ans);
            swap(arr,idx,i);
        }

    }   
    public void swap(int[]arr,int a,int b){
        int t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    } 
}
