class Solution {
    public int search(int[] arr, int target) {
        int p=findpivot(arr);
        if(p==-1){
            return findtarget(arr,target,0,arr.length-1);
        }
        if(arr[p]==target){
            return p;
        }
        if(arr[0]>target){
            return findtarget(arr,target,p+1,arr.length-1);
        }
        return findtarget(arr,target,0,p-1);
    }

    int findtarget(int[] arr,int t,int st,int en){
        while(st<=en){
            int mid=st+(en-st)/2;
            if(arr[mid]==t){
                return mid;
            }
            if(arr[mid]<t){
                return findtarget(arr,t,mid+1,en);
            }else if(arr[mid]>t){
                return findtarget(arr,t,st,mid-1);
            }
        }
        return -1;
    }

    int findpivot(int[] arr){
        int st=0;
        int en=arr.length-1;
        while(st<=en){
            int mid=st+(en-st)/2;
            if(mid<en && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>st && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[st]>arr[mid]){
                en=mid-1;
            }else{
                st=mid+1;
            }
        }
        return -1;
    }
}
