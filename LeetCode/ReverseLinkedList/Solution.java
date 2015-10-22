/**
 *  Author         : Jesse Zhou
 *  Date Completed : 10/19/2015
 *  Difficulty     : Easy (Yeah right)
 *  Problem        : Reverse a linked list, returning the head of the reversed
 *  Strategy       : First, null out the "next" pointers by recursing down the
 *  								 LinkedList. Retrieve the last node and pass it up the
 *  								 stack as the recursion folds over. While the recursion
 *  								 is folding over, assign the next node from the current
 *  								 one (which was saved from earlier) to the current node,
 *  								 which thereby "reverses" the LinkedList.
 *  Time           : O(n) for recursing through the whole list, O(n) space
 *                   complexity for creating nodes.
 *  Dependencies   : None
 *  Notes          : This took me a long ass time to understand. Need to focus
 *                   on recursion more...
 */
public class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        //Get the next node
        ListNode next = head.next;

        // Null out the next
        head.next = null;

        //Do this for every node, this also fetches the end node
        ListNode last = reverseList(next);

        // Reassign the null nexts to the heads, (switch them around)
        next.next = head;


        // Return the last node
        return last;
    }

}
