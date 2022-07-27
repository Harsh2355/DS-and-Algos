import java.util.LinkedHashMap;
import java.util.Map;

// Detect if a linked list is circular


public class LoopDetection {
    public static void main(String[] args) {
        
    }

    // Time: O(n)
    // Space: O(n)
    public static Node detectLoop(Node head) {
        Node current = head;
        Map<Node, Boolean> nodeStore = new LinkedHashMap<Node, Boolean>();
        while (current != null) {
            if (nodeStore.containsKey(current)) {
                return current;
            }
            nodeStore.put(current, true);
            current = current.next;
        }
        return null;
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
