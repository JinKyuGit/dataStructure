package datastructure_java.datastructure.graph;

public class Dijkstra {
	
	/*
	 * 다익스트라 알고리즘 구현
	 * 
	 * 정점 a부터 b까지의 최소값.
	 * 
	 * a부터 시작하여 연결 가능한 정점의 비용을 계산
	 * 비용이 가장 적은 정점 선택
	 * 정점 선택 후 연결 가능한 정점의 비용을 재계산
	 * 이를 반복하여 모든 정점을 방문할 때까지 방문
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * A B C D E F
		 * 
		 * A : B(2), C(5), D(3)
		 * B : A(2), C(7), F(10)
		 * C : A(5), B(7), D(1), E(2), F(5)
		 * D : A(3), C(1), E(7)
		 * E : C(2), D(7), F(2)
		 * F : B(10), C(5), E(2) 
		 */
		
		int [][] graph = {
				{0, 2, 5, 3, 0, 0},
				{2, 0, 7, 0, 0, 10},
				{5, 7, 0, 1, 2, 5},
				{3, 0, 1, 0, 7, 0},
				{0, 0, 2, 7, 0 ,2},
				{0, 10, 5, 0, 2, 0}
		};
	
		
		Dijkstra d = new Dijkstra();
		int [] dist = d.dijkstra(graph);
		
		for(int i = 0; i < dist.length; i++) {
			System.out.println(i+" : "+dist[i]);
		}
		
	}
	
	
	//0부터 시작.
	public int[] dijkstra(int [][] graph) {
		
		int [] dist = new int[graph.length];
		
		
		dist[0] = 0; //시작노드.
		//아직 비용을 계산하지 않은 정점에 대해 초기화.
		for(int i = 1; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < graph.length; i++) {
			
			int [] edges = graph[i];
			
			for(int j = 0; j < edges.length; j++) {
				
				//j 정점에 대한 비용.
				int currentDist = edges[j];
				
				//자기자신 혹은 연결불가능 정점은 패스.
				if(currentDist == 0) {
					continue;
				}
				
				//시작지점으로부터 j정점까지의 비용이 기존 j정점으로의 비용보다 작은 경우 낮은 경우 갱신.
				//현재 j정점으로 갈 수 있는 최소비용을 선택함(greedy)
				if(currentDist+dist[i] < dist[j]) {
					dist[j] = currentDist+dist[i];
				}
			}
		}
		
		return dist;
	}
	

}
