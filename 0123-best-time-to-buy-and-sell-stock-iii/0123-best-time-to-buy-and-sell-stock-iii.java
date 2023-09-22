class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for(int  i : prices){
            buy1 = Math.max(buy1, -i);
            sell1 = Math.max(sell1 , buy1 + i);

            buy2 = Math.max(buy2, sell1 - i);
            sell2 = Math.max(sell2, buy2 + i);
        }
    return sell2;
    }
}