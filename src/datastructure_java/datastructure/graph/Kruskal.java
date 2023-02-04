package datastructure_java.datastructure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import datastructure_java.datastructure.graph.Graph2.Node;
import datastructure_java.datastructure.graph.Prim.Edge;

public class Kruskal {

	//크루스칼 알고리즘 구현.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		Kruskal k = new Kruskal();
		k.kruskal(graph);
		
	}
	
	
	//선행작업 - union find.
	int [] parent; //이 변수에는 각각의 인덱스(노드)가 어디에 연결되어있는지를 나타낸다.
	
	public void init(int size) {
		this.parent = new int[size];
		//편의를 위해 각각 다른 숫자로 초기화 해둔다.
		for(int i = 0; i < this.parent.length; i++) {
			this.parent[i] = i;
		}
	}
	
	//최상위 부모 리턴.
	public int find(int x) {
		if(this.parent[x] == x) {
			return x;
		}else {
			return this.find(this.parent[x]);
		}
	}
	
	public boolean union(int x, int y) {
		
		boolean result = false;
		
		//부모 탐색.
		int parentX = this.find(x);
		int parentY = this.find(y);
		
		//부모가 같지 않으면 연결 가능. 각각 본인의 index로 초기화를 해두었기 때문에 0체크 불필요.
		if(parentX != parentY) {
			
			if(x < y) {
				//부모 동기화.
				this.updateParent(y, parentX);
				this.parent[y] = parentX;
			}else {
				//부모 동기화.
				this.updateParent(x, parentY);
				this.parent[x] = parentY;
				
			}
			
			result = true;
		}
		
		return result;
	}
	
	//부모 정보 보정... 하나의 부모를 가진 노드가 새 부모와 연결될때, 기존 부모와의 우선순위 비교를 통해 부모를 동기화 해주어야 한다.
	public void updateParent(int x, int newParent) {
		
		int beforeParent = this.find(x);
		
		if(beforeParent > newParent) {
			this.parent[beforeParent] = newParent;
		}
	}
	
	
	/*
	 * 크루스칼 알고리즘.
	 * 1. 주어진 그래프에 대해 모든 간선의 정보를 정렬한다.
	 * 2. 비용이 가장 작은 간선부터 연결 가능한 경우 정점을 연결한다. (사이클이 되지 않으면 연결 가능)
	 * 
	 */
	public void kruskal(Graph2 [] graph) {
		
		//union - find를 위한 init처리.
		this.init(graph.length);
		
		//우선순위 큐 활용.
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		
		//모든 간선 정보 큐에 저장.
		for(int i = 0; i < graph.length; i++) {
			List<Node> nodeList = graph[i].list;
			for(Node loop : nodeList) {
				queue.offer(new Edge(i, loop.to, loop.cost));
			}
		}
		
		//출력용 변수.
		String result = "";
		int cost = 0;
		
		//큐가 비워질때까지 반복.
		while(!queue.isEmpty()) {
			
			Edge edge = queue.poll();
			
			if(this.union(edge.from, edge.to)) {
				
				result += edge.from+"과 "+edge.to+" 연결. 비용 : "+edge.cost+"\n";
				cost += edge.cost;
				
			}
		}
		
		System.out.println(result);
		System.out.println("총 비용 : "+cost);
		
		
	}
	
	public class Edge implements Comparable<Edge> {
		
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
