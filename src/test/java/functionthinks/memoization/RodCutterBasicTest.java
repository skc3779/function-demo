package functionthinks.memoization;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by seokangchun on 2016. 10. 16..
 */
public class RodCutterBasicTest {

    static
    final List<Integer> priceValues =
            Arrays.asList(2, 1, 1, 2, 2, 2, 1, 8, 9, 15);

    @Test
    public void memoized() {
        RodCutterMemoized rodCutterMemoized = new RodCutterMemoized(priceValues);
        System.out.println("// memoized test *******************************");
        System.out.println("best price of 5 meters : " + rodCutterMemoized.maxProfit(5) );
        System.out.println("best price of 10 meters : " + rodCutterMemoized.maxProfit(12) );
    }

    @Test
    public void basic() {
        RodCutterBasic rodCutterBasic = new RodCutterBasic(priceValues);
        System.out.println("// basic test *******************************");
        System.out.println("best price of 5 meters : " + rodCutterBasic.maxProfit(5) );
        System.out.println("best price of 10 meters : " + rodCutterBasic.maxProfit(12) );
    }
}