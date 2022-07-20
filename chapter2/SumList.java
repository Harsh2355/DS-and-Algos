// 

// Example: 
// 7->5->6->8->4->2->6->5->3, 3 gives 6

import java.lang.Math;

public class SumList {
    public static void main(String[] args) {
        Node head1 = new Node(6, new Node(7, new Node(1, null)));
        Node head3 = new Node(3, new Node(2, new Node(1, null)));
        Node head2 = new Node(6, new Node(7, null));
        Node head4 = new Node(6, new Node(7, null));
        Node head5 = new Node(6, new Node(7, null));
        Node head6 = new Node(0, new Node(0, new Node(1, null)));
        System.out.println(getSum(head1, head3));
        System.out.println(getSum(head2, head4));       
        System.out.println(getSum(head5, head6));      
        System.out.println(getSumReverse(head1, head3));
        System.out.println(getSumReverse(head2, head4));       
        System.out.println(getSumReverse(head5, head6));  
    }

    // Example:
    // 671 + 321 = 299

    // Time: O(n)
    // Space: O(2n)
    public static int getSum(Node head1, Node head2) {
        Node cur1 = head1;
        Node cur2 = head2;
        int multiplier = 1;
        int sum = 0;
        while (!(cur1 == null && cur2 == null)) {
            int dig1 = 0;
            int dig2 = 0;
            if (cur1 != null) {
                dig1 = cur1.data;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                dig2 = cur2.data;
                cur2 = cur2.next;
            }
            sum += dig1 * multiplier + dig2 * multiplier;
            multiplier *= 10;
        }

        return sum;
    }

    public static int getSumReverse(Node head1, Node head2) {
        Node cur1 = head1;
        int count1 = 0;
        Node cur2 = head2;
        int count2 = 0;
        // int multiplier = 1;
        int sum = 0;
        while (cur1 != null) {
            count1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            count2++;
            cur2 = cur2.next;
        }
        Node newcur1 = head1;
        Node newcur2 = head2;
        while (newcur1 != null) {
            sum += newcur1.data * Math.pow(10, count1 - 1);
            newcur1 = newcur1.next;
            count1--;
        }
        while (newcur2 != null) {
            sum += newcur2.data * Math.pow(10, count2 - 1);
            newcur2 = newcur2.next;
            count2--;
        }
        return sum;
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
