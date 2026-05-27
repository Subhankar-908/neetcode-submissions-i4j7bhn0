class Solution {
    static class Node{
        Node[] child;
        boolean eow;
        public Node(){
            child=new Node[26];
            eow=false;
        }

    }
    Node root=new Node();
     List<String> list = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
       for(String s:words){
            createTrie(s);
       }
       for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(root, board, i, j, "");
            }
            }
       return list;

    }
   
    private void createTrie(String s){
         Node curr=root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            if(i==s.length()-1){
                curr.child[idx].eow=true;
            }
            curr=curr.child[idx];
        }
    }
    
    
    private void dfs(Node curr,char[][] board,int r,int c,String s){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length){
            return ;
        }
        
        if(board[r][c]=='#'){
            return ;
        }
        char ch=board[r][c];
        if(curr.child[ch-'a']==null){
            return;
        }
        s+=ch;
        curr=curr.child[ch-'a'];

        if(curr.eow){
            if(!list.contains(s)){
                list.add(s);
            }
        }
        
        board[r][c]='#';
            dfs(curr,board,r+1,c,s);
            dfs(curr,board,r-1,c,s);
            dfs(curr,board,r,c+1,s);
            dfs(curr,board,r,c-1,s);
        board[r][c]=ch;
    }

}
