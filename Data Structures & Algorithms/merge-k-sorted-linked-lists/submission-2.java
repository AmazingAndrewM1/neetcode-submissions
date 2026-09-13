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
    private ListNode merge(ListNode curr1, ListNode curr2){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (curr1 != null && curr2 != null){
            if (curr1.val < curr2.val){
                curr.next = curr1;
                curr1 = curr1.next;
            }
            else{
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        if (curr1 == null){
            curr.next = curr2;
        }
        else{
            curr.next = curr1;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }

        ListNode[] mergedLists = lists;
        while (mergedLists.length > 1){
            ListNode[] newMergedLists = new ListNode[mergedLists.length / 2 + mergedLists.length % 2];
            int j = 0;
            for (int i = 0; i < mergedLists.length - 1; i += 2){
                newMergedLists[j] = merge(mergedLists[i], mergedLists[i + 1]);
                ++j;
            }
            if (j != newMergedLists.length){
                newMergedLists[newMergedLists.length - 1] = mergedLists[mergedLists.length - 1];
            }
            mergedLists = newMergedLists;
        }
        return mergedLists[0];
    }
}
