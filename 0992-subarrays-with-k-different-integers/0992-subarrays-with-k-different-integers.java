class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        if (k == 0) return 0;
        
        int n = nums.length;
        int left = 0;
        int count = 0;
        int distinct = 0;
        int[] freq = new int[n + 1];

        for (int right = 0; right < n; right++) {
            
            if (freq[nums[right]] == 0) {
                distinct++;
            }
            freq[nums[right]]++;

          
            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}