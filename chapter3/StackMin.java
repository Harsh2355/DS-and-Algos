import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        StackMin stack = new StackMin();
        stack.push(19);
        stack.push(18);
        stack.push(29);
        stack.push(15);
        stack.push(16);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
    }
}

class StackMin {
    private ArrayList<Integer> stack =  new ArrayList<Integer>();
    private ArrayList<Integer> min = new ArrayList<Integer>();
    private int top = -1;

    public StackMin() {}
    public static void main(String[] args) {
        
    }

    // O(1)
    public void push(Integer value) {
        this.stack.add(value);
        if (top == -1) {
            this.min.add(value);
        }
        else {
            int minVal = this.min.get(this.top);
            if (value < minVal) {
                this.min.add(value);
            } else {
                this.min.add(minVal);
            }
        }
        this.top += 1;
    }
    
    // O(1)
    public int pop() {
        int deletedVal = this.stack.get(this.top);
        this.top -= 1;
        return deletedVal;
    }

    // O(1)
    public int getMin() {
        return this.min.get(this.top);
    }
}

