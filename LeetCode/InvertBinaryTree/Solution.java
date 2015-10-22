/**
 *  Author         : Jesse Zhou
 *  Date Completed : 10/18/2015
 *  Difficulty     : Easy
 *  Problem        : Invert a binary tree.
 *  Strategy       : Essentially just switch the nodes, but recursively. drawing
 *                   it out helps.
 *  Time           : O(n), since you have to visit every node of the tree.
 *  Dependencies   : None
 *  Notes          : Had to look at the solution :/ Keep in mind that you should
 *                   start with a base case and build. That was probably a good
 *                   way to approach this problem (vs starting with a 7 node
 *                   tree)
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {

        if(root != null) {
            TreeNode left = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(left);
        }

        return root;
    }

}
