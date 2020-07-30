package CompanyPreparation.MorganStanley;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node{
    int val;
    Node next;
    Node(int x){
        val=x;
    }
}
public class MergeKSortedLists {
        public Node mergeKLists(Node[] lists) {
            int k = lists.length;
            PriorityQueue<Node> minHeap = new PriorityQueue<>(k, new Comparator<Node>(){
                @Override
                public int compare(Node n1, Node n2){
                    return n1.val-n2.val;
                }
            });
            for(int i=0;i<k;i++){
                minHeap.add(lists[i]);
            }

            Node temp = new Node(-1);
            Node head = temp;

            while (!minHeap.isEmpty()){
                Node n = minHeap.poll();
                minHeap.add(n.next);
                temp.next = new Node(n.val);
                temp = temp.next;

            }
            return head.next;
        }
}
