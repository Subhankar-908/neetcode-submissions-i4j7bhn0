class TimeMap {
    class Pair{
        int timestamp;
        String value;
        public Pair(String value,int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> list=map.get(key);
        String ans="";
        int l=0;
        int r=list.size()-1;
        while(l<=r){
            int mid = l+(r-1)/2;
            if(list.get(mid).timestamp<=timestamp){
                ans=list.get(mid).value;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
}
