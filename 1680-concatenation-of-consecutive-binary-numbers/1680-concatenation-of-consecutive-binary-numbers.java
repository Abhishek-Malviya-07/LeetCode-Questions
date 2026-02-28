class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int MOD = 1_000_000_007;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {
           
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            res = ((res << bitLength) | i) % MOD;
        }

        return (int) res;
    }
}