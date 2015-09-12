/**
 *  Author         : Jesse Zhou
 *  Date Completed : 9/11/2015
 *  Problem        : Given a non-negative integer num, repeatedly add all its
 *  								 digits until the result has only one digit.
 *  Strategy       : Add all the digits together, then call the function on
 *  								 itself recursive if the result is not a single digit.
 *  Time           : O(n) essentially (?). Here is my reasoning: Take a number,
 *  								 max it out so all the digits are 9 (largest single digit)
 *  								 number. Even if you made this number a googol (one,
 *  								 followed by 100 zeros) but all 9's instead, it would be
 *  								 9 * 101, which is now a mere three digits long. TL;DR, the
 *  								 recursion you do at the end is negligent, so the time
 *  								 really is just a function of how long the original number
 *  								 is.
 *  Dependencies   : None
 *  Notes          : This is the linear solution. Uses recursion.
 */
public class LinearSolution {
    public int addDigits(int num) {

        // If the number is less than 0, end the function.
        if(num < 0)
            return 0;

        // If the number is a single digit, return it immediately.
        if(num < 10)
            return num;

        int sum = 0;

        // Iteratively add each digit at a time until there are no more
        // digits to add
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }

        // Call the same function on the new number, if it has more than a
        // single digit.
        return addDigits(sum);

    }
}
