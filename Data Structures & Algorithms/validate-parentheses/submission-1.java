class Solution {
    public boolean isValid(String s) {
        return check(s);

    }
    private boolean check(String s){
        // if(s.equals(""))return true;
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(c!=']' && c!=')' && c!='}'){
                st.push(c);
                
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char t=st.peek();
                if(t=='(' && s.charAt(i)==')'
                || t=='{' && s.charAt(i)=='}'
                || t=='[' && s.charAt(i)==']'){
                    st.pop();
                
                }else{
                    return false;
                }
            }
            i++;
        }
        return st.isEmpty();
    }
}
