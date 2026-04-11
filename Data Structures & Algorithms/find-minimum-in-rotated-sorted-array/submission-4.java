class Solution {
    public int findMin(int[] arr) {
        int st=0;
        int en=arr.length-1;
        while(st<en){
            int mid=st+(en-st)/2;
            // if(mid+1<=en && arr[mid]>arr[mid+1]){
            //     return arr[mid+1];
            // }
            // if(mid-1>=st && arr[mid]<arr[mid-1]){
            //     return arr[mid];
            // }
            // if(arr[st]<arr[en]){
            //     return arr[st];
            // }
            // if(arr[st]>arr[mid]){
            //     en=mid-1;
            // }
            // else{
            //     st=mid+1;
            // }

            if(arr[mid]<arr[en]){
                en=mid;
            }else{
                st=mid+1;
            }
        }
        return arr[st];
    }
}
