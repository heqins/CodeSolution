/**
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
**/

class Node {
    int key;
    int val;
    Node next;
    Node prev;
    
    Node (int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    
    DoublyLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void remove(Node n) {
        if (n != null && n.prev != null && n.next != null) {
            Node prev = n.prev;
            prev.next = n.next;
            prev.next.prev = prev;
        }
    }
    
    public Node getLastNode() {
        if (head == tail) return null;
        
        return tail.prev;
    }
    
    public void addFirst(Node n) {
        head.next.prev = n;
        n.next = head.next;
        n.prev = head;
        head.next = n;
    }
    
    public Node getFirstNode() {
        if (head == tail) return null;
        
        return head.next;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    DoublyLinkedList dl;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        dl = new DoublyLinkedList();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Node n = map.get(key);
        if (dl.getFirstNode() != null) {
            dl.remove(n);
            dl.addFirst(n);
        }
        
        return n.val;
    }
    
    public void put(int key, int value) {
        remove(key);

        if (map.size() == capacity) remove(dl.getLastNode().key);

        Node newNode = new Node(key, value);
        dl.addFirst(newNode);
        map.put(key, newNode);
    }
    
    public void remove(int key) {
        Node n = map.get(key);
        dl.remove(n);
        map.remove(key);
    }
}
