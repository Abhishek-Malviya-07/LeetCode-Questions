class Solution {
    public int largestAltitude(int[] gain) {
        int[] ans = new int[gain.length+1];
        ans[0] = 0;
        int sum = 0;
        int highAltitude = 0;
        for(int i=0; i<gain.length; i++){
            ans[i+1] = (sum + gain[i]);
            sum = ans[i+1];
            if(sum > highAltitude) highAltitude = sum;
        }
        
    
        return highAltitude;
    }
}