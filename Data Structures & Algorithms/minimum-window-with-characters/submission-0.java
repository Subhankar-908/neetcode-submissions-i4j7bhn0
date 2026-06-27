class Solution {
    public String minWindow(String s, String t) {
        int[] maps=new int[256];
        int[] mapt=new int[256];

        for(char ch:t.toCharArray()){
            mapt[ch]++;
        }

        int left=0;int right=0;
        int minlen=Integer.MAX_VALUE;
        int minstart=0;
        for(;right<s.length();right++){
            maps[s.charAt(right)]++;
            while(contains(maps,mapt)){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    minstart=left;
                }
                maps[s.charAt(left++)]--;
            }
        }
        return minlen==Integer.MAX_VALUE?"":s.substring(minstart,minstart+minlen);

    }
    public boolean contains(int[] maps,int[] mapt){
        for(int i=0;i<256;i++){
            if(maps[i]<mapt[i]){
                return false;
            }
        }
        return true;
    }
}
