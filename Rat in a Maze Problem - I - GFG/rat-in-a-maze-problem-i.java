//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
       
        // Your code here
        ArrayList<String> ans = new ArrayList<String>();
        if(m[0][0] == 0) return ans;
        StringBuilder sb = new StringBuilder();
        int x =0;
        int y =0;
        
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
              visited[i][j] = 0;
    }
}
        solveMaze(m,n,ans,sb,x,y,visited);
        return ans;
    }
    
    static void solveMaze(int[][] m ,int n, ArrayList<String> ans , StringBuilder sb ,int x , int y,int[][] visited){
        
        if(x == n-1 && y==n-1){
            ans.add(sb.toString());
            return;
        }
        
         visited[x][y] =1;
         
         //down
         int nx = x+1;
         int ny  = y;
         if(isCheck(nx,ny,m,n,visited)){
              sb.append("D");
              solveMaze(m,n,ans,sb,nx,ny,visited);
              sb.deleteCharAt(sb.length() - 1);
         }
        
        //left
    
          nx = x;
          ny  = y-1;
         if(isCheck(nx,ny,m,n,visited)){
              sb.append("L");
              solveMaze(m,n,ans,sb,nx,ny,visited);
              sb.deleteCharAt(sb.length() - 1);
         }
         
         //right
         
          nx = x;
          ny  = y+1;
         if(isCheck(nx,ny,m,n,visited)){
              sb.append("R");
              solveMaze(m,n,ans,sb,nx,ny,visited);
              sb.deleteCharAt(sb.length() - 1);
         }
         
         //up
          nx = x-1;
          ny  = y;
         if(isCheck(nx,ny,m,n,visited)){
              sb.append("U");
              solveMaze(m,n,ans,sb,nx,ny,visited);
              sb.deleteCharAt(sb.length() - 1);
         }
         
         visited[x][y] =0;
    }
     
     static boolean isCheck(int x , int y , int[][] m , int n , int[][] visited){
         
         if((x>=0 && x<n) && (y>=0 && y<n) && (visited[x][y] ==0) && (m[x][y] == 1)){
             return true;
         }else{
             return false;
         }
     }
}