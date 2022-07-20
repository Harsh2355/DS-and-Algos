// implement an algorithm that returns the kth to last element of a singly Linked list

// Example: 
// 7->5->6->8->4->2->6->5->3, 3 gives 6

public class KthElement {
    public static void main(String[] args) {
        Node head1 = new Node(5, new Node(3, new Node(5, new Node(4, new Node(7, new Node(7, new Node(7, null)))))));
        Node head2 = new Node(2, new Node(2, new Node(5, new Node(5, new Node(7, new Node(7, new Node(7, null)))))));
        Node head3 = new Node(5, new Node(3, new Node(6, new Node(4, new Node(7, new Node(9, new Node(0, null)))))));
        Node head4 = new Node(5, new Node(4, new Node(5, new Node(4, new Node(5, new Node(7, new Node(7, null)))))));
        System.out.println(returnKthToLast(head1, 4));
        System.out.println(returnKthToLast(head2, 1));
        System.out.println(returnKthToLast(head3, 7));
        System.out.println(returnKthToLast(head4, 3));
    }

    // O(n)
    public static int returnKthToLast(Node node, int k) {
        Node runner = node;
        Node current = node;
        for (int i = 0; i < k; ++i) {
            runner = runner.next;
        }
        while (runner != null) {
            current = current.next;
            runner = runner.next;
        }
        return current.data;
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
