// Write code to remove duplicates from unsorted Linked List

// Example:
// 7->2->7->3->4->3->4->9->9 becomes 7->2->3->4->9

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Node head1 = new Node(5, new Node(3, new Node(5, new Node(4, new Node(7, new Node(7, new Node(7, null)))))));
        Node head2 = new Node(2, new Node(2, new Node(5, new Node(5, new Node(7, new Node(7, new Node(7, null)))))));
        Node head3 = new Node(5, new Node(3, new Node(6, new Node(4, new Node(7, new Node(9, new Node(0, null)))))));
        Node head4 = new Node(5, new Node(4, new Node(5, new Node(4, new Node(5, new Node(7, new Node(7, null)))))));
        printLL(removeDups(head1));
        printLL(removeDups(head2));
        printLL(removeDups(head3));
        printLL(removeDups(head4));
    }

    // Time: O(n)
    public static Node removeDups(Node head) {
        Map<Integer, Boolean> duplicates = new HashMap<Integer, Boolean>();
        Node cur = head;
        duplicates.put(cur.data, true);
        while (cur.next != null) {
            if (duplicates.containsKey(cur.next.data)) {
                cur.next = cur.next.next;
            }
            else {
                duplicates.put(cur.next.data, true);
                cur = cur.next;
            }
        }
        return head;
    }

    public static void printLL(Node head) {
        Node cur = head;
        while (cur.next != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println(cur.data);
    }
};

public class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args) {
    
    }
};
