package functionthinks.memoization;

import java.util.List;

/**
 * Created by seokangchun on 2016. 10. 16..
 */
public class RodCutterBasic {

    final List<Integer> prices;

    public RodCutterBasic(List<Integer> prices) {
        this.prices = prices;
    }

    public int maxProfit(final int length) {
        int profit = (length <= prices.size()) ? prices.get(length - 1) : 0;
        for(int i = 1; i < length; i++) {
            int priceWhenCut = maxProfit(i) + maxProfit(length - i);
            if(profit < priceWhenCut) profit = priceWhenCut;
        }

        return profit;
    }
}
