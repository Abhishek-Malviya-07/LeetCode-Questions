class Solution {

    public int maximumAND(int[] nums, int k, int m) {
        long answer = 0;
        int len = nums.length;

        for (int bit = 30; bit >= 0; bit--) {
            long candidate = answer | (1L << bit);
            long[] required = new long[len];

            for (int i = 0; i < len; i++) {
                required[i] = computeExtra(nums[i], candidate);
            }

            Arrays.sort(required);

            long used = 0;
            for (int i = 0; i < m; i++) {
                used += required[i];
                if (used > k) break;
            }

            if (used <= k) {
                answer = candidate;
            }
        }

        return (int) answer;
    }

    private long computeExtra(int value, long mask) {
        long built = 0;

        for (int bit = 30; bit >= 0; bit--) {
            long curr = 1L << bit;

            if ((mask & curr) != 0 || (built | (curr - 1)) < value) {
                built |= curr;
            }
        }

        return built - value;
    }
}
