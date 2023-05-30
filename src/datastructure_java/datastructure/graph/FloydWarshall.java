package datastructure_java.datastructure.graph;

public class FloydWarshall {
	
	/*
	 * 모든 쌍 최단경로 찾기.
	 * floyd-warshall 알고리즘.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] graph = {
			{0, 4, 2, 5, 100},
			{100, 0, 1, 100, 4},
			{1, 3, 0, 1, 2},
			{-2, 100,100, 0, 2},
			{100, -3, 3, 1, 0}
		};
		
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph[i].length; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("===========================");
		
		FloydWarshall aps = new FloydWarshall();
		aps.getShortest(graph);
		
		
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph[i].length; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}

	}
	
	
	public void getShortest(int [][] graph) {
		
		for(int k = 0; k < graph.length; k++) {
			for(int i = 0; i < graph.length; i++) {
				if(i == k) continue;
				for(int j = 0; j < graph.length; j++) {
					if(j == k || j == i) continue;
					//i 부터 j의 최단경로는 i->k->j를 거쳐가는 경로와 직접 가는 경로 중 최소값.
					graph[i][j] = Math.min(graph[i][k]+graph[k][j], graph[i][j]);
 				}
			}
		}
		
		
		
	}
	
	
	
	

}
