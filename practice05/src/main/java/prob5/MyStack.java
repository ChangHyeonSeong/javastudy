package prob5;
/*
 * 성창현
 * 배열을 사용한 스택 구현
 * 210913
 * push() 에 버퍼배열 크기를 조절함 -> 함수는 한번에 한가지 일을해야하므로
 *                                                resize()함수를 만들어서 일을 나눈다
 * */
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
			for (int i = 0; i < tempBuffer.length ; i++) {
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
			
			String[] tempBuffer = new String[buffer.length-1];
			for (int i = 0; i < tempBuffer.length ; i++) {
				tempBuffer[i] = new String(buffer[i]);
			}
			buffer = tempBuffer;
			
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