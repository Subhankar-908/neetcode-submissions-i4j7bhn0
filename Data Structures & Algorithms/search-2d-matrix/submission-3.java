class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        
        int r=0;
        int c=arr[0].length-1;
        
        while(r<arr.length && c>=0){
            
            if(arr[r][c]==target){
                return true;
            }
            if(arr[r][c]<target){
                r++;
            }else{
                c--;
            }
        }
        return false;
    }
    
}