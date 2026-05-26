class WordDictionary {

    public WordDictionary() {

    }
    static class Node{
        Node[] child;
        boolean eow;
        public Node(){
            child=new Node[26];
            for(int i=0;i<26;i++){
                child[i]=null;
            }
            eow=false;
        }
    }
    Node root=new Node();
    public void addWord(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            if(i==word.length()-1){
                curr.child[idx].eow=true;
            }
            curr=curr.child[idx];
        }
    }

    public boolean search(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)=='.'){
                return check(curr,word,i);
            }
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            if(i==word.length()-1 && curr.child[idx].eow==false){
                return false;
            }
            curr=curr.child[idx];
        }
        return true;
    }

    public boolean check(Node curr,String s,int idx){
        if(s.length()==idx)return curr.eow;
        char c=s.charAt(idx);
        if(c=='.'){
            for(int i=0;i<26;i++){
                if(curr.child[i]!=null ){
                    if(check(curr.child[i],s,idx+1)){
                        return true;
                    }
                }
            }
            return false;
        }
        int id=s.charAt(idx)-'a';
        if(curr.child[id]==null){
            return false;
        }
        return check(curr.child[id],s,idx+1);
    }
}
