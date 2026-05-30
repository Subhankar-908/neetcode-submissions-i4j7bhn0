    class Solution {
        public int trap(int[] arr) {
            int n=arr.length;
            int[] lmax=new int[n];
            int[] rmax=new int[n];
            for(int i=0;i<n;i++){
                if(i==0){
                    lmax[i]=arr[i];
                }else{
                    lmax[i]=Math.max(arr[i],lmax[i-1]);
                }
                
            }
            for(int i=n-1;i>=0;i--){
                if(i==(n-1)){
                    rmax[i]=arr[i];
                }else{
                    rmax[i]=Math.max(arr[i],rmax[i+1]);
                }
                
            }
            int ans=0;
            for(int i=0;i<n;i++){
                int min=Math.min(lmax[i],rmax[i]);
                if(min>0){
                    ans+=(min-arr[i]);
                }
                
            }
            return ans;
        }

    }
