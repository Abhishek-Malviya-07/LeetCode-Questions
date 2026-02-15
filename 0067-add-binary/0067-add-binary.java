class Solution {
    public String addBinary(String a, String b) {
        
    StringBuilder result = new StringBuilder();
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;
    
    while (i >= 0 || j >= 0 || carry != 0) {
        int digitSum = carry;
        if (i >= 0) {
            digitSum += Character.getNumericValue(a.charAt(i));
            i--;
        }
        if (j >= 0) {
            digitSum += Character.getNumericValue(b.charAt(j));
            j--;
        }
        
        result.insert(0, digitSum % 2);
        carry = digitSum / 2;
    }
    
    return result.toString();
}
}