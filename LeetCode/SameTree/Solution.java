/**
 *  Author         : Jesse Zhou
 *  Date Completed : 10/16/2015
 *  Difficulty     : Easy
 *  Problem        : Check if two trees are equivalent, given only their nodes.
 *                   Account for both structure and content.
 *  Strategy       : Do a simultaneous traversal of any kind, comparing each
 *                   nodes values along the way. If the roots at each call
 *                   are equal, and the left subtree and right subtree both
 *                   are equal, do a boolean AND and return whatever results
 *                   from that.
 *  Time           : O(n), with n being the number of nodes in each tree
 *  Dependencies   : None
 *  Notes          : Asked in Informatica interview 10/16/2015. Didn't do
 *                   very well, but figure this one out for myself later
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // First, check if both are null. Return true (since null == null)
        if(p == null && q == null) {
            return true;
        }

        // Now, check if either are null. If one is null here, this means one
        // value is null and the other is not. Inequality means return false.
        if(p == null || q == null){
            return false;
        }

        //left tree traversal
        boolean leftTree = isSameTree(p.left, q.left);

        //right tree traversal
        boolean rightTree = isSameTree(p.right, q.right);

        //check if the nodes values are equivalent. AND it
        //with the values from the left sub and right sub.
        //if there are any sort of false values, the and will
        //dominate the boolean function and return false.
        if(p.val == q.val){
            return true && leftTree && rightTree;
        }

        //return false for inequality
        return false;

    }
}
