class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int maxl=0;
        int l=0;
        char[] arr=s.toCharArray();
        int r=0;
        for(r=0;r<arr.length;r++){
            int idx=map.getOrDefault(arr[r],-1);
            if(idx!=-1 && idx>=l){
                maxl=Math.max(maxl,r-1-l+1);
                l=idx+1;
            }
            map.put(arr[r],r);
        }
        return Math.max(maxl,r-1-l+1);
    }
}
