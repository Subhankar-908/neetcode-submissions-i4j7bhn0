class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q=new LinkedList<>();
        Set<String> st=new HashSet<>();
        int n=wordList.size();
        for(int i=0;i<n;i++){
            st.add(wordList.get(i));
        }
        q.offer(new pair(beginWord,1));

        while(!q.isEmpty()){
            pair p=q.poll();
            String s=p.s;
            int step=p.step;
            if(s.equals(endWord))return step;
            for(int i=0;i<s.length();i++){
                char[] arr=s.toCharArray();
                for(char j='a';j<='z';j++){
                    
                    arr[i]=j;
                    String newS=new String(arr);
                    if(st.contains(newS)){
                        st.remove(newS);
                        q.offer(new pair(newS,step+1));
                    }
                }
            }
        }
        return 0;

    }
}
class pair{
    String s;
    int step;
    public pair(String s,int step){
        this.s=s;
        this.step=step;
    }
}

