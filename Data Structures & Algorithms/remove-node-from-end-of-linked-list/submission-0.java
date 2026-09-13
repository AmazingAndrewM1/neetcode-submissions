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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        for (int i = 0; i < n; ++i){
            front = front.next;
        }

        ListNode prev = null;
        ListNode curr = head;
        while (front != null){
            front = front.next;
            prev = curr;
            curr = curr.next;
        }
        if (prev == null){
            head = head.next;
        }
        else{
            prev.next = curr.next;
        }
        return head;
    }
}
