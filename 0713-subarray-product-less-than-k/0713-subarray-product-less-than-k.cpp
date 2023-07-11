class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int i=0;
        int j=0;
        int prod=1;
        int ans=0;

        while(j<nums.size())
        {
            prod *= nums[j];

           
                while(prod>=k && i<=j)
                {
                    prod=prod/nums[i];
                    i++;
                }
              
            ans=ans+(j-i+1);
            j++;
        }
        return ans;
    }
};