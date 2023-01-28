package datastructure_java.datastructure.graph;

public class GraphMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph graph = new Graph(5);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 4);
		/*
		 *   그래프 형태.
		 *      0
		 *     1 2
		 *    4   3
		 *    
		 *    0 -> 1 , 2
		 *    1 -> 0 , 4
		 *    2 -> 0 , 3
		 *    3 -> 2
		 *    4 -> 1
		 */
		
		graph.BFS(0);
		System.out.println();
		graph.DFS(0);
		System.out.println();
		graph.DFS2(0);
		
	}

}
