class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int frquency[]=new int[26];
        for(int i=0;i<s1.length();i++){
            frquency[s1.charAt(i)-'a']++;
        }
        int windowsize=s1.length();
        for(int i=0;i<s2.length();i++){
            int windowidx=0;
            int idx=i;
            int subfrquency[]=new int[26];
            while(windowidx<windowsize && idx<s2.length()){
                subfrquency[s2.charAt(idx)-'a']++;
                windowidx++;idx++;
            }
            if(issame(frquency,subfrquency)){
                return true;
            }

        }
        return false;
    }
    public boolean issame(int f1[],int f2[]){
        for(int i=0;i<26;i++){
            if(f1[i]!=f2[i])return false;
        }
        return true;
    }
}
