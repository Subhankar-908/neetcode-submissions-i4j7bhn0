class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        double arr[][]=new double[n][3];
        for(int i=0;i<n;i++){
            double dist=Math.sqrt(
                points[i][0]*points[i][0]+
                points[i][1]*points[i][1]
            );

            arr[i][0]=dist;
            arr[i][1]=points[i][0];
            arr[i][2]=points[i][1];
        }

        Arrays.sort(arr,(a,b)->Double.compare(a[0],b[0]));
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            ans[i][0]=(int)arr[i][1];
            ans[i][1]=(int)arr[i][2];
        }
        return ans;

    }
}
