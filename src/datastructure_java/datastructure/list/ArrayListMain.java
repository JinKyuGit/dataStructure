package datastructure_java.datastructure.list;

public class ArrayListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    ArrayList list = new ArrayList(4);
	    
	    list.append(1);
	    list.append(5);
	    list.append(7);
	    list.append(10);
	    
	    list.printList();
	    
	    list.add(2, 6);
		
	    list.printList();
	    
	   list.remove(0);
	   list.printList();
	   
	   list.removeItem(10);
	   
	   list.printList();
	}

}
