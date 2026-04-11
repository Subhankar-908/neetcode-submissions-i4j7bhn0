class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> li =new ArrayList<>();
        create("",li,n,0,0);
        return li;
    }
    public void create(String s,List<String> li,int n,int st,int en){
        if(en>=n){
            li.add(s);
            return;
        }
        if(st<n)create(s+"(",li,n,st+1,en);
        if(st>en)create(s+")",li,n,st,en+1);
    }
}
