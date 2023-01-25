package datastructure_java.datastructure.hashTable;

public class HashTableMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashTable ht = new HashTable();
		
		ht.insert(10);
		ht.insert(100);
		ht.insert(12);
		ht.insert(8);
	    ht.insert(100);
	    ht.insert(25);
		
		
		ht.printHashTable();
		
		ht.delete(12);
		
		ht.printHashTable();

	}

}
