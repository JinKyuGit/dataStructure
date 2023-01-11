package sort;

public class Sort {
	
	//선택정렬
	public void selectionSort(int [] arr) {
		
		for(int i = arr.length-1; i > 0; i--) {
			int temp = arr[i];
			int largestIndex = this.getLargestIndex(arr, i);
			arr[i] = arr[largestIndex]; //i와 largest가 동일 할 수 있으나 비교연산을 넣는 것이 낭비라 판단.
			arr[largestIndex] = temp;
		}
		
	}

	//arr 0 ~ k까지 가장 큰 수의 인덱스 리턴.
	public int getLargestIndex(int [] arr, int k) {
		int index = k; //논리상 arr[k]가 가장 높을 수 있음. 이러면 그대로 리턴.
		for(int i = 0; i < k; i++) { 
			if(arr[i] > arr[index]) {
				index = i;
			}
		}
		return index;
	}
	
	
	//버블정렬
	public void bubbleSort(int [] arr) {
		
		for(int i = 0; i < arr.length-1; i++) {
			//0부터 시작하여 바로 오른쪽 값과 대소를 비교하여 한칸씩 이동. 이를 n-1번 반복.
			for(int j = 0; j < arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	//삽입정렬
	public void insertionSort(int [] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int k = arr[i];
			int index = i-1;
			//왼쪽으로 한칸씩 내려가면서 k보다 우선순위가 크면 한칸씩 오른쪽으로 이동시키고 그 자리로 들어감.
			while(index >= 0 && k < arr[index]) {
				arr[index+1] = arr[index];
				index--;
			}
			arr[index+1] = k;
		}
		
	}
	
	// 병합정렬
	public void mergeSort(int [] arr, int p, int r) {
		
		if(p < r) {
			int q = (p+r)/2; //배열을 쪼갠다.
			//각각의 파트를 더 쪼갠다. - 재귀호출.
			this.mergeSort(arr, p,q);
			this.mergeSort(arr, q+1, r);
			//정렬(병합하며 정렬)
			this.merge(arr, p, q, r);
		}
	}
	
	//p~q, q+1~r까지의 배열을 합치면서 정렬한다.(각각은 이미 정렬되어진 상태)
	public void merge(int [] arr, int p, int q, int r) {
		
	   int [] temp = new int[r-p+1]; //필요한 크기만 할당.
	   
	   int i = p;
	   int j = q+1;
	   int k = 0;
	   
	   //우선순위에 따라 temp에 복사. 
	   while(i <= q && j <= r) {
		   if(arr[i] <= arr[j]) {
			   temp[k++] = arr[i++];
		   }else {
			   temp[k++] = arr[j++];
		   }
	   }
	   //반복문이 종료된 후 남은 데이터 이동. => 이미 정렬되어 있기에 그냥 넣으면 됨.
	   while(i <= q) { //왼쪽 배열 데이터가 남은 경우.
		   temp[k++] = arr[i++];
	   }
	   
	   while(j <= r) { //오른쪽 배열 데이터가 남은 경우.
		   temp[k++] = arr[j++];
	   }
	   
	   
	   //원 배열로 이동
	   k = 0;
	   while(p <= r) {
		   arr[p++] = temp[k++];
	   }
	   
		
	}
	
	
	//퀵 정렬
	public void quickSort(int [] arr, int left, int right) {
		
	    if(left >= right) {
	    	return;
	    }
		
	    int pivot = this.partition(arr, left, right);
	    
	    this.quickSort(arr, left, pivot-1);
	    this.quickSort(arr, pivot+1, right);
		
		
		
	}
	
	// 정렬.
	//i와 j 변수를 왼쪽에 두고 한칸씩 이동시키면서 pivot과 비교.
	//pivot보다 작은 숫자면 i와 위치 교환.
	//이러한 반복을 통해 오른쪽에는 pivot기준 더 큰 숫자, 왼쪽에는 pivot 기준 작은 숫자가 온다.
	//반복 후에 left ~ i 까지는 pivot보다 작은 숫자, i+1부터는 pivot보다 큰 숫자가 온다.
	public int partition(int [] arr, int left, int right) {
		
		int pivot = arr[right];
		
		int i = left-1;
		
		for(int j=left; j < right; j++) { //right는 pivot의 위치이므로 그 전까지만 비교.
			if(arr[j] < pivot) {
				i++;
				this.swap(arr, i, j);
			}
		}
		//반복이 끝난 후 i의 오른쪽 자리가 pivot이 위치할 자리
	    i++;
	    this.swap(arr, right, i);
		return i; //i자리에 pivot이 옴.
		
	}
	
	public void swap(int [] arr, int x, int y) {
		
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		
		/*
		System.out.println(x+" 와 "+y+" 교환 ");
	    for(int i = 0; i < arr.length; i++) {
	    	System.out.print(arr[i]+", ");
	    }
	    System.out.println();
		*/
	}


}
