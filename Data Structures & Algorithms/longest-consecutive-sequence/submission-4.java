class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int count=1;
        int maxv=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) continue;
            if(nums[i]==nums[i-1]+1) {count++;
            }else{
                maxv=Math.max(maxv,count);
                count=1;
            }
        }
        return Math.max(maxv,count);
    }
}
