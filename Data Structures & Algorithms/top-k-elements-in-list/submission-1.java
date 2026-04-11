

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        //store and count element
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //sort the element based on vluaes on dissending order 
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((a,b)->b.getValue().compareTo(a.getValue()));

        //create a new array which store element there count base 
        int[] arr=new int[k];

        for(int i=0;i<k;i++){
            arr[i]=list.get(i).getKey();
        }
        return arr;

    }
    

}
