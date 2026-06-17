class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] L = new long[n];
        
     
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            long prevL = (i == 0) ? 0 : L[i - 1];
            
            if (c >= 'a' && c <= 'z') {
                L[i] = prevL + 1;
            } else if (c == '*') {
                L[i] = Math.max(0, prevL - 1);
            } else if (c == '#') {
                L[i] = prevL * 2;
            } else if (c == '%') {
                L[i] = prevL;
            }
        }
        
  
        if (k >= L[n - 1]) {
            return '.'; 
        }
        
        
        long idx = k;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long currL = L[i];
            long prevL = (i == 0) ? 0 : L[i - 1];
            
            if (c >= 'a' && c <= 'z') {
                if (idx == currL - 1) {
                    return c; 
                }
            } else if (c == '#') {
                
                if (idx >= prevL) {
                    idx -= prevL;
                }
            } else if (c == '%') {
               
                idx = prevL - 1 - idx;
            }
            
        }
        
        return '.'; 
    }
}