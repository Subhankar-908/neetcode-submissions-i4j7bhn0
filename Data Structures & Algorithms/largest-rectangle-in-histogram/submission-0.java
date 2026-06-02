class Solution {
    public int largestRectangleArea(int[] heights) {
      
        int n=heights.length;
        int ans=0;
        int k=0;
        while(k<n){
            int height=heights[k];
            int i=k-1;
            int j=k+1;
            while(i>=0 && heights[i]>=heights[k]){
                i--;
            }
            while(j<n && heights[j]>=heights[k]){
                j++;
            }
            int weight=j-i-1;
            int area=height*weight;
            ans=Math.max(ans,area);
            k++;
        }
        return ans;
    }
}
