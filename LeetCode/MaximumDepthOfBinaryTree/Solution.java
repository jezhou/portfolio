/**
 *  Author         : Jesse Zhou
 *  Date Completed : 10/18/2015
 *  Difficulty     : Easy
 *  Problem        : Find the max depth of a binary treee.
 *  Strategy       : Use recursion and return whichever one is greater
 *  Time           : O(n), since you need to check every node at every level in
 *                   the worst case
 *  Dependencies   : None
 *  Notes          : Had to think about this one for a little.
 */
public class Solution {
    public int maxDepth(TreeNode root) {

        int count = 0;
        if(root == null){
            return count;
        }

        // Recursive call left and right
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        // Return whichever height is higher
        int returnVal = left > right ? left : right;

        return returnVal;

    }
}
