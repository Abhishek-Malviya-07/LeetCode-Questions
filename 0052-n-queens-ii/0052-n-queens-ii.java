class Solution {
     
    public int totalNQueens(int n) {
      char[][] board = new char[n][n];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j] = '.';
            }
        }
        
      //  List<List<String>> ans = new ArrayList<List<String>>();
        int row =0;
        return solve(board,  row);
        
    }
    
    static int solve(char[][] board,int row){
        
        if(row == board.length){
            
            return 1;
        }
        int  ans =0;
        for(int j=0; j<board.length; j++){
            if(isSafe(board , row , j)){
                board[row][j]= 'Q';
               ans +=solve(board,row+1);
                board[row][j] ='.';
            }
            
            
        }
        return ans;
    }
    static boolean isSafe(char[][] board, int row , int col){
        
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q') return false;
        }
        
        for(int i=row-1 , j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q') return false;
        }
        
        for(int i=row-1 , j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q') return false;
        }
       
        return true;
    }
    
    static List<String> construct(char[][] board){
        List<String> temp = new ArrayList<String>();
        
        for(int i=0; i<board.length; i++){
          String sb  = new String(board[i]);
            temp.add(sb);
        }
        return temp;
    }
    
}