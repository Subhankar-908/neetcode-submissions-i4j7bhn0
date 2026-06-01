class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n=position.length;
        double[][] arr=new double[n][2];

        for(int i=0;i<position.length;i++){
            double t=(double)(target-position[i])/speed[i];
            arr[i][0]=position[i];
            arr[i][1]=t;
        }
        Arrays.sort(arr,(a,b)->Double.compare(a[0],b[0]));
        double prev=0;
        int feet=0;

        for(int i=n-1;i>=0;i--){
            double curr=arr[i][1];
            if(curr>prev){
                feet++;
                prev=curr;
            }
        }
        return feet;
    }
}
