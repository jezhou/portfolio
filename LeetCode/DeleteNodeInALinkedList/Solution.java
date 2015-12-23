//solved 10/19/2015
public class Solution {
    public void deleteNode(ListNode node) {

        if(node == null || node.next == null) return;

        // Copy next value into this node
        node.val = node.next.val;

        //"Delete" the node you just copied from
        node.next = node.next.next;

    }
}
