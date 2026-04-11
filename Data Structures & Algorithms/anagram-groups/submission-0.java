class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        List<List<String>> st=new ArrayList<>();
        
         boolean[] visited = new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            List<String> sub=new ArrayList<>();
            if (visited[i]) continue; 
            char[] s1=arr[i].toCharArray();
            int k=0;
            sub.add(arr[i]);
            visited[i] = true;
            
           for(int j=i+1;j<arr.length;j++){
            
            char[] s2=arr[j].toCharArray();
           Arrays.sort(s1);
           Arrays.sort(s2);
            if(Arrays.equals(s1, s2)){
                sub.add(arr[j]);
                visited[j] = true;
            }
            }
            st.add(sub);
        }
        
        return st;
    }
}
