package sort;

public class SortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sort2 sort = new Sort2();
		
		int size = 10000;
		int [] arr = new int[size];
		
		//난수 생성
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*size);
		}
		
		/*
	    for(int i = 0; i < arr.length; i++) {
	    	System.out.print(arr[i]+", ");
	    }
	     System.out.println();
	    */
	   
		
		long before = System.currentTimeMillis();
		
		// sort.selectionSort(arr);
		// sort.bubbleSort(arr);
		// sort.insertionSort(arr);
		// sort.mergeSort(arr, 0, arr.length-1);
	    // sort.quickSort(arr, 0, arr.length-1);
		
		long after = System.currentTimeMillis();
		
		double diff = ((double)(after - before))/1000;
		
		System.out.println("실행시간 : "+diff);

		//검증
		/*
	    for(int i = 0; i < arr.length; i++) {
	    	System.out.print(arr[i]+", ");
	    }
	    System.out.println();
        */
	}

}
