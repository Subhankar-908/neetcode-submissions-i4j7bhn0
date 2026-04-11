class Solution {
    public int findMin(int[] arr) {
        int st=0;
        int en=arr.length-1;
        while(st<en){
            int mid=st+(en-st)/2;

            if(arr[st]<arr[en]){
                return arr[st];
            }
            if(arr[mid]>=arr[st]){
                st=mid+1;
            }else{
                en=mid;
            }
        }
        return arr[st];
    }
}
