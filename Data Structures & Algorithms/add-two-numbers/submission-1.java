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
    private ListNode addHelper(ListNode l1, ListNode l2, int carry){
        boolean isEnd = l1 == null && l2 == null;
        if (isEnd && carry == 0){
            return null;
        }
        if (isEnd && carry == 1){
            return new ListNode(1);
        }

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
            sum = sum - 10;
            carry = 1;
        }
        else{
            carry = 0;
        }
        ListNode node = new ListNode(sum);
        node.next = addHelper(l1, l2, carry);
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addHelper(l1, l2, 0);
    }
}
