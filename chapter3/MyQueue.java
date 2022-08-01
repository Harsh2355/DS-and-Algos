// Implement a MyQueue class using two stacks

class MyQueue {
    
    Stack stackNewest, stackOldest;
	
	public MyQueue() {
		stackNewest = new Stack();
		stackOldest = new Stack();
	}
	
	public void push(int value) {
		stackNewest.push(value);
	}
	
	private void shiftStacks() {
		if (stackOldest.isEmpty()) { 
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public int peek() {
		shiftStacks();
		return (int) stackOldest.peek();                         
	}
	
	public int pop() {
		shiftStacks();
		return (int) stackOldest.pop();
	}
    
    public boolean empty() {
        return stackNewest.size() + stackOldest.size() == 0;
    }
}