/**
 *  Author         : Jesse Zhou
 *  Date Completed : 9/25/2015
 *  Difficulty     : Easy
 *  Problem        : Given an array nums, write a function to move all 0's to
 *  								 the end of it while maintaining the relative order of the
 *  								 non-zero elements.For example, given nums =
 *  								 [0, 1, 0, 3, 12], after calling your function, nums should
 *  								 be [1, 3, 12, 0, 0].
 *
 * 									 Do this in place, and minimize the amount of operations.
 *  Strategy       : There are two parts to this solution. Essentially, both
 *  								 parts rely on at iterating through the input array once.
 *  								 The idea is to count the number of zeroes and shift a
 *  								 certain element left depending on how many zeroes there are
 *  								 at any given time while iterating the array. Then,
 *  								 appending the number of zeroes at the end should give
 *  								 the right answer. Look at the comments if confused.
 *  Time           : O(n), because the first loop must travel through the entire
 *  								 input nums array at least once to count how many zeroes
 *  								 there are.
 *  Dependencies   : None
 *  Notes          : I had an extra for loop in it before, but that's just
 *  								 going to make the time potentially polynomial. I feel like
 *  								 my approach is more or less the best way to do this.
 */
public class Solution {
    public void moveZeroes(int[] nums) {

        int zeroes = 0; // Holds the number of zeros in the nums array.
                        // Also conveninetly the "shift" factor.

        // Count how many zeros there are, and shift accordingly
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) {
              zeroes++; 
            }
            else if(i - zeroes > -1){
                nums[i - zeroes] = nums[i]; // Shift the element to the left,
                                            // to make up the displaced 0's
            }
        }

        //Append the number of zeros at the very end of the array
        for(int i = 0; i < zeroes; i++){
            nums[nums.length - 1 - i] = 0;
        }

    }
}
