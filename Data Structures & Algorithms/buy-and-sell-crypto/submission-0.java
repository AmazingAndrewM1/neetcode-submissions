class Solution {
    public int maxProfit(int[] prices) {
        int indexBuy = 0;
        int indexSell = 0;
        int maxProfit = 0;

        while (indexBuy < prices.length - 1){
            while (indexBuy < prices.length - 1 && prices[indexBuy + 1] <= prices[indexBuy]){
                ++indexBuy;
            }

            if (indexBuy >= indexSell){
                indexSell = indexBuy + 1;
                for (int i = indexBuy + 2; i < prices.length; ++i){
                    if (prices[i] >= prices[indexSell]){
                        indexSell = i;
                    }
                }
            }

            if (indexSell < prices.length && prices[indexSell] - prices[indexBuy] > maxProfit){
                maxProfit = prices[indexSell] - prices[indexBuy];
            }

            ++indexBuy;
        }

        return maxProfit;
    }
}
