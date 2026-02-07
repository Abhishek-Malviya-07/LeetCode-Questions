class Solution {
    
     public void DFS(int n, int left, int right, List<String> result, StringBuilder sb) {
        if (left == n && right == n) {
            result.add(sb.toString());
            return;
        }
        
        if (left < n) {
            sb.append('(');
            DFS(n, left + 1, right, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            DFS(n, left, right + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        
        DFS(n, 0, 0, result, new StringBuilder());
        
        return result;
    }
}