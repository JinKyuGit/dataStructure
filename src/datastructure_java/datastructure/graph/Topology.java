package datastructure_java.datastructure.graph;

import datastructure_java.datastructure.list.LinkedList;
import datastructure_java.datastructure.list.LinkedList.Node;

public class Topology {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 그래프 구현
		 * 0 : 1, 3
		 * 1 : 2, 5
		 * 2 : 3, 4
		 * 3 : 4, 5
		 * 4 : 5
		 * 5 : 
		 */
		
		Graph graph = new Graph(6);
		graph.addEdge(0, 1); graph.addEdge(0, 3); // 0
		graph.addEdge(1, 2); graph.addEdge(1, 5); // 1
		graph.addEdge(2, 3); graph.addEdge(2, 4); // 2
		graph.addEdge(3, 4); graph.addEdge(3, 5); // 3
		graph.addEdge(4, 5);// 4

		
		
		Topology to = new Topology();
		to.topologySort(graph);
		
		
		
	}
	
	//위상정렬 구현.
	public void topologySort(Graph graph) {
		
		String result = ""; //출력을 위함.
		
		int [] array = new int[graph.graph.length];
		
		this.makeInCount(graph, array);
		
		int count = 0;
		
		while(count +1 <= graph.graph.length) {
			
			//배열을 순회하며 진입 경로가 0인 것에 대해 기록. 0인 것들끼리는 우선순위가 동일하다.
			for(int i = 0; i < array.length; i++) {
				if(array[i] == 0) {
					result += "진입순서 : "+count+", 진입 : "+i+"\n";
					count++;
					
					array[i] = -1; //중복 방지.
					this.minusInCount(graph, array, i);
				}
			}			
		}
		
		System.out.println(result);
		
	}
	
	//그래프를 받아 배열을 채움.
	//배열의 인덱스는 간선의 번호를 의미함.
	//각 배열의 값은 해당 간선으로 들어올 수 있는 진입 가능한 간선의 수를 기록함.
	public int [] makeInCount(Graph graph, int [] array) {
		
		//파라미터로 받은 그래프는 서로 연결된 정점이 각각 서로를 가리키고 있으므로, 중복을 제거하여 하나씩만 기록함.
		LinkedList[] list = graph.graph;
		for(int i = 0; i < list.length; i++) {
			
			LinkedList vertex = list[i];
			Node cursor = vertex.getNode(0);
			
			while(null != cursor) {
				
				//중복 제거. 방향은 숫자가 낮은 정점으로부터 높은 정점으로만 가능.
				if(i < cursor.item) {
					array[cursor.item] += 1;
				}
				cursor = cursor.next;
			}
			
		}
		
		return array;
	}
	
	//그래프와 배열을 받아, index 정점으로부터 진입 가능한 간선을 삭제함.
	public int [] minusInCount(Graph graph, int [] array, int index) {
		
		
		LinkedList vertex = graph.graph[index];
		
		Node cursor = vertex.getNode(0);
		
		while(null != cursor) {
			
			//중복 제거를 위한 로직... 숫자가 높은 정점 => 낮은 정점은 무시.
			if(index < cursor.item) {
				array[cursor.item] -= 1;
			}
			
			cursor = cursor.next;
		}
		
		
		return array;
	}
	

	

}
