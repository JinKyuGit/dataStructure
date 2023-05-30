package datastructure_java.datastructure.list;

public class LinkedList {
	
	//노드 클래스.
	public class Node {
		public int item;
		public Node next;
	}
	
	// 멤버 변수
	private int numItems;
	private Node head;
	
	
	//생성자.
	public LinkedList() {
			
		this.numItems = 0;
		//편의를 위해 더미 헤드를 둔다.
		Node dummyHead = new Node();
		dummyHead.item = 0;
		dummyHead.next = null;
		this.head = dummyHead;
		
	}
	
	//인덱스에 해당하는 노드 구하기.
	public Node getNode(int index) {
		
		if(index < -1 && index >= this.numItems) {
			System.out.println("노드 탐색 : 범위 초과.");
			return null;
		}
		
		// -1 이면 더미헤드 리턴.
		if(index == -1) {
			return this.head;
		}
		
		Node cursor = this.head; //head는 더미헤드이므로 사실상 다음이 진짜 헤드임.
		int k = 0;
		
		while(k <= index) {
			
			cursor = cursor.next;			
			k++;
		}
		
		return cursor;
		
	}
	
	//특정 인덱스에 데이터 삽입
	public void add(int index, int data) {
		
		if(index < 0 && index > this.numItems+1) {
			System.out.println("데이터 삽입 : 범위 초과. 범위는 0 ~ "+(this.numItems+1)+" 만 가능.");
			return;
		}
		
		Node newNode = new Node();
		newNode.item = data;
		newNode.next = null;
		
		Node preNode = this.getNode(index-1); 
		
		if(null != preNode) {
			newNode.next = preNode.next;
			preNode.next = newNode;
			this.numItems++;
			System.out.println(data+" 데이터 삽입 완료.");
		}
		
	}
	
	//맨 마지막에 데이터 삽입.
	public void append(int data) {
		
		Node newNode = new Node();
		newNode.item = data;
		newNode.next = null;
		
		Node preNode = this.getNode(this.numItems-1);
		
		if(null != preNode) {
			preNode.next = newNode;
			this.numItems++;
			//System.out.println(data+" 데이터 삽입 완료.");
		}
		
	}
	
	//특정 인덱스의 데이터 삭제.
	public void remove(int index) {
		
	   if(index < 0 || index > this.numItems) {
		   System.out.println("데이터 삭제 : 범위 초과. 범위는 0 ~ "+(this.numItems)+" 만 가능.");
			return;
	   }
	   
	   Node preNode = this.getNode(index-1);
	   
	   //삭제할 이전노드의 next값을 삭제할 노드의 다음노드로 연결. null이 들어갈 수도 있다.
	   Node delNode = preNode.next;
	   preNode.next = delNode.next;
	   
	   this.numItems--;
	   
	}
	
	//맨 마지막 데이터 삭제.
	public void removeItems() {
		
		//remove 활용.
		this.remove(this.numItems);
		
	}
	
	//index의 데이터 리턴.
	public int get(int index) {
		
		Node node = this.getNode(index);
		
		if(null == node) {
			return -1;
		}else {
			return node.item;
		}
		
	}
	
	//index의 데이터 변경
	public void set(int index, int item) {
		
		Node node = this.getNode(index);
		if(null != node) {
			node.item = item;
		}
		
		
	}
	
	//특정 데이터가 맨 먼저 있는 노드 탐색하여 인덱스 리턴.
	public int indexOf(int target) {
		
		int result = 0;
		
		Node cursor = this.head.next;
		
		for(int i = 0; i < this.numItems; i++) {
			
			if(null == cursor) {
				break;
			}
			
			if(cursor.item == target) {
				result = i;
				break;
			}
			cursor = cursor.next;
		}
		
		
		return result;
	}
	
	public int len() {
		return this.numItems;
	}
	
	public boolean isEmpty() {
		
		return (null == this.head.next)? true : false;	
		
	}
	
	//초기화
	public void clear() {
		// 더미헤드의 next를 없애버린다.
		this.head.next = null;
		this.numItems = 0;
	}
	
	
	//테스트용
	public void print() {
		
		Node node = this.head.next;
		
		while(null != node) {
			System.out.print(node.item+", ");
			node = node.next;
		}
		
		System.out.println();
	}
	

}
