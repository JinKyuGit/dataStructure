package datastructure_java.datastructure.list;

public class ArrayList {
	
	//데이터 배열.
	private int[] items;
	
	//데이터의 갯수.
	private int numItems;
	
	//최초 초기화 갯수 저장.
	private int initSize;
	
	//생성자. 
	public ArrayList (int size) {
		this.items = new int[size];
		this.numItems = 0;
		this.initSize = size;
	}
	
	// items의 사이즈를 늘리는 작업. 
	public void sizeUpItems(int size) {
		
		int[] newItem = new int[this.items.length+size];
		for(int i = 0; i < items.length; i++) {
			newItem[i] = items[i];
		}
		this.items = newItem;
		
	}
	
	//데이터 이동
	public void shiftData(String direct, int start, int end) {
		
		if("L".equals(direct)) {
			
			for(int i = start; i < end; i++) {
				this.items[i] = this.items[i+1];
			}
			System.out.println("데이터 좌측으로 시프트 완료.");
			
		}else if("R".equals(direct)) {
			 	
			for(int i = end-1; i >= start; i--) {
				this.items[i+1] = this.items[i];
			}
			System.out.println("데이터 우측으로 시프트 완료.");
		}else {
			// 잘못된 명령. 
		}
		
		
	}
	
	//특정 index에 데이터 삽입.
	public void add(int index, int data) {
				
		//인덱스의 범위가 리스트의 용량보다 크면 늘려준다.
		if(index >= this.items.length || this.numItems == this.items.length) {
			this.sizeUpItems(10);
		    System.out.println("리스트 용량 초과로 배열 재생 ");
		}
				
		//데이터 삽입 공간 확보 - index를 포함해서 이후 마지막 데이터까지 한칸씩 우측으로 이동시킨다. 	
		this.shiftData("R", index, this.numItems);
		
		// 데이터 삽입.
		this.items[index] = data;
		this.numItems++;
		
		System.out.println("인덱스 : "+index+" 에 데이터 삽입. 현재 데이터 갯수 : "+(this.numItems));
		
	}
	
	//맨 마지막에 데이터 삽입
	public void append(int data) {
		
		//사이즈가 다 찼으면 늘려준다.
		if(this.numItems == this.items.length) {
			this.sizeUpItems(10);
			System.out.println("리스트 용량 초과. 추가용량 : "+10);
		}
		
		this.items[this.numItems] = data;
		this.numItems++;
		

		System.out.println("인덱스 : "+(this.numItems-1)+" 에 데이터 삽입. 현재 데이터 갯수 : "+(this.numItems));
	}
	
   //특정 인덱스의 데이터를 삭제한다.
	public void remove(int index) {
		
		//에러처리.
		if(index >= this.numItems) {
			System.out.println("삭제할 데이터가 없거나 범위를 초과했습니다.");
			return;
		}
		
		//데이터 시프트 처리. 이 처리를 통해 index의 데이터는 사라짐.
		this.shiftData("L", index, this.numItems);
		
		this.numItems--;
		
		System.out.println("인덱스 "+index+ " 데이터 삭제 완료.");
			
	}
	
	//데이터 탐색. 
	public int indexOf(int target) {
		
		for(int i = 0; i < this.numItems; i++) {
			if(this.items[i] == target) {
				return i;
			}
		}
		
		System.out.println("탐색 실패 -일치하는 데이터 없음.");
		return -1;
		
	}
	
	
	//처음 일치하는 데이터 삭제.
	public void removeItem(int target) {
		
		//탐색.
		int index = this.indexOf(target);
		
		if(index == -1) {
			return;
		}
		//삭제.
		this.remove(index);
		
	}
	
	//index의 데이터를 알려준다.
	public int get(int index) {
		
		if(index >= this.numItems || index < 0) {
			System.out.println("범위를 초과하였습니다. ");
			return -1;
		}
		
		return this.items[index];
		
	}
	
	//index의 데이터를 변경
	public void set(int index, int newData) {
		if(index >= this.numItems || index < 0) {
			System.out.println("범위를 초과하였습니다. ");
		}
		
		this.items[index] = newData;
	}
	
	//데이터의 길이
	public int len() {
		return this.numItems;
	}
	
	//빈 리스트인지 체크
    public boolean isEmpty() {
    	return (this.numItems == 0)? true : false;
    }
    
    //비우기
    public void clear() {
    	this.items = new int[this.initSize];
    }
    
    //프린트
    public void printList() {
    	
    	for(int i = 0; i < this.numItems; i++) {
    		System.out.print(this.items[i]+" ");
    	}
    	System.out.println();
    	
    }

}
