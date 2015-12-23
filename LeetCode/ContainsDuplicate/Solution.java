import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> check = new HashSet<Integer>(nums.length);

        for(int n : nums){
            if(check.contains(n)){
                return true;
            }
            check.add(n);
        }

        return false;

    }
}
