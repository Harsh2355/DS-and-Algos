// Check if a linked list is storing a palindrome

// Example 
// abcdcba -> true
// horse -> false
// abccbd -> false

import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        Node head1 = new Node("a", new Node("b", new Node("c", new Node("d", new Node("c", new Node("b", new Node("a", null)))))));
        Node head2 = new Node("a", new Node("b", new Node("c", new Node("c", new Node("d", new Node("a", new Node("a", null)))))));
        System.out.println(isPalindrome(head1));
        System.out.println(isPalindrome(head2));
    }

    // Time: O(n)
    // Space: O(n)
    public static Boolean isPalindrome(Node head) {
        Node fast = head;
        Node slow = head;
        Stack<String> stack = new Stack<String>();
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            String val = stack.pop();
            if (!slow.data.equals(val)) {
                return false;
            }
            slow = slow.next;
        }

        return true;
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
    public String data;
    public Node next;

    public Node () {}

    public Node (String data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args) {

    }
}
