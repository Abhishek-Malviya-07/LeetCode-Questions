class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(0,0,n,ans,sb);
        return ans;
    }

  static void dfs(int left , int right , int n , List<String> ans , StringBuilder sb){

    if(left == n && right == n){
        ans.add(sb.toString());
        return;
    }

    if(left<n){
        sb.append("(");
        dfs(left+1 , right ,n , ans , sb);
        sb.deleteCharAt(sb.length() - 1); 
    }

    if(right < left){
        sb.append(")");
        dfs(left , right+1 , n ,ans , sb);
        sb.deleteCharAt(sb.length() - 1); 
    }
  }
}