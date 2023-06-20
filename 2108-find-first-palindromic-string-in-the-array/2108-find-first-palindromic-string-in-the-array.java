class Solution {
    public String firstPalindrome(String[] words) {
        int size = words.length;
       for(int i=0; i<size; i++) {
           if(isPalindrome(words[i])){
              return words[i];  
           }
       }
        return "";
    }
    
    public static boolean isPalindrome(String s){
      
        int left =0;
        int right=s.length()-1;
        while(left<right){

            if(s.charAt(left) == s.charAt(right)){
              
                left++;
                right--;    
            
            }else{
               return false;
            }
            
        }
        return true;
    }
    
}