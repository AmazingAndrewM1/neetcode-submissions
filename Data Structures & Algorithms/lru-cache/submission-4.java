class LRUCache {
    private class Node{
        public Node prev;
        public Node next;
        public int key;
        public int value;

        public Node(int key, int value){
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> nodeMap;
    private Node head;
    private Node tail;
    private int size;
    private final int MAX_CAPACITY;

    public LRUCache(int capacity) {
        this.nodeMap = new HashMap<Integer, Node>();
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.MAX_CAPACITY = capacity;
    }
    
    public int get(int key) {
        int returnValue = -1;
        if (this.nodeMap.containsKey(key)){
            returnValue = this.nodeMap.get(key).value;
            remove(key);
            add(key, returnValue);
        }
        return returnValue;
    }
    
    public void put(int key, int value){
        if (nodeMap.containsKey(key)){
            remove(key);
            add(key, value);
        }
        else if (this.size == this.MAX_CAPACITY){
            remove(this.tail.key);
            add(key, value);
        }
        else{
            add(key, value);
        }
    }

    private void add(int key, int value){
        Node nodeToAdd = new Node(key, value);
        if (this.head == null){
            this.tail = nodeToAdd;
        }
        else{
            nodeToAdd.prev = this.head;
            this.head.next = nodeToAdd;
        }
        this.head = nodeToAdd;
        this.nodeMap.put(key, nodeToAdd);
        this.size++;
    }

    private void remove(int key){
        Node nodeToRemove = nodeMap.get(key);
        if (nodeToRemove == this.head && nodeToRemove == this.tail){
            this.head = null;
            this.tail = null;
        }
        else if (nodeToRemove == this.head){
            this.head = this.head.prev;
            this.head.next = null;
        }
        else if (nodeToRemove == this.tail){
            this.tail = this.tail.next;
            this.tail.prev = null;
        }
        else{
            nodeToRemove.next.prev = nodeToRemove.prev;
            nodeToRemove.prev.next = nodeToRemove.next;
        }
        this.nodeMap.remove(key);
        this.size--;
    }
}
