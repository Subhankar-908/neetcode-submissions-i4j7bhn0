class Solution {
    public int evalRPN(String[] tokens) {
        return result(tokens);
    }
    private int result(String[] token){
        Stack<Integer> st=new Stack<>();
        int r=0;
        for(int i=0;i<token.length;i++){
            String s=token[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int a=st.pop();
                // st.pop();
                int b=st.pop();
                // st.pop();
                if(s.equals("+")){
                    r=(b+a);
                }
                else if(s.equals("-")){
                    r=(b-a);
                }
                else if(s.equals("*")){
                    r=(b*a);
                }
                else{
                    r=(b/a);
                }
                st.push(r);
            }
            else{
                st.add(Integer.parseInt(s));
            }
        }

        return st.peek();
    }
}
