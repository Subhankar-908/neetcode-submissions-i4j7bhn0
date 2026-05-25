class PrefixTree {

    public PrefixTree() {
         
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

    public void insert(String word) {
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

    public boolean startsWith(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
        
            curr=curr.child[idx];
        }
        return true;
    }
}
