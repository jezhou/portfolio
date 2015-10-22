/**
 *  Author         : Jesse Zhou
 *  Date Completed : 10/17/2015
 *  Difficulty     : Medium
 *  Problem        : Given an array of integers, every element appears twice
 *                   except for one. Find that single one.
 *  Strategy       : Takes advantage of the fact that any number x XOR y is 0.
 *                   If you XOR everything back to back in the array, the
 *                   number whose bits that were left behind is the number
 *                   we want.
 *  Time           : O(n), because we have to XOR every damn number
 *  Dependencies   : None
 *  Notes          : Had to look at the solution for this one. I used a
 *                   hashmap first but this was fucking elegant.
 */
public class Solution {
    public int singleNumber(int[] nums) {

        int x = 0;
        for(int n : nums)
            x ^= n;

        return x;
    }
}
