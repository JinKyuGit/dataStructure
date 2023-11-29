package algorithm;


public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Permutation p = new Permutation();
		
		int[] arr = {1, 2, 3, 4, 5};
		int r = 3;
		int[] result = new int[arr.length];
		boolean[] visited = new boolean[arr.length];
		
		p.permutation(arr, result, visited, 0, r);
		
		System.out.println("========");
		
		p.combination(arr, result, visited, 0, 0, r);
		
		

	}
	
	/*
	 * 순열 알고리즘 - nPr
	 * n개의 원소 중에서 r개를 중복하지 않고 순서대로 나열.
	 * 
	 */
	public void permutation(int[] arr, int[] result, boolean[] visited, int depth, int r) {
		
		//정지 조건 - depth == r
		if(depth == r) {
			for(int i = 0; i < r; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				this.permutation(arr, result, visited, depth+1, r);
				visited[i] = false;
			}
		}
	}
	
	/*
	 * 조합 알고리즘 - nCr
	 * 
	 * 순열과 비슷하나 순열에서 중복을 제거한 것(순서에 의미x)
	 * start라는 변수를 두어 반복문의 시작점을 다르게 하는 점만 다름.
	 * 
	 */
	
	public void combination(int[] arr, int[] result, boolean[] visited, int start, int depth, int r) {
		
		//정지 조건 - depth == r
		if(depth == r) {
			for(int i = 0; i < r; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}
		
		for(int i = start; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				this.combination(arr, result, visited, start+1, depth+1, r);
				visited[i] = false;
			}
		}
	}

}
