class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] res = new char[n];
        char curChar = 'a';
        for (int i = 0; i < n; i++) {
            if (res[i] != 0) continue; 
            if (curChar > 'z') return ""; 
            
            for (int j = i; j < n; j++) {
                if (lcp[i][j] > 0) {
                    res[j] = curChar;
                }
            }
            curChar++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int expectedVal = (res[i] == res[j]) ? 1 : 0;
                if (i + 1 < n && j + 1 < n && expectedVal == 1) {
                    expectedVal += lcp[i + 1][j + 1];
                }
                
                if (lcp[i][j] != expectedVal) return "";
            }
        }

        return new String(res);
    }
}