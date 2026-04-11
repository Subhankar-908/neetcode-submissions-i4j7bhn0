class Solution {
    public int search(int[] arr, int target) {
        int f=0;
        int e=arr.length-1;
        int m=0;
        while(f<=e)
        {
            m=f+(e-f)/2;
            if(target==arr[m]){
                return m;
            }
            if(target>arr[m]){
            f=m+1;
            }
            else{
                e=m-1;
            }
        }
        return -1;
    }
}
