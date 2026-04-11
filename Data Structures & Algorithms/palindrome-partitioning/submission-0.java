class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> parth=new ArrayList<>();
        getAllPath(s,parth,ans);
        // for(List<String> a:ans){
        //     System.out.println(a.toString());
        // }
        // System.out.println(ans.toList());
        return ans;
    }
    public boolean isPalindrom(String s){
        // String s2=s;
        String s2=new StringBuilder(s).reverse().toString();
        return s2.equals(s);
    }
    public void getAllPath(String s,List<String> parth,List<List<String>>ans){
        //base case
        if(s.length()==0){
            //store in answer list
            ans.add(new ArrayList<>(parth));
            return;
        }
        //iterate orignal string
        for(int i=0;i<s.length();i++){
            //store subString
            String sub=s.substring(0,i+1);
            //chech is palindrom or not
            if(isPalindrom(sub)){
                //store substring in inner list
                parth.add(sub);
                //recursive call
                getAllPath(s.substring(i+1),parth,ans);
                //back track
                parth.remove(parth.size()-1);
            }
        }
    }
}
