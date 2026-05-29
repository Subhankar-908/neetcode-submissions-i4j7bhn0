class Solution {
    public int maxArea(int[] heights) {
        if(heights.length==0)return 0;
        int r=heights.length-1;
        int l=0;
        int contener=0;
        while(l<r){
            int minh=Math.min(heights[r],heights[l]);
            int weigth=r-l;
             contener=Math.max(contener,minh*weigth);
            if(heights[r]>heights[l]){
                l++;
            }else{
                r--;
            }
        }
        return contener;
    }
}
