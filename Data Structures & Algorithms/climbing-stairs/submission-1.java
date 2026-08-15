class Solution {
    public int climbStairs(int n) {
        int[] arr=new int[n+1];
        Arrays.fill(arr,-1);
       return count(arr,n);
        
    }
    public int count (int[] arr,int n){
        if(n==1)return 1;
        if(n==0) return 1 ;
        if(arr[n]!=-1)return arr[n];
        int left =count(arr,n-1);
        int right=count(arr,n-2);
        arr[n]= left+right;
        return arr[n];
    }

}
