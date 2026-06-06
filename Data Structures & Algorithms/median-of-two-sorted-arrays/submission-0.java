class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] arr=new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(j<m && k<n){
            
            if(j<m && nums1[j]<=nums2[k]){
                
                arr[i++]=nums1[j++];
                
            }else {
                if(k<n){
                    arr[i++]=nums2[k++];
                }
            }
        }
            while(j<m){
                arr[i++]=nums1[j++];
            }
            while(k<n){
                arr[i++]=nums2[k++];
            }
            
        
        int size=arr.length;
        float ans=0;
        if(size%2==0){
            int mid=size/2;
            return(arr[mid-1]+arr[mid])/2.0;
        }
        return arr[size/2];
    }
}
