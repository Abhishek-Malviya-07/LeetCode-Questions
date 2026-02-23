class Solution {
    public boolean hasAllCodes(String s, int k) {
        int requiredCount = 1 << k;
        boolean[] found = new boolean[requiredCount];
        int count = 0;
        
        int mask = requiredCount - 1;
        int currentHash = 0;

        for (int i = 0; i < s.length(); i++) {
            currentHash = ((currentHash << 1) | (s.charAt(i) - '0')) & mask;

            if (i >= k - 1) {
                if (!found[currentHash]) {
                    found[currentHash] = true;
                    count++;
                    
                    if (count == requiredCount) return true;
                }
            }
        }

        return false;
    }
}