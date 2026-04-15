class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int a:piles){
            max=Math.max(max,a);
        }
        int st=1;
        int en=max;
        int ans=0;
        while(st<=en){
            int mid=st+(en-st)/2;
            int ctotal=fans(piles,mid);
            if(ctotal<=h){
                ans=mid;
                en=mid-1;
            }else{
                st=mid+1;
            }
        }
        return ans;
    }
    public int fans(int[] arr,int k){
        int t=0;
        for(int i=0;i<arr.length;i++){
            t+=((arr[i]+k-1)/k);
        }
        return t;
    }
}
