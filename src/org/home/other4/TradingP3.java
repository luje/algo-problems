package org.home.other4;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class TradingP3 {

    public int maxProfit(int[] prices, int fee) {
        final var cache = new int[2][prices.length + 1];

        Arrays.fill(cache[0], -1);
        Arrays.fill(cache[1], -1);

        return maxProfit(prices, fee, 0, 0, cache);
    }

    public int maxProfit(int[] prices, int fee, int k, int own, int[][] cache) {
        if (k == prices.length) {
            return 0;
        }

        if (cache[own][k] >= 0) {
            return cache[own][k];
        }

        if (own == 0) {
            cache[own][k] = Math.max(
                    - prices[k] + maxProfit(prices, fee, k + 1, 1, cache), // buy
                    maxProfit(prices, fee, k + 1, 0, cache) // no own
            );
        } else {
            cache[own][k] = Math.max(
                    maxProfit(prices, fee, k + 1, 1, cache), // keep
                    (prices[k] - fee) + maxProfit(prices, fee, k + 1, 0, cache) // sell
            );
        }

        return cache[own][k];
    }

    public int maxProfit2(int[] prices, int fee) {
        int cOwn = 0;
        int cNoOwn = Integer.MIN_VALUE;

        for (int k = prices.length - 1; k >= 0; k--) {
            var cNoOwnOld = cNoOwn;

            cNoOwn = Math.max(
                    + prices[k] + cOwn, // buy
                    cNoOwn // no own
            );

            cOwn = Math.max(
                    cOwn, // buy
                    cNoOwn - (prices[k] + fee) // no own
            );
        }

        return cOwn;
    }


    public static void main(String[] args) {
        final TradingP3 solver = new TradingP3();

        System.out.println("8 = " + solver.maxProfit2(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println("6 = " + solver.maxProfit2(new int[]{1, 3, 7, 5, 10, 3}, 3));
        System.out.println("4 = " + solver.maxProfit2(new int[]{4, 5, 2, 4, 3, 3, 1, 2, 5, 4}, 1));
        System.out.println("4 = " + solver.maxProfit2(new int[]{2, 1, 4, 4, 2, 3, 2, 5, 1, 2}, 1));
    }
}
