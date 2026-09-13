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
        ListNode prevSlow = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode slowNext = slow.next;
            slow.next = prevSlow;
            prevSlow = slow;
            slow = slowNext;
        }

        ListNode curr1 = prevSlow;
        ListNode curr2 = slow;
        ListNode curr1Prev = null;
        if (fast != null){
            curr2 = slow.next;
            slow.next = null;
            curr1Prev = slow;
        }
        while (curr2 != null){
            ListNode curr1Next = curr1.next;
            ListNode curr2Next = curr2.next;
            curr2.next = curr1Prev;
            curr1.next = curr2;
            curr1Prev = curr1;
            curr1 = curr1Next;
            curr2 = curr2Next;
        }
    }
}
