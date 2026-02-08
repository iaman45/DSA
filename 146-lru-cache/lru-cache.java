import java.util.*;
class LRUCache {

    class Node 
    {
        int key, value;
        Node next, prev;
        Node(int key,int value)
        {
            this.key=key;
            this.value=value;
        }
    }

    private HashMap<Integer,Node> map;
    private Node head, tail;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node n)
    {
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }

    public void add(Node n)
    {
        n.next = head.next;
        n.prev = head;
        head.next.prev=n;
        head.next = n;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node n = map.get(key);
        remove(n);
        add(n);
        return n.value;
    }
    
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            remove(n);
            add(n);
            return;
        }
        if(map.size() == capacity)
        {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        Node newNode = new Node(key, value);
        map.put(key,newNode);
        add(newNode);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */