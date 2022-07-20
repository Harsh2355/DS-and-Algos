// Delete any node but the first and last;

// Example: 
// 7->5->6->8->4->2->6->5->3, 3 gives 6

public class Partition {
    public static void main(String[] args) {
        Node head1 = new Node(0, new Node(3, new Node(5, new Node(4, new Node(1, new Node(6, new Node(7, null)))))));
        Node head2 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, null)))))));
        Node head3 = new Node(2, new Node(7, new Node(1, new Node(4, new Node(6, new Node(5, new Node(0, null)))))));
        printLL(partition(head1, 5));
        printLL(partition(head2, 3));
        printLL(partition(head3, 0));
    }

    // Time: O(n)
    // Space: O(2n)
    public static Node partition(Node head, int value) {
        Node current = head;
        Node p1 = null;
        Node lessThanListHead = null;
        Node p2 = null;
        Node greaterThanListHead = null;
        while (current != null) {
            Node newnode = new Node();
            newnode.data = current.data;
            if (current.data < value) {
                if (lessThanListHead == null) {
                    lessThanListHead = newnode;
                    p1 = newnode;
                }
                else {
                    p1.next = newnode;
                    p1 = p1.next;
                }
            }
            else {
                if (greaterThanListHead == null) {
                    greaterThanListHead = newnode;
                    p2 = newnode;
                }
                else {
                    p2.next = newnode;
                    p2 = p2.next;
                }
            }
            current = current.next;
        }

        if (p1 == null) {
            return greaterThanListHead;
        }

        p1.next = greaterThanListHead;
        return lessThanListHead;
    }

    public static void printLL(Node head) {
        Node cur = head;
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
