// 10/19/2015
// Couldn't figure it out, add and check the past as you go using a hashmap
public class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> check = new HashMap<Integer, Integer>(nums.length);
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(check.containsKey(target - nums[i])){
                int index = check.get(target - nums[i]) + 1;
                res[0] = Math.min(i + 1, index);
                res[1] = Math.max(i + 1, index);
            }

            check.put(nums[i], i);
        }

        return res;

    }
}
