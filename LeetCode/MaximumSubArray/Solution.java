//10/19/2015
//Took me like 30 minutes... too slow
public class Solution {

    //backtracking/greedy strategy

    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int total = 0;

        for(int i = 0; i < nums.length; i++){

            max = Math.max(max, total + nums[i]);
            total += nums[i];

            //reset
            if(total < 0){
                total = 0;
            }

        }

        return max;

    }
}
