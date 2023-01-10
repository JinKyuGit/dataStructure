package sort;

public class SortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sort sort = new Sort();
		
		int [] arr = new int[10];
		
		//난수 생성
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*arr.length);
		}
		
		
	    for(int i = 0; i < arr.length; i++) {
	    	System.out.print(arr[i]+", ");
	    }
	    System.out.println();
		
		long before = System.currentTimeMillis();
		
		//arr = sort.selectionSort(arr);
		//arr = sort.bubbleSort(arr);
		//arr = sort.insertionSort(arr);
		arr = sort.mergeSort(arr, 0, arr.length-1);
		
		long after = System.currentTimeMillis();
		
		double diff = ((double)(after - before))/1000;
		
		System.out.println("실행시간 : "+diff);

		//검증
	    for(int i = 0; i < arr.length; i++) {
	    	System.out.print(arr[i]+", ");
	    }
	    System.out.println();

	}

}
