class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int i = 0;
        int j = costs.length-1;
        long costSum = 0;
        
        PriorityQueue<Integer> leftPq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> rightPq = new PriorityQueue<Integer>();
        
        while(k>0){
            
            while(leftPq.size() < candidates && i<=j){

                leftPq.offer(costs[i]);
                i++;
            }
        
            while(rightPq.size() < candidates && i<=j){

                rightPq.offer(costs[j]);
                j--;
            }
           
        
           int a = leftPq.size()>0?leftPq.peek() : Integer.MAX_VALUE;
           int b = rightPq.size()>0?rightPq.peek(): Integer.MAX_VALUE;
        
           if(a<=b){
               costSum += a;
               leftPq.poll();
           }else{

              costSum += b;
              rightPq.poll();
           }
            
            
           k--; 
        
        }
       return costSum;  
    }
}