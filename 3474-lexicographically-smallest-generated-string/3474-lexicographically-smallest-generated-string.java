class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;
        char[] word = new char[len];
        boolean[] forced = new boolean[len];
        
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (forced[i + j] && word[i + j] != str2.charAt(j)) return "";
                    word[i + j] = str2.charAt(j);
                    forced[i + j] = true;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (!forced[i]) word[i] = 'a';
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                if (isMatch(word, str2, i)) {
                    boolean changed = false;
                    for (int j = m - 1; j >= 0; j--) {
                        if (!forced[i + j]) {
                            word[i + j] = 'b';
                            
                            changed = true;
                            break;
                        }
                    }
                    if (!changed) return ""; 
                }
            }
        }
        
     
        for(int i = 0; i < n; i++) {
            boolean match = isMatch(word, str2, i);
            if (str1.charAt(i) == 'T' && !match) return "";
            if (str1.charAt(i) == 'F' && match) return "";
        }

        return new String(word);
    }

    private boolean isMatch(char[] word, String str2, int start) {
        for (int j = 0; j < str2.length(); j++) {
            if (word[start + j] != str2.charAt(j)) return false;
        }
        return true;
    }
}