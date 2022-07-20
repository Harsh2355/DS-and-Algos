// Delete any node but the first and last;

// Example: 
// 7->5->6->8->4->2->6->5->3, 3 gives 6

public class DeleteMiddleNode {
    public static void main(String[] args) {
        Node target1 = new Node(3, new Node(5, new Node(4, new Node(7, new Node(7, new Node(7, null))))));
        Node head1 = new Node(5, target1);
        Node target2 = new Node(7, new Node(7, null));
        Node head2 = new Node(2, new Node(2, new Node(5, new Node(5, new Node(7, target2)))));
        Node target3 =  new Node(4, new Node(7, new Node(9, new Node(0, null))));
        Node head3 = new Node(5, new Node(3, new Node(6, target3)));
        printLL(deleteMiddle(head1, target1));
        printLL(deleteMiddle(head2, target2));
        printLL(deleteMiddle(head3, target3));
    }

    // O(n)
    public static Node deleteMiddle(Node head, Node target) {
        Node current = head;
        while (current != null) {
            if (current.next == target) {
                current.next = current.next.next;
            }
            current = current.next;
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
}

public class Node {
    public int data;
    public Node next;

    public Node (int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args) {

    }
}
