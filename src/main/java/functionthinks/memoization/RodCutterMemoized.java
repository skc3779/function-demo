package functionthinks.memoization;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static functionthinks.memoization.Memoizer.callMemoized;

/**
 * Created by seokangchun on 2016. 10. 16..
 *
 */
public class RodCutterMemoized extends RodCutterBasic {

    public RodCutterMemoized(List<Integer> prices) {
        super(prices);
    }

    @Override
    public int maxProfit(final int rodLength) {
        BiFunction<Function<Integer, Integer>, Integer, Integer> compute =
                (func, length) -> {
                    int profit = (length <= prices.size()) ? prices.get(length - 1) : 0;
                    for(int i = 1; i < length; i++) {
                        int priceWhenCut = func.apply(i) + func.apply(length - i);
                        if(profit < priceWhenCut) profit = priceWhenCut;
                    }
                    return profit;
                };
        return callMemoized(compute, rodLength);
    }
}
