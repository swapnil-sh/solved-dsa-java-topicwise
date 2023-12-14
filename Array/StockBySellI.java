/*121. Best Time to Buy and Sell Stock - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/ */

class StockBySellI {
    public int maxProfit(int[] p) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<p.length; i++) {
            min = Math.min(p[i], min);
            res = Math.max(res, p[i]-min);
        }
        return res;
    }
}
