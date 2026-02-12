class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        int[] globalFreq = new int[26];
        int totalUnique = 0;
        for (char c : s.toCharArray()) {
            if (globalFreq[c - 'a']++ == 0) totalUnique++;
        }

        for (int D = 1; D <= totalUnique; D++) {
            for (int F = 1; D * F <= n; F++) {
                int len = D * F;
                if (len <= maxLen) continue; 
                int[] freq = new int[26];
                int distinct = 0;
                int countAtF = 0;

                for (int i = 0; i < n; i++) {
                    int rIdx = s.charAt(i) - 'a';
                    if (freq[rIdx] == 0) distinct++;
                    freq[rIdx]++;
                    if (freq[rIdx] == F) countAtF++;
                    else if (freq[rIdx] == F + 1) countAtF--;

                    if (i >= len) {
                        int lIdx = s.charAt(i - len) - 'a';
                        if (freq[lIdx] == F) countAtF--;
                        else if (freq[lIdx] == F + 1) countAtF++;
                        freq[lIdx]--;
                        if (freq[lIdx] == 0) distinct--;
                    }
                    if (i >= len - 1) {
                        if (distinct == D && countAtF == D) {
                            maxLen = len;
                        }
                    }
                }
            }
        }
        return maxLen;
    }
}