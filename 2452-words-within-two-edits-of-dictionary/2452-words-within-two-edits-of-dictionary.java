class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        
        for (String query : queries) {
            for (String word : dictionary) {
                if (canMatch(query, word)) {
                    result.add(query);
                    break;
                }
            }
        }
        
        return result;
    }
    
    private boolean canMatch(String s1, String s2) {
        int edits = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                edits++;
            }
           
            if (edits > 2) return false;
        }
        return true;
    }
}