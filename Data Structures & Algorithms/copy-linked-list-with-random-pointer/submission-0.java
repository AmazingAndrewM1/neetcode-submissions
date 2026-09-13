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

        Map<Node, Integer> nodeMap = new HashMap<Node, Integer>();
        List<Node> nodeList = new ArrayList<Node>();
        Node curr = head;
        for (int i = 0; curr != null; ++i){
            nodeList.add(new Node(curr.val));
            nodeMap.put(curr, i);
            curr = curr.next;
        }

        curr = head;
        Node prev = new Node(0);
        for (Node node: nodeList){
            node.next = null;
            prev.next = node;
            prev = node;
            if (curr.random == null){
                node.random = null;
            }
            else{
                int index = nodeMap.get(curr.random).intValue();
                node.random = nodeList.get(index);
            }
            curr = curr.next;
        }
        return nodeList.get(0);
    }
}
