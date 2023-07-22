class Solution {
    public void reverseString(char[] s) {
        int left =0;
        int right = s.length-1;
        while(left<right){
            swap(s,left,right);
            left++;
            right--;
        }
        
    }
     static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}