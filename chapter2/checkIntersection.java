import java.util.LinkedHashMap;
import java.util.Map;

// Write an algorithm that checks if two singly linked lists intersect by ref and return the node.

public class CheckIntersection {
    public static void main(String[] args) {
        Node common = new Node(6, new Node(7, null));
        Node head1 = new Node(0, new Node(3, new Node(5, new Node(4, new Node(1, common)))));
        Node head2 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, common))))));
        Node head3 = new Node(0, new Node(3, new Node(5, new Node(4, new Node(1, null)))));
        Node head4 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
        printLL(checkIntersectionInPlace(head1, head2));
        printLL(checkIntersectionInPlace(head3, head4));
    }

    // Time: O(n + m)
    // Space: O(n)
    public static Node checkIntersection(Node head1, Node head2) {
        Node current1 = head1;
        Node current2 = head2;

        Map<Node, Boolean> dict = new LinkedHashMap<Node, Boolean>();
        while (current1 != null) {
            dict.put(current1, true);
            current1 = current1.next;
        }

        while (current2 != null) {
            if (dict.containsKey(current2)) {
                return current2;
            }
            current2 = current2.next;
        }

        return null; 
    }

    // Time: O(n) if n > m else O(m)
    // Space: O(1)
    public static Node checkIntersectionInPlace(Node head1, Node head2) {
        Node current1 = head1;
        Node current2 = head2;
        int count1 = 0;
        int count2 = 0;
        while (current1 != null) {
            count1++;
            current1 = current1.next;
        }
        while (current2 != null) {
            count2++;
            current2 = current2.next;
        }
        
        Node p1 = head1;
        Node p2 = head2;
        int offset = 0;
        if (count2 >= count1) {
            while (p2 != null && p2 != p1) {
                if (offset >= count2 - count1) {
                    p1 = p1.next;
                }
                p2 = p2.next;
                offset++;
            }
            return p2;
        }

        while (p1 != null && p1 != p2) {
            if (offset >= count1 - count2) {
                p2 = p2.next;
            }
            p1 = p1.next;
            offset++;
        }
        return p1;
    }

    public static void printLL(Node head) {
        Node cur = head;
        if (cur == null) {
            System.out.println("NULL");
            return;
        }
        while (cur.next != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println(cur.data);
    }
}

public class Node {
    public int data;
    public Node next;

    public Node () {}
    public Node (int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args) {

    }
}
