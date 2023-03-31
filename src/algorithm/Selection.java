package algorithm;

public class Selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1 2 4 5 6 9 10
		int [] arr = {4, 6, 2, 9, 1, 5, 10};
		
		Selection sel = new Selection();
		
		int k = 7;
		sel.selection(arr, 0, arr.length-1, k);
		
		System.out.println(arr[k-1]);
		

	}
	/*
	 * 선택 알고리즘. 임의의 배열에서 k번째로 작은 수 찾기.
	 * 
	 * 1. 맨 왼쪽 원소를 피봇으로 정함
	 * 2. 피봇을 기준으로 피봇보다 작은 값은 왼쪽, 큰 값은 오른쪽으로 이동
	 * 3. 이동이 끝난 뒤 피봇의 위치에 맞게 피봇 이동
	 * 4. 왼쪽 그룹이 k보다 많은 경우 => 왼쪽 그룹을 대상으로 다시 반복
	 * 5. 왼쪽 그룹이 k보다 적은 경우 => 오른쪽 그룹을 대상으로 다시 반복
	 * 6. 피봇이 k번째 원소가 될 때 까지 반복.
	 */
	
	public void selection(int [] arr, int left, int right, int k) {
		
		int pivotIndex = this.partition(arr, left, right);
		
		//정지조건은 다음 두가지 중 하나이다.
		// pivot의 위치가 구하려는 수 인 경우와
		// 해당 집합의 정렬이 끝난 경우.
		if(pivotIndex - left + 1 == k || left >= right) {
			return;	
		}
		
		if(pivotIndex - left + 1 > k) {
			this.selection(arr, left, pivotIndex-1, k);
		}else {
			this.selection(arr, pivotIndex+1, right, k);
		}	
		
	}
	
	public int partition(int [] arr, int left, int right) {
		
		int pivot = arr[left];
		int i = left;
		int j = right;
		
		while(i < j) {
			
			while(arr[i] <= pivot && i < j) {
				i++;
			}
			
			while(arr[j] > pivot && i < j) {
				j--;
			}
			
			this.swap(arr, i, j);
		}
		
		//i 혹은 i-1이 pivot이 위치할 곳이다.
		if(left < i-1) {
			this.swap(arr, left, i-1);
			return i-1;
		}else {
			this.swap(arr, left, i);
			return i;
		}

		
	}
	
	
	public void swap(int [] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
