/**
 *  Author         : Jesse Zhou
 *  Date Completed : 10/13/2015
 *  Difficulty     : Easy
 *  Problem        : Add two numbers without using + or -
 *  Strategy       : Use bitwise operators and recursion to simulate carrys and
 *  								 adding by hand.
 *  Time           : O(n) (I think), n being the number of bits because you
 *                   might have to carry over the bit n times
 *  Dependencies   : None
 *  Notes          : Couldn't figure it out because I was doing it in Ruby.
 *                   I think for future reference, if you're trying to do
 *                   something with bits, use a language that's more suited for
 *                   it besides Ruby. I'll keep trying for a Ruby answer online.
 */

public class Solution {
    public int getSum(int a, int b) {
        if(b == 0) { return a; }
        int carry = (a & b) << 1;
        int sum = a ^ b;
        return getSum(sum, carry);
    }
}
