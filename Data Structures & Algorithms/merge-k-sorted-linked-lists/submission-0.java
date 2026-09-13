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
    private ListNode headMerged = null;
    private ListNode currMerged = headMerged;
    private ListNode prevMerged = null;

    private void add(ListNode nodeToAdd){
        if (headMerged == null){
            headMerged = nodeToAdd;
        }
        else if (prevMerged == null){
            nodeToAdd.next = currMerged;
            prevMerged = nodeToAdd;
            headMerged = nodeToAdd;
        }
        else if (currMerged == null){
            prevMerged.next = nodeToAdd;
            prevMerged = nodeToAdd;
        }
        else{
            prevMerged.next = nodeToAdd;
            prevMerged = nodeToAdd;
            nodeToAdd.next = currMerged;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        for (int i = 0; i < lists.length; ++i){
            prevMerged = null;
            currMerged = headMerged;
            ListNode currList = lists[i];

            while (currMerged != null && currList != null){
                if (currList.val < currMerged.val){
                    ListNode next = currList.next;
                    add(currList);
                    currList = next;
                }
                else{
                    prevMerged = currMerged;
                    currMerged = currMerged.next;
                }
            }
            if (currMerged == null){
                add(currList);
            }
        }
        return headMerged;
    }
}
