class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        int[] arr=new int[k];
        Arrays.sort(nums);
        int r=nums[n-1];
        int c=0;
        arr[c++]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=r && c<k){
                r=nums[i];
                arr[c++]=r;

            }
        }
        return arr[k-1];
    }
}
