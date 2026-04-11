class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n=arr.length;
        int[] arr1=new int[2];
        int l=0;
        for(int i=0;i<n;i++){
            
            for(int j=i+1;j<n;j++){
                int sum=arr[i]+arr[j];
                if(sum==target && i!=j){
                    arr1[0]=i;
                    arr1[1]=j;
                    break;
                }
            }

            // if(arr[i]==target-arr[l]){
            //     arr1[0]=l;
            //     arr1[1]=i;
            //     break;
            // }
            // l++;
        }
        return arr1;
    }
}
