class Solution {
    public int longestBalanced(int[] nums) {
        int maxLen = 0;
        
        // Find the total number of distinct elements to know how many targets to check
        Set<Integer> evens = new HashSet<>();
        Set<Integer> odds = new HashSet<>();
        for (int x : nums) {
            if (x % 2 == 0) evens.add(x);
            else odds.add(x);
        }
        
        int maxPossibleTarget = Math.min(evens.size(), odds.size());

        // Iterate through each possible number of distinct pairs
        for (int target = 1; target <= maxPossibleTarget; target++) {
            maxLen = Math.max(maxLen, solveForTarget(nums, target));
        }
        return maxLen;
    }

    private int solveForTarget(int[] nums, int target) {
        int left = 0, currentMax = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int distinctEven = 0, distinctOdd = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            
            // Add to frequency map
            int count = freqMap.getOrDefault(val, 0);
            if (count == 0) {
                if (val % 2 == 0) distinctEven++;
                else distinctOdd++;
            }
            freqMap.put(val, count + 1);

            // Shrink window if distinct counts exceed our current target
            while (distinctEven > target || distinctOdd > target) {
                int leftVal = nums[left];
                int leftCount = freqMap.get(leftVal);
                if (leftCount == 1) {
                    if (leftVal % 2 == 0) distinctEven--;
                    else distinctOdd--;
                    freqMap.remove(leftVal);
                } else {
                    freqMap.put(leftVal, leftCount - 1);
                }
                left++;
            }

            // Validation: Must have exactly target distinct evens AND target distinct odds
            if (distinctEven == target && distinctOdd == target) {
                currentMax = Math.max(currentMax, right - left + 1);
            }
        }
        return currentMax;
    }
}