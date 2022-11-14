package datastructure_java.datastructure.list;

public class LinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		LinkedList list = new LinkedList();
		
		list.append(3);
		list.append(5);
		list.append(7);
		list.append(1);
		
		list.print();
		
		list.set(2, 8);
		
		list.print();
		
		list.add(2,  7);
		
		list.print();
		
		list.remove(1);
		
		list.print();
	}

}
