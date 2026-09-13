/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode curr = head;
        while (curr != null){
            stack.addFirst(curr);
            curr = curr.next;
        }

        curr = head;
        ListNode removedNode = null;
        while (curr != stack.peekFirst() && curr != removedNode){
            removedNode = stack.removeFirst();
            removedNode.next = curr.next;
            curr.next = removedNode;
            curr = removedNode.next;
        }
        curr.next = null;
    }
}
