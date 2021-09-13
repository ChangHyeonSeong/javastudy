package prob5;

public class MyStack {
    
	private String[] buffer;
	private int top;
	public MyStack() {
		this.buffer = null;
		this.top = 0;
	}
    public MyStack(int length) {	
        this.buffer = new String[length];
    	this.top = 0;
	}
    
	public void push(String string) {
		if(buffer.length == top) {
			String[] tempBuffer = new String[buffer.length+1];
			for (int i = 0; i < buffer.length ; i++) {
				tempBuffer[i] = new String(buffer[i]);
			}
			tempBuffer[buffer.length] = new String(string);
			buffer = tempBuffer;
			top++;
		}
		else {
			buffer[top] = new String(string);
			top++;
		}
	}
    
	public String pop() throws MyStackException{
		String str;
		if(isEmpty()) {
			throw new MyStackException("stack is empty");
		}
		else {
			str = buffer[top-1];
			top--;
		}
		return str;
	}
	
	
	public boolean isEmpty() {
		boolean empty = false;
		if(top == 0)
			empty = true;
		return empty;
	}

	
}