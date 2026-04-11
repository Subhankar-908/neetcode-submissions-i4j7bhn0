class Solution {
    public List<List<String>> solveNQueens(int n) {

        char[][]board=new char[n][n];
        List<List<String>> Allboard=new ArrayList<>();
        helper(board,Allboard,0);
        return Allboard;

    }

    public static void helper(char[][]board,List<List<String>>Allboard,int col){
        if(col==board[0].length){
            save(board,Allboard);
            return ;
        }

        for(int r=0;r<=board.length-1;r++){
            
                if(isSafe(board,r,col)){
                    board[r][col]='Q';
                    helper(board,Allboard,col+1);
                    board[r][col]='.';
                }
            
        }


    }
    public static void save(char[][] board,List<List<String>>Allboard){
        String row="";
        ArrayList<String> newboard=new ArrayList<>();
        for(int r=0;r<board.length;r++){
            row="";
            for(int c=0;c<board.length;c++){
                if(board[r][c]=='Q'){
                    row+='Q';
                }else{
                    row+='.';
                }
            }
            newboard.add(row);
        }
        Allboard.add(newboard);
    } 

    public static boolean isSafe(char[][] board,int row,int col){
        //Horizental
        int r=row;
        for(int c=0;c<board.length;c++){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        //Vertical
        r=row;
        for(int j=0;j<board.length;j++){
            if(board[j][col]=='Q'){
                return false;
            }
        }
        //Upper right
         r=row;
        for(int c=col;c<board.length && r>=0;c++,r--){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        //Upper left
        r=row;
        for(int c=col;c>=0 && r>=0;c--,r--){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        //Lower right
        r=row;
        for(int c=col;c<board.length && r<board.length;c++,r++){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        //Lower left
        r=row;
        for(int c=col;c>=0 && r<board.length;c--,r++){
            if(board[r][c]=='Q'){
                return false;
            }
        }
        return true;
    } 
}
