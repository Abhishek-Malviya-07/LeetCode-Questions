
class Solution {
    public int lengthOfLastWord(String s) {
        int ans=0;
        int found=0;
        char gap=' ';
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==gap && found==0){
                continue;
            }else if(s.charAt(i)!=gap){
                ans++;
                found++;
            }else{
                break;
            }
        }return ans;        
    }
}