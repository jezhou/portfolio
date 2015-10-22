/**
 *  Author         : Jesse Zhou
 *  Date Completed : 10/18/2015
 *  Difficulty     : Medium
 *  Problem        : Say you have an array for which the ith element is the
 *                   price of a given stock on day i.
 *                   Design an algorithm to find the maximum profit. You may
 *                   complete as many transactions as you like (ie, buy one and
 *                   sell one share of the stock multiple times). However, you
 *                   may not engage in multiple transactions at the same time
 *                   (ie, you must sell the stock before you buy again).
 *  Strategy       : Same as BTTBASS I, except you keep adding to the profit
 *                   whenever you make any kind of profit. This is a greedy
 *                   kind of algorithm (looking at the next best possible
 *                   local maximization, which usually results in the global
 *                   maximization).
 *  Time           : O(n), since it uses backtracking to iterate through the
 *                   array once
 *  Dependencies   : None
 *  Notes          : Had to look at BTTBASS I.
 */
public class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length == 0){
            return 0;
        }

        int minValue = prices[0];
        int profit = 0;

        for(int i = 0; i < prices.length; i++){

            int difference = prices[i] - minValue;

            if(difference > 0){
                profit += difference;
                minValue = prices[i];
            }

            minValue = Math.min(minValue, prices[i]);
        }

        return profit;

    }
}
