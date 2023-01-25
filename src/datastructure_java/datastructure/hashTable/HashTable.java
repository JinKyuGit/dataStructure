package datastructure_java.datastructure.hashTable;

import java.util.ArrayList;
import java.util.List;

import datastructure_java.datastructure.list.LinkedList;

//체이닝 방식으로 구현.
public class HashTable {
	
	public List<LinkedList> list;
	public int hash = 13; 
	
	//생성자.
	public HashTable() {
		
		this.list = new ArrayList<>();
		int size = 12;
		
		for(int i = 0; i <= size; i++) {
			LinkedList node = new LinkedList();
			this.list.add(node);
		}
	}
	
    public void insert(int data) {
    	
    	int address = data % this.hash;
    	this.list.get(address).append(data);
    	
    }
    
    public void search(int target) {
    	
    	
    	int address = target % this.hash;
    	
    	int index = this.list.get(address).indexOf(address);
    	
    	System.out.println("address : "+address);
    	
    	if(index > 0) {
    		System.out.println("index : "+this.list.get(address).get(index));
    	}else {
    		System.out.println("not found");
    	}
    }
    
    public void delete(int target) {
    	
    	int address = target % this.hash;
    	
    	int index = this.list.get(address).indexOf(target);
    	
    	System.out.println("address : "+address);
    
    	if(index >= 0) {
            this.list.get(address).remove(index);
            System.out.println("data deleted.");
    	}else {
    		System.out.println("not found");
    	}
    	
    }
    
    public void printHashTable() {
    	
    	System.out.println("=== print table ===");
    	int i = 0;
    	for(LinkedList loop : this.list) {
    	    System.out.print("address ["+i+"] : ");
    	    loop.print();
    		i++;
    	}
    	
    	
    }

}
