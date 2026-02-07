class Solution {
    public int minimumDeletions(String s) {
        int deletions = 0;
        int bCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                // We don't need to delete 'b's yet; just track them.
                bCount++;
            } else {
                // We found an 'a'. We must decide:
                // 1. Delete this 'a' (previous deletions + 1)
                // 2. Keep this 'a' and delete all previous 'b's (bCount)
                deletions = Math.min(deletions + 1, bCount);
            }
        }

        return deletions;
    }
}