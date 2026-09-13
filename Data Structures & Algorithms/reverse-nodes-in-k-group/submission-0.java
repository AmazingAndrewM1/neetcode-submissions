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
    private boolean canReverse(ListNode curr, int k){
        int count = 0;
        while (curr != null && count < k){
            count++;
            curr = curr.next;
        }
        return count == k;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode tail = dummy;
        ListNode curr = head;
        while (canReverse(curr, k)){
            ListNode start = curr;
            ListNode prev = null;
            for (int i = 0; i < k; ++i){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            tail.next = prev;
            start.next = curr;
            tail = start;
        }

        return dummy.next;
    }
}
