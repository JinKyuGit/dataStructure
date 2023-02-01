package datastructure_java.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph2 {
	
	//cost가 존재하는 그래프 구현.. 단순하게 배열로 처리.
	public class Node {
		
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	public List<Node> list = new ArrayList<>();
	
	public void insertData(int to, int cost) {
		Node node = new Node(to, cost);
		this.list.add(node);
	}
	
	
	
	

}
