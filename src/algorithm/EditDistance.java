package algorithm;


public class EditDistance {
	
	// 문자열 S를 T로 대체할 때  편집횟수가 최소한의 수 구하는 알고리즘.
	// 동적 계획법 활용.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String S = "strong";
		String T = "stone";
		
		EditDistance ed = new EditDistance();
		
		int [][] E = ed.getEditDistance(S, T);
		
		for(int i = 0; i < E.length; i++) {
			for(int j = 0; j < E[i].length; j++) {
				System.out.print(E[i][j]+" ");
			}
			System.out.println();
		}

	}
	
	
	
	public int [][] getEditDistance(String S, String T) {
		
		int [][] E = new int[S.length()][T.length()];
		
		//E[i, j] = min(E[i, j-1] + 1 , E[i-1, j+1] + 1, E[i-1, j-1] + a)
		//i나 j의 숫자가 변하는 것은 항상 +1 의 연산을 요구함.
		//i-1, j-1와 i, j는 경우에 따라 편집이 없을 수도 있음. ex) st st => sto sto
		//즉, a의 값을 구하는 것이 알고리즘의 핵심.
		//E[i,0], E[0,j] 은 항상 i j
		
		//초기값
		for(int i = 0; i < E.length; i++) {
			E[i][0] = i;
		}
		for(int j = 0; j < E[0].length; j++) {
			E[0][j] = j;
		}
		
		//편집거리 계산.
		for(int i = 1; i < E.length; i++) {
			for(int j = 1; j < E[i].length; j++) {
			
				//E[i-1, j-1] + a 계산
				int a = 0;
				
				char nowS = S.charAt(i);
				char nowT = T.charAt(j);
				
				//현재 문자열이 같은 경우 => 비용 0
				if(nowS == nowT) {
					a = 0;
				}else {
					a = 1;
				}
				
				E[i][j] = this.min(E[i-1][j]+1, E[i][j-1]+1, E[i-1][j-1]+a);		
			}
		}
		return E;
	}
	
	//세 개의 숫자 중 가장 작은 수 리턴.
	public int min(int a, int b, int c) {
		
		if(a < b && a < c) {
			return a;
		}
		if(b < a && b < c) {
			return b;
		}
		if(c < a && c < b) {
			return c;
		}
		
		return a;
		
	}
	
	

}
