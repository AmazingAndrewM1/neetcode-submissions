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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        int carry = 0;
        while (l1 != null || l2 != null){
            int sum = carry;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum >= 10){
                carry = 1;
                sum = sum - 10;
            }
            else{
                carry = 0;
            }
            ListNode temp = new ListNode(sum);
            prev.next = temp;
            prev = temp;
        }
        if (carry == 1){
            prev.next = new ListNode(1);
        }

        return dummy.next;
    }
}
