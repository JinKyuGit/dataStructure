package datastructure_java.datastructure.heap;

public class Heap {
	
	//최대 힙 구현.
    public int [] array;
    public int numItems;
    
    public void init(int size) {
    	this.array = new int [size];
    	this.numItems = 0;
    }
    
    public void printHeap() {
    	
    	for(int i = 0; i < this.numItems; i++) {
    		System.out.print(this.array[i]+" ");
    	}
    	System.out.println();
    	
    }
    
    public void insert(int data) {
    	
    	if(this.numItems == this.array.length -1 ) {
    		System.out.println("heap is full");
    		return;
    	}
    	
    	//마지막 자리에 insert.
    	this.array[this.numItems] = data;
    	//재귀함수 호출.
    	this.percolateUp(this.numItems);
    	this.numItems++;
    	
    	
    }
    
    //삽입 - 재귀적 방식.
    public void percolateUp(int index) {
    	
    	int parent = index / 2;
    	
    	if(index > 0 && this.array[index] > this.array[parent]) {
    		
    		//swap.
    		int temp = this.array[index];
    		this.array[index] = this.array[parent];
    		this.array[parent] = temp;
    		//루트까지 반복.
    		this.percolateUp(parent);
    	}
    	
    }
    
    //삭제
    public int delete() {
    	
    	if(this.numItems == 0) {
    		System.out.println("heap is empty");
    		return -1;
    	}
    	
    	int del = this.array[0];
    	this.array[0] = this.array[this.numItems-1];
    	//재귀함수 호출.
    	this.percolateDown(0);
    	this.numItems--;
    	
    	return del;
    }
    
    
    
	//삭제 - 재귀적 방법.
    public void percolateDown(int index) {
    	
    	int child = index * 2 + 1; //left
    	int rightChild = index * 2 + 2;
    	
    	if(child <= this.numItems - 1) {
    		
    		//child에 우선순위가 높은 index가 오도록 하는 작업.
    		if(rightChild <= this.numItems -1 && this.array[child] < this.array[rightChild]) {
    			child = rightChild;
    		}
    		
    		//swap이 필요한 경우.
    		if(this.array[index] < this.array[child]) {
    			int temp = this.array[index];
    			this.array[index] = this.array[child];
    			this.array[child] = temp;
    			
    			//만족하는 자리를 찾을때까지 반복.
    			this.percolateDown(child);
    		}
    		
    		
    	}
    	
    }

}
