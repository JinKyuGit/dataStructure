package datastructure_java.datastructure.heap;

public class HeapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Heap heap = new Heap();
		
		heap.init(10);
		
		heap.insert(10);
		heap.insert(5);
		heap.insert(7);
		heap.insert(8);
		
		heap.printHeap();
		
		heap.delete();
		
		heap.printHeap();
		
		heap.delete();
		
		heap.printHeap();
	}

}
