/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Node curr = head;
        while (curr != null){
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }

        Node list1 = head;
        while (list1 != null){
            Node list2 = list1.next;
            if (list1.random != null){
                list2.random = list1.random.next;
            }
            list1 = list2.next;
        }

        list1 = head;
        Node newHead = list1.next;
        while (list1.next.next != null){
            Node list2 = list1.next;
            list1.next = list2.next;
            list1 = list1.next;
            list2.next = list1.next;
        }
        list1.next.next = null;
        list1.next = null;
        
        return newHead;
    }
}
