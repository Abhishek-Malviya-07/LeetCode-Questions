class Solution {
public int[] getAverages(int[] nums, int k) {
int[] output = new int[nums.length];
if(nums.length<(k*2)+1){
Arrays.fill(output, -1);
return output;
}
int left =0;
int  right= nums.length-1;
int op = 0;
while(op<=k){
output[left] = -1;
output[right] = -1;
left++;
right--;
op++;
}
for(int i=k; i<=nums.length-k-1; i++){
int  avg =  averageOf(nums ,  k ,  i);
output[i] = avg;
}
return output;
}
public static int averageOf(int[] arr, int k, int index) {
int left = 0;
int right = k - 1;
int totalSum = arr[index];
while(left < k && right >= 0) {
int leftSum = arr[index - k + left];
int rightSum = arr[index + k - right];
right--;
left++;
totalSum += (leftSum + rightSum);
}
int avg = totalSum / (k * 2 + 1);
return avg;
}
​
}