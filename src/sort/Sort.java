package sort;

public class Sort {
	
	//선택정렬
	public int[] selectionSort(int [] arr) {
		
		for(int i = arr.length-1; i > 0; i--) {
			int temp = arr[i];
			int largestIndex = this.getLargestIndex(arr, i);
			arr[i] = arr[largestIndex]; //i와 largest가 동일 할 수 있으나 비교연산을 넣는 것이 낭비라 판단.
			arr[largestIndex] = temp;
		}
		
		return arr;
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
	public int [] bubbleSort(int [] arr) {
		
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
		return arr;
	}
	
	//삽입정렬
	public int [] insertionSort(int [] arr) {
		
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
		return arr;
		
	}
	


}
