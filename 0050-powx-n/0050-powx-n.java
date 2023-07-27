class Solution {
    public double myPow(double x, int n) {
        
        double  ans =  powerOf(x,n);
        if(n>0){
            return ans;
        }else{
            return 1/ans;
        }
    }
    static double powerOf(double x, int n){
        
        if(n == 0) return 1;
        
        if(n %2 == 0){
            double even = powerOf(x , n/2);
            return even*even;
        }else{
            double odd = powerOf(x , n/2);
            return odd*odd*x;
        }
        
    }
}