package org.home.other4;

public class TradingP4 {
    public int maxProfit(int[] prices) {
        var max = 0;

        for (int i = 0; i < prices.length; i++) {
            max += Math.max(0, prices[i + 1] - prices[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        final var solver = new TradingP4();

        System.out.println("3 = " + solver.maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println("0 = " + solver.maxProfit(new int[]{1}));
    }
}
