/**
 *  Author         : Jesse Zhou
 *  Date Completed : 10/19/2015
 *  Difficulty     : Medium
 *  Problem        : Sort an array with 0, 1, and 2 in one pass
 *  Strategy       : Have three markers, one at the end of the array and
 *                   one at the start of the array. Have a current marker
 *                   marking the current node being examined.
 *
 *                   If the current node is 0, switch with the start and
 *                   increment start and current by 1.
 *
 *                   If the current node is 1, increment current by 1.
 *
 *                   If the current node is 2, switch the end and decrement
 *                   end by 1 (do NOT touch increment).
 *
 *                   This strategy works in one pass. Essentially, you are
 *                   pushing all the 2's to the end and all of the 1's
 *                   to the front. You do not increment the current when
 *                   checking for 2 because you still need to deal with
 *                   whatever element was switched in from the back. It
 *                   doesn't matter when you switch in with a 0 because you
 *                   are dealing with an element you already dealt with
 *                   (0 or 1), and will likely get bubbled up anyway since
 *                   you switch the current with the back if it's a 0.
 *
 * 									 Hard to explain, but drawing it out usually works.
 *
 *  Time           : O(n), because you only go up to when current is less than
 *
 *  Dependencies   : None
 *  Notes          : Took me awhile with some help, but I ended up doing it my
 *                   own way
 */
public class SolutionOnePass {
    public void sortColors(int[] nums) {

        int red = 0;
        int white = 1;
        int blue = 2;

        int start = 0;
        int current = 0;
        int end = nums.length - 1;

        while(current < end + 1){

            System.out.println(Arrays.toString(nums));
            System.out.println("start: " + start + ", current: " + current + ", end: " + end);

            if(nums[current] == red){
                swap(nums, current++, start++);
            }
            else if(nums[current] == white){
                current++;
            }
            else if(nums[current] == blue){
                swap(nums, current, end--);
            }

        }

    }

    public void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a]  = nums[b];
        nums[b]  = temp;

    }
}
