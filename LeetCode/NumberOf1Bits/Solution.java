//10/19/2015
// Note: >> != >>>. Former copies sign bit, latter always uses 0
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0){
            count += n & 1;
            n = n >>> 1;
        }

        return count;

    }
}
