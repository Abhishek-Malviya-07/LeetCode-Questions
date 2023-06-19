class Solution {
    public boolean isHappy(int n) {
        
         if(n==1 || n==10) return true;
         if(n == 7)  return true;
         if(n<=12) return false;
       
        
         int ans = sqrOfN(n);
         while(ans > 0){
         if(ans==1 || ans==10)
             return true;
         else if(ans == 7)  return true; 
         else if(ans<=12) return false;
             else{
                 ans = sqrOfN(ans);
             }
         }
        
        return false;
    }
    
     public static int sqrOfN(int n) {
        int temp = n;
        int sqr = 0;
        
        while (temp > 0) {
            int digit = temp % 10;
            sqr = sqr + (digit * digit);
            temp = temp / 10;
        }
      
        return sqr;
    }
}