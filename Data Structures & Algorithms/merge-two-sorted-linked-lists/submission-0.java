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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        ListNode prev = curr;
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while (curr1 != null && curr2 != null){
            if (curr1.val < curr2.val){
                curr.val = curr1.val;
                curr1 = curr1.next;
            }
            else{
                curr.val = curr2.val;
                curr2 = curr2.next;
            }
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
        }
        while (curr1 != null){
            curr.val = curr1.val;
            curr1 = curr1.next;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
        }
        while (curr2 != null){
            curr.val = curr2.val;
            curr2 = curr2.next;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
        }
        if (head == curr){
            head = null;
        }
        else{
            prev.next = null;
        }
        return head;
    }
}