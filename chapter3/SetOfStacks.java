import java.util.ArrayList;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        SetOfStacks stack = new SetOfStacks();
        stack.push(19);
        stack.push(18);
        stack.push(29);
        stack.push(15);
        stack.push(16);
        stack.push(19);
        stack.push(18);
        stack.push(29);
        stack.push(15);
        stack.push(16);
        stack.push(19);
        stack.push(18);
        stack.push(29);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class SetOfStacks {

    public static int limit = 5;

    private ArrayList<Stack> stackList =  new ArrayList<Stack>();
    private int top = -1;
    private int currentLoad = 0;

    public SetOfStacks() {}
    public static void main(String[] args) {
        
    }

    // O(1)
    public void push(Integer value) {
        if (this.top == -1) {
            Stack stack = new Stack();
            stack.push(value);
            stackList.add(stack);
            this.top += 1;
            this.currentLoad += 1;
            return;
        } 
        else if (this.currentLoad == limit) {
            Stack stack = new Stack();
            stack.push(value);
            stackList.add(stack);
            this.top += 1;
            this.currentLoad = 1;
            return;
        }
        else {
            stackList.get(this.top).add(value);
            this.currentLoad += 1;
            return;
        }
    }
    
    // O(1)
    public Integer pop() {
        Integer deletedVal = (Integer) this.stackList.get(this.top).pop();
        this.currentLoad -= 1;
        if (this.currentLoad == 0) {
            this.top -= 1;
            this.currentLoad = limit;
        }
        return deletedVal;
    }
}

