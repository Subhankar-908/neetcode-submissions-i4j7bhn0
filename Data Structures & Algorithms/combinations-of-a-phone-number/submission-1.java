class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> st=new ArrayList<>();
        if(!digits.isEmpty()){
            st=sub("",digits);
        }else{
            return st;
        }
        return st;
    }
    public List<String> sub(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> st=new ArrayList<>();
            st.add(p);
            return st;
        }
        String[] letter={
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        List<String> st1=new ArrayList<>();
        int dig=up.charAt(0)-'0';
        String ch=letter[dig];
        for(int i=0;i<ch.length();i++){
            
            st1.addAll(sub(p+ch.charAt(i),up.substring(1)));
            
        }
        return st1;
    }
}
