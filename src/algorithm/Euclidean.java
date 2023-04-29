package algorithm;

public class Euclidean {
	
	public static void main(String [] args) {
		
		
		Euclidean e = new Euclidean();
		
		int [] num = {12, 8};
		int [] copy = new int[2];
		copy[0] = num[0];
		copy[1] = num[1];
		System.out.println("입력값 : "+num[0]+", "+num[1]);
		int [] result = e.getSmallNum2(num);
		
		//System.out.println("result : "+result[0]+", "+result[1]);
		System.out.println("최대공약수 : "+e.getDivisor(result[0], result[1]));
		
		//최대공약수는 두 수의 곱 / 최대공약수이다.
		System.out.println("최소공배수 : "+copy[0]*copy[1]/e.getDivisor(result[0], result[1]));
		
		System.out.println("최대공약수 비재귀적 : "+e.gdc(num[0], num[1]));
		System.out.println("최대공약수 재귀2 : "+e.gdc2(num[0], num[1]));
		
	}
	
	public int getDivisor(int num1, int num2) {
		
		int divisor = 1;
		
		for(int i = num2; i > 0; i--) {
			
			if(num1 % i == 0 && num2 % i == 0) {
				divisor = i;
				break; //큰 수부터 계산하므로 가장 먼저 조건을 충족한 값이 최대공약수.
			}	
		}
		
		return divisor;
	}
	
	
	/*
	 * 유클리드 호제법을 통한 두 수의 최대공약수 구하기.
	 * 두 자연수의 최대공약수는 큰 수에서 작은 수를 뺀 값과 작은 수와의 최대공약수와 같음.
	 * ex) 12, 8 => 12 - 8과 8의 최대공약수와 동일 => 8 - 4와 4의 최대공약수와 동일
	 */
	
	public int [] getSmallNum(int [] num) {
		
		//두 수를 뺀 값이 0보다 큰 경우 재귀호출.
		if(num[0] - num[1] > 0) {
			
			if(num[0] - num[1] > num[1]) {
				num[0] = num[0] - num[1]; 
				//이 경우 num[1]은 그대로 둔다.
			}else {
				int temp = num[1];
				num[1] = num[0] - num[1];
				num[0] = temp;
			}
			//재귀호출... 이러한 반복을 통해 최대한 작은 값으로 만들 수 있다.
			this.getSmallNum(num);
		}
		
		//정지조건을 만족하면 리턴.
		return num;
	}
	
	
	//위의 과정은 내가 생각해낸 것인데 인터넷을 보니 다음과 같이 생략이 가능함.
	//큰 수에서 작은 수를 나눈 나머지 / 작은 수의 최대공약수.
	//호출 수가 훨씬 적으므로 이 알고리즘이 효율적이다.
	public int [] getSmallNum2(int [] num) {
		
		//두 수를 뺀 값이 0보다 큰 경우 재귀호출.
		if(num[0] % num[1] > 0) {
			
			if(num[0] % num[1] > num[1]) {
				num[0] = num[0] % num[1]; 
				//이 경우 num[1]은 그대로 둔다.
			}else {
				int temp = num[1];
				num[1] = num[0] % num[1];
				num[0] = temp;
			}
			//재귀호출... 이러한 반복을 통해 최대한 작은 값으로 만들 수 있다.
			this.getSmallNum2(num);
		}
		
		//정지조건을 만족하면 리턴.
		return num;
	}
	
	
	//비재귀 방법.
	public int gdc(int a, int b) {
		
		//a가 큰 수
		
		while(b != 0) {
			
			int r = a % b;  
			
			a = b; //큰 수를 작은 수로 나눈 나머지는 항상 작은 수보다 작으므로, a에는 항상 큰 수가 들어온다.
			b = r; //논리상 0이 될 수 있다. => 반복문 정지조건.
			
		}
		//정지조건에 의해 두 수를 나눈 나머지가 0이 되는 경우. 큰 수가 최대공약수가 된다.
		return a;

	}
	
	//재귀적 방법 다듬음.
	public int gdc2(int a, int b) {
		
		if(b != 0) {
			a = b;
			b = a % b;
			this.gdc2(a, b);
		}
		
		return a;
		
	}

}
