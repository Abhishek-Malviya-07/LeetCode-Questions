class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        if (digits.isEmpty()) {
            return ans;
        }
        
        solve(digits, ans, sb, 0, mapping);
        
        return ans;
    }
    
    private void solve(String digits, List<String> ans, StringBuilder sb, int index, String[] mapping) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        
        int number = digits.charAt(index) - '0';
        String value = mapping[number];
        
        for (int i = 0; i < value.length(); i++) {
            sb.append(value.charAt(i));
            solve(digits, ans, sb, index + 1, mapping);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
