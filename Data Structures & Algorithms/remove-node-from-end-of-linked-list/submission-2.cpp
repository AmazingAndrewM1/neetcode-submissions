/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int size = 0;
        for (ListNode* curr = head; curr != nullptr; curr = curr->next){
            size++;
        }
        if (size == n){
            ListNode* headNext = head->next;
            delete head;
            return headNext;
        }

        ListNode* curr = head;
        for (int i = n + 1; i < size; ++i){
            curr = curr->next;
        }
        ListNode* currNext2 = curr->next->next;
        delete curr->next;
        curr->next = currNext2;
        return head;
    }
};
