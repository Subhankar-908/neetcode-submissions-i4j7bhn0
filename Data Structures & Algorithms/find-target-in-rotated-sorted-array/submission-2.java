class Solution {
    public int search(int[] arr, int target) {
        int st=0;
        int en=arr.length-1;
        while(st<=en){
            int mid=st+(en-st)/2;
            if(arr[mid]==target){
                return mid;
            }
            //left helf is sorted
            if(arr[st]<=arr[mid]){
                if(arr[st]<=target && arr[mid]>target){
                    en=mid-1;
                }else{
                    st=mid+1;
                }
            }
            //right half is sorted
            else{
                if(target>arr[mid] && target<=arr[en]){
                    st=mid+1;
                }else{
                    en=mid-1;
                }
            }
        }
        return -1;
    }

    
}
