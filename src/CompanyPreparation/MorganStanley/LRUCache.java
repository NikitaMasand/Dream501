package CompanyPreparation.MorganStanley;

import java.util.HashMap;
import java.util.Map;

//hashtable: fast lookup
//doubly linked list: fast removal
public class LRUCache {
    Map<Integer, ListNode> hashmap;
    int capacity;
    int numOfItems;
    ListNode head;
    ListNode tail;

    LRUCache(int capacity) {
        hashmap = new HashMap<>();
        this.capacity = capacity;
        numOfItems=0;
        head = new ListNode();
        tail = new ListNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = hashmap.getOrDefault(key, null);
        if(node!=null){
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        ListNode node = hashmap.getOrDefault(key, null);
        //node not present
        if(node==null) {
            node = new ListNode();
            node.key = key;
            node.value = value;
            node.next = null;
            node.prev = null;
            hashmap.put(key, node);
            addToHead(node);
            numOfItems++;

            if (numOfItems>capacity){
                removeLRUEntry();
                numOfItems--;
            }

        }
        //node already present
        else {
            node.value=value;
            hashmap.remove(key, node);
            moveToHead(node);
        }
    }

    public void moveToHead(ListNode node) {
        removeFromList(node);
        addToHead(node);
    }

    public void removeFromList(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public void addToHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeLRUEntry(){
        ListNode tail = popTail();
        hashmap.remove(tail.key);
    }

    public ListNode popTail(){
        ListNode tailNode = tail.prev;
        removeFromList(tailNode);
        return tailNode;
    }
}

class ListNode {
    int key;
    int value;

    ListNode prev;
    ListNode next;

}