package datastructure_java.datastructure.queue;

public class QueueMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayQueue queue = new ArrayQueue(5);
		
		queue.enqueue(4);
		queue.enqueue(2);
		queue.enqueue(1);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		
		System.out.println(queue.dequeue());
		
	}

}
