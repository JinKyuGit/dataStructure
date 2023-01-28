package datastructure_java.datastructure.queue;

public class ArrayQueue {
	
	//배열을 이용한 큐 구현
	
	private int[] queue;
	private int front;
	private int tail;
	private int numItems;
	
	public ArrayQueue(int size) {
		this.queue = new int[size];
		this.front = 0;
		this.tail = 0;
		this.numItems = 0;
	}
	
	
	public boolean isEmpty() {
		
		return (this.numItems == 0)? true : false;
	}
	
	public void enqueue(int data) {
		
		if(this.numItems == this.queue.length) {
			System.out.println("큐 가득 찼습니다.");
			return;
		}
		
		//맨 마지막 다음에 데이터 삽입.
		//경계를 넘어가는 경우 체크.
		if(this.tail == this.queue.length) {
			this.tail = 0;
		}
		
		this.queue[this.tail++] = data;
		this.numItems++;
		
	}
	
	public int dequeue() {
		
		if(this.isEmpty()) {
			System.out.println("큐가 비었습니다.");
			return -1;
		}
		
		//front의 데이터 저장.
		int returnValue = this.queue[this.front];
		
		this.numItems--;
		
		//front가 경계를 넘어서는 경우를 고려하여 front 이동.
		if(this.front == this.queue.length-1) {
			this.front = 0;
		}else {
			this.front++;
		}
		
		return returnValue;
	}
	
	//초기화. 
	public void dequeueAll() {
		
		int size = this.queue.length;
		
		this.queue = new int[size];
		this.numItems = 0;
		this.front = 0;
		this.tail = 0;
		
	}

}
