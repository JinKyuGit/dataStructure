package algorithm;

public class CoinChange {
	
	//동전 거스름돈 문제를 그리디, 다이나믹 프로그래밍으로 각각 풀어봄.
	
	public static int [] coin = {16, 10, 5, 1};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange cc = new CoinChange();
		
		cc.greedy(20);
		cc.dynamic(20);
	}
	
	
	//그리디 방식
	public void greedy(int amount) {
		
		int cnt = 0;
		int sum = 0;
		
		while(sum != amount) {
			for(int i = 0; i < coin.length; i++) {
				if(coin[i] <= amount - sum) {
					sum += coin[i];
					cnt++;
					System.out.println("사용한 동전 : "+coin[i]+", 남은 거스름돈 : "+(amount-sum));
				}
			}
		}
		System.out.println("사용된 동전 수 : "+cnt);
		
	}
	
	//다이나믹
	public void dynamic(int amount) {
		
		//거스름돈 i에 대해 최소의 거스름돈 동전 수를 기록할 배열.
		int [] arr = new int[amount+1];
		
		//max값으로 채워둠.
		for(int i = 1; i < arr.length; i++) {
			arr[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i < arr.length; i++) {
			
			for(int j = 0; j < coin.length; j++) {
				
				/*
				 * 1) 거슬러줄 수 있는 동전이 거스름돈보다 작거나 같고, 
				 * 2) 현재 거슬러줄 수 있는 금액을 뺀 나머지에 대한 거스름돈 수+1이 지금까지 계산된 거스름돈 수보다 작으면 갱신.
				 * 즉, i = 5일때
				 * 거스름돈은 1x5로 계산되었다가
				 * 5x1이 더 최적해이므로 최적해로 바뀐다.(현재 루프 순서에 따라 최적해부터 구해짐)
				 * 
				 * 1원일때는 5-1 4원에 대한 최적해 4개 + 1
				 * 5원일때는 5-5 0원에 대한 최적해 0 + 1 <= 최적해
				 * 
				 */
				if(coin[j] <= i && arr[i-coin[j]] + 1 < arr[i]) {
						arr[i] = arr[i-coin[j]]+1;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(i+" 원일 때 거스름돈 수 : "+arr[i]);
		}
		
		System.out.println("필요한 동전 수 : "+arr[amount]);
	}

}
