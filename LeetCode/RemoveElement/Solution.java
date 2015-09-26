/**
 *  Author         : Jesse Zhou
 *  Date Completed : 9/25/2015
 *  Difficulty     : Easy
 *  Problem        : Given an array and a value, remove all instances of that
 *  								 value in place and return the new length. The order of
 *  								 elements can be changed. It doesn't matter what you leave
 *  								 beyond the new length.
 *  Strategy       : Same Strategy as the one used in MoveZeroes, except I don't
 *  								 need to append the zeroes at the end.
 *  Time           : O(n), see MoveZeroes
 *  Dependencies   : None
 *  Notes          : I literally used the same solution that I used for
 *                   MoveZeroes
 */
public class Solution {
    public int removeElement(int[] nums, int val) {

        int found = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val) {
                found++;
            }
            else if(i - found > -1){
                nums[i - found] = nums[i];
            }
        }

        return nums.length - found;

    }
}
