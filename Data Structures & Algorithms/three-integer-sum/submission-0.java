class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return check(nums,new ArrayList<>());

    }
    public List<List<Integer>> check(int[] arr ,List<List<Integer>> list){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int r=n-1;
            int l=i+1;
            while(l<r){
                int ans=arr[l]+arr[r]+arr[i];
                if(ans==0){
                    list.add(Arrays.asList(arr[i],arr[l],arr[r]));
                    l++;
                    r--;
                    while(l<r && arr[l]==arr[l-1]){
                        l++;
                    }
                    while(l<r && arr[r]==arr[r+1]){
                        r--;
                    }
                }else if(ans>0){
                    
                    r--;
                }else{
                        l++;
                    }
            }
        }
        return list;
    }
}
// -4,-1,-1,0,1,2