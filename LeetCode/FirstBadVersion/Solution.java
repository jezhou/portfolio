/**
 *  Author         : Jesse Zhou
 *  Date Completed : 9/11/2015
 *  Problem        : Find the first bad version in "n" number of versions.
 *  								 You are supplied with a function isBadVersion(int n) that
 *  								 returns a boolean depending on if the version is bad or
 *  								 not. If a version is bad, every version after it is bad.
 *  Strategy       : "Binary Search" the whole algorithm, except keep going
 *  								 until there is no more middle. The two numbers left
 *  								 will either be (good, bad), or (bad, bad). Return [0] or
 *  								 [1] depending on what the circumstances are.
 *  Time           : O(log(n)), because how long this takes depends on how long
 *                   it takes to break the give number in half until it can't
 *                   be broken in half anymore. Binary Search is the algorithm
 *                   I am essentially implementing.
 *  Dependencies   : None
 *  Notes          : Problems encountered were integer overflow (this actually)
 *  								 was a problem for awhile). Be sure to check more edge cases
 *  								 in the future.
 */
public class Solution extends VersionControl {

    /**
     * Given method to fill out
     * @param  n Version to check
     * @return   The first bad version
     */
    public int firstBadVersion(int n) {

        // Get the starting places and the average of the two numbers
        int start = 1;
        int end = n;
        int mid = getMid(start, end);

        // If the start and the end are the same number, return it
        if(start == end)
            return start;

        // Break if the start and end are right next to each other
        while(start + 1 != end) {

            // Eliminate half depending on what the middle number is
            if(isBadVersion(mid)){
                end = mid;
            }
            else{
                start = mid;
            }

            // Recalculate
            mid = getMid(start, end);
        }

        // Return the start or end depending on what the number is
        int returnValue = isBadVersion(start) ? start : end;
        return returnValue;

    }

    /**
     * Returns the middle of start and end, without causing integer overflow.
     * @param   start The start number, in the distance to find middle of
     * @param   end   The end number, in the distance to find middle of
     * @return  {int} Representing the middle of start and end
     */
    public int getMid(int start, int end) {

        // Calculate the distance to the middle of start and end
        int distance = end - start;
        int midDistance = distance / 2;

        // Add the distance to the start
        return midDistance + start;

    }

}
