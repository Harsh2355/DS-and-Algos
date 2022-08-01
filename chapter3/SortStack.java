import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(6);
        stack.push(11);
        stack.push(2);
        stack.push(1);
        stack.push(8);
        System.out.println(sortStack(stack));
    }

    // Time: O(n^2)
    public static Stack sortStack(Stack stack) {
        Stack tempStack = new Stack();
        while (!stack.isEmpty()) {
            Integer curVal = (Integer) stack.pop();
            if (tempStack.isEmpty() || (int) curVal <= (int) tempStack.peek()) {
                tempStack.push(curVal);
            }
            else {
                Integer tempVal;
                do {
                    tempVal = (Integer) tempStack.pop();
                    stack.push(tempVal);
                    if (!tempStack.isEmpty()) tempVal = (Integer) tempStack.peek();
                    else break;
                } while ((int) tempVal < (int) curVal);
                tempStack.push(curVal);
            }
        }

        return tempStack;
    }
}
