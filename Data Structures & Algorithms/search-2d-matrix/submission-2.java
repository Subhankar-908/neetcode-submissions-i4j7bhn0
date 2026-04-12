class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        
        int r=arr.length;
        int c=arr[0].length;
        if(r==1){
            return bsearch(arr,target,0,0,c-1);
        }
        if(r==0){
            return false;
        }

        int rst=0;
        int ren=r-1;
        
        while(rst<= ren){
            int rmid=rst+(ren-rst)/2;

            if(arr[rmid][0]<=target && arr[rmid][c-1]>=target){
                return bsearch(arr,target,rmid,0,c-1);
            }
            if(arr[rmid][c-1]<target){
                rst=rmid+1;
            }else{
                ren=rmid-1;
            }
        }
        return false;
    }

    public static boolean bsearch(int[][] arr,int target,int r,int cst,int cen){
        while(cst<=cen){
            int mid=cst+(cen-cst)/2;
            if(arr[r][mid]==target){
                return true;
            }
            else if(arr[r][mid]<target){
                cst=mid+1;
            }else{
                cen=mid-1;
            }
        }
        return false;
    }
    
}
