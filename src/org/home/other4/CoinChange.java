package org.home.other4;

// https://leetcode.com/problems/coin-change/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        final var cache = new int[amount + 1];

        for (int i = 1; i < cache.length; i++) {
            cache[i] = -1;

            for (int coin : coins) {
                if(i - coin < 0) {
                    break;
                }

                if (cache[i - coin] != -1)
                    cache[i] = cache[i] == -1 ?
                            1 + cache[i - coin] :
                            Math.min(cache[i], 1 + cache[i - coin]);
            }
        }

        return cache[amount];
    }

    public int coinChange(int[] coins, int amount, int[] cache) {
        if (cache[amount] != -2)
            return cache[amount];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (amount < coins[i]) {
                continue;
            }

            final var c = coinChange(coins, amount - coins[i], cache);

            if (c >= 0) {
                min = Math.min(min, c);
            }
        }

        return cache[amount] = (min == Integer.MAX_VALUE ? -1 : 1 + min);
    }

    // greedy doesn't work
    public int coinChange_g(int[] coins, int amount) {

        int current = amount;
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            final var c = coins[i];

            count += (current / c);
            current = current % c;
        }

        return current == 0 ? count : -1;
    }

    public static void main(String[] args) {
        final var solver = new CoinChange();

        System.out.println(" 4 = " + solver.coinChange(new int[]{2, 5, 10, 1}, 27));
        System.out.println(" -1 = " + solver.coinChange(new int[]{2}, 3));
        System.out.println(" 3 = " + solver.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(" 0 = " + solver.coinChange(new int[]{1}, 0));
    }
}
