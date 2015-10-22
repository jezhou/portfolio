/**
 *  Author         : Jesse Zhou
 *  Date Completed : 10/19/2015
 *  Difficulty     : Medium (Easy with this strategy)
 *  Problem        : See one pass file
 *  Strategy       : Count how many 0's, 1's, and 2's there are, and replace
 *                   accordingly in the array.
 *  Time           : O(2n), or O(n), because of two iterations through the
 *                   nums array
 *  Dependencies   : None
 *  Notes          : Didn't solve by myself, had to look at the hint.
 */
public class SolutionTwoPass {
    public void sortColors(int[] nums) {

        int red, white, blue;
        red = white = blue = 0;

        for(int n : nums){
            switch(n){
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;

            }
        }

        for(int i = 0; i < nums.length; i++){
            if(red > 0){
                nums[i] = 0;
                red--;
            }
            else if(white > 0){
                nums[i] = 1;
                white--;
            }
            else{
                nums[i] = 2;
                blue--;
            }
        }

    }
}
