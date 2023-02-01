package datastructure_java.datastructure.graph;

import java.util.List;
import java.util.PriorityQueue;

import datastructure_java.datastructure.graph.Graph2.Node;

public class Prim {

	public static void main(String[] args) {

		
		/*
		 * 시작 정점을 우선순위 큐에 넣는다.
		 * 큐에서 꺼낸다.
		 * 방문 여부를 체크한다.
		 * 방문하지 않은 (연결 가능한) 간선정보를 우선순위 큐에 넣는다.
		 * 큐에서 꺼내서, 방문하지 않았으면 방문. 방문하였으면 패스.
		 * 큐가 빌때까지 반복.
		 * 
		 */
		
		
		/*
		 *  예시 그래프.
		 * 
		 *  정점 : 연결된 정점(비용)
		 *   0 : 1(5), 2(7)
		 *   1 : 0(5), 2(9), 4(10)
		 *   2 : 0(7), 1(9), 3(15)
		 *   3 : 2(15), 4(3)
		 *   4 : 3(4), 1(10)
		 *   
		 */
		Graph2 [] graph = new Graph2[5];
  		
		Graph2 graph0 = new Graph2();
		graph0.insertData(1, 5); graph0.insertData(2, 7);		
		Graph2 graph1 = new Graph2();
		graph1.insertData(0, 5); graph1.insertData(2, 9); graph1.insertData(4, 10);
		Graph2 graph2 = new Graph2();
		graph2.insertData(0, 7); graph2.insertData(1, 9); graph2.insertData(3, 15);
		Graph2 graph3 = new Graph2();
		graph3.insertData(2, 15); graph3.insertData(4, 3);
		Graph2 graph4 = new Graph2();
		graph4.insertData(3, 4); graph4.insertData(1, 10);
		
		graph[0] = graph0;
		graph[1] = graph1;
		graph[2] = graph2;
		graph[3] = graph3;
		graph[4] = graph4;
		
		
		boolean [] visit = new boolean[5];
		
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		
		queue.offer(new Edge(0, 0, 0));
		
		String result = "";
		int cost = 0;
		
		while(!queue.isEmpty()) {
			
			Edge edge = queue.poll();
			
			//방문한 간선이면 패스.
			if(visit[edge.to]) {
				continue;
			}
			
			//방문처리.
			visit[edge.to] = true;
			
			//출력을 위한 처리.
			if(edge.cost != 0) {
				result += edge.from+" - 연결 - "+edge.to+", cost : "+edge.cost+"\n";
				cost += edge.cost;
			}

			//edge에서 나온 간선에 대해 연결된 간선들의 갯수만큼 순회하며 큐를 채움.
			List<Node> nodeList = graph[edge.to].list;
			for(Node loop : nodeList) {
				queue.offer(new Edge(edge.to, loop.to, loop.cost));
			}
		}
		
		System.out.println(result);
		System.out.println("총 코스트 : "+cost);
		
		
		
	}
	
	public static class Edge implements Comparable<Edge> {
		
		public int from; //출력을 위한 변수.
		public int to;
		public int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		//더 작은 숫자가 우선순위가 오게 함.
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	

	
	

}
