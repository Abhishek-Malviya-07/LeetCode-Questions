class Solution {
    public int characterReplacement(String s, int k) {

        int left =0, right =0, maxLength=0 , maxFreq=0;
        int[] freq = new int[26];

        while(right<s.length()){
            freq[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq , freq[s.charAt(right)-'A']);

            if((right-left+1) - maxFreq > k){
                 freq[s.charAt(left)-'A']--;
            
                left++;
                
            }

            maxLength = Math.max(right-left+1 , maxLength);
            right++;
        }
        return maxLength;
        
    }
}