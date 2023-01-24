package sort;

public class Sort2 {

	//정렬 복습을 위한 클래스.
	public void swap(int [] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public void selectionSort(int [] arr) {
		
		
		for(int i = 0; i < arr.length; i++) {
			int small = arr[i];
			int index = i;
			for(int j = i+1; j < arr.length; j++) {
				if(small > arr[j]) {
					small = arr[j];
					index = j;
				}
			}
			//반복 종료 후 arr[index]가 가장 작은 값.
			this.swap(arr, i, index);
		}
	}
	
	public void bubbleSort(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					this.swap(arr, j, j+1);
				}
			}
		}
	}
	
	public void insertionSort(int [] arr) {
		
		for(int i = 1; i < arr.length; i++) {
			int k = arr[i];
			int index = i;
			for(int j = i; j > 0; j--) {
				if(arr[j-1] < k) {
					index = j;
					break;
				}
				//한칸씩 우로 이동.
				arr[j] = arr[j-1];
			}
			//반복종료 후 index의 위치로.
			arr[index] = k;
			
			
		}
		
	}
	
	public void mergeSort(int [] arr, int left, int right) {
		
		if(left >= right) {
			return;
		}
		int mid = (left+right)/2;
		this.mergeSort(arr, left, mid);
		this.mergeSort(arr, mid+1, right);
		this.merge(arr, left, mid, right);
		
		
		
	}
	
	//p~q / q~r merge
	public void merge(int [] arr, int p, int q, int r) {
		
		int [] tempArray = new int[r-p+1];
		
		int i = 0;
		int j = p;
		int k = q+1;
		
		while(j <= q && k <= r) {
			
			if(arr[j] < arr[k]) {
				tempArray[i++] = arr[j++];
			}else {
				tempArray[i++] = arr[k++];
			}		
		}
		
		while(j <= q) {
			tempArray[i++] = arr[j++];
		}
		
		while(k <= r) {
			tempArray[i++] = arr[k++];
		}
		
		//원 배열에 복사.
		i = 0;
		while(p <= r) {
			arr[p++] = tempArray[i++];
		}
	
	}
	
	public void quickSort(int [] arr, int left, int right) {
		
		if(left >= right) {
			return;
		}
		
		int pivot = this.partition(arr, left, right);
		
		this.quickSort(arr, left, pivot-1);
		this.quickSort(arr, pivot+1, right);
		
		
	}
	
	
	public int partition(int [] arr, int left, int right) {
		int pivot = arr[right];
		
		int i = left - 1;
		
		for(int j = left; j < right; j++) {
			if(arr[j] < pivot) {
				++i;
				this.swap(arr, i, j);
			}
		}
		
		i++;
		this.swap(arr, i, right);
		
		return i;
		
	}
}
