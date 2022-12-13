package datastructure_java.datastructure.stack;

public class ArrayStack {

	//배열을 이용한 스택 
	private int [] stack;
	private int topIndex;
	
	public ArrayStack(int size) {
		
		this.stack = new int[size];
		this.topIndex = -1;
	}
	
	public boolean isEmpty() {
		
		return (this.topIndex == -1)? true : false;
	}
	
	public void push(int data) {
		
		if(this.topIndex+1 == this.stack.length) {
			System.out.println("스택이 가득 찼습니다.");
			return;
		}
		
		this.stack[++this.topIndex] = data;
		
	}
	
	public int pop() {
		
		if(this.isEmpty()) {
			System.out.println("스택이 비었습니다.");
			return -1;
		}
		
		return this.stack[this.topIndex--];		
	}
	
	public int top() {
		
		if(this.isEmpty()) {
			System.out.println("스택이 비었습니다.");
			return -1;
		}
		
		return this.stack[this.topIndex];
		
	}
    //초기화.
	public void popAll() {
		int size = this.stack.length;
		this.stack = new int[size];
		this.topIndex = -1;
	}
}
