class Solution {
    public int[] twoSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n=arr.length;
        int i=0;
        int j=n-1;
       
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[i]+arr[j]==target){
        //             arr1[0]=arr[i];
        //             arr1[1]=arr[j];
        //         }
        //     }
        // }
        // return arr1;

        while(i<j){if(arr[i]+arr[j]==target){
            return new int[]{i+1,j+1};
        }else if(arr[i]+arr[j]>target){
            j--;
        }
        else{
            i++;
        }}
        return new int[]{-1,-1};
    }
}
