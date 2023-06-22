class Solution {
    public int maxProfit(int[] prices) {
        int list_so_far = Integer.MAX_VALUE;
        int overall_profit = 0;
        int price_if_sold_today = 0;
        
        for(int i=0; i<prices.length; i++){
            if(prices[i] < list_so_far){
                list_so_far = prices[i];
 }
             price_if_sold_today = prices[i] - list_so_far;
            if(overall_profit <price_if_sold_today){
                overall_profit = price_if_sold_today;
            }
        }
        return overall_profit;
        
    }
}