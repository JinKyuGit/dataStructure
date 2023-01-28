package datastructure_java.datastructure.graph;


import datastructure_java.datastructure.list.LinkedList;
import datastructure_java.datastructure.list.LinkedList.Node;
import datastructure_java.datastructure.queue.ArrayQueue;
import datastructure_java.datastructure.stack.ArrayStack;

public class Graph {

	
	//연결리스트를 통한 그래프 구현... 무방향그래프로 한다.
	private LinkedList [] graph; // List<LinkedList> 로 해도 됨.
	
	//그래프 초기화.
	public Graph(int size) {
		
		this.graph = new LinkedList[size];
		
		for(int i = 0; i < size; i++) {
			LinkedList list = new LinkedList();
			graph[i] = list;
		}
	}
	
	//데이터 삽입.
	public void addEdge(int x, int y) {
		
		LinkedList xList = this.graph[x];
		LinkedList yList = this.graph[y];
		
		xList.append(y);
		yList.append(x);
		
	}
	
	//그래프 탐색.. BFS => 큐를 이용한다.
	public void BFS(int start) {
		
		//방문을 체크할 변수 생성.
		boolean [] visited = new boolean[this.graph.length];
		
		//미리 만들어 둔 큐 클래스 이용. java.util의 Queue 인터페이스를 이용해도 동일함.
		ArrayQueue queue = new ArrayQueue(this.graph.length);
		queue.enqueue(start);
		visited[start] = true; //시작 간선 방문처리.
		
		while(!queue.isEmpty()) {
			
			int current = queue.dequeue();
			System.out.println("BFS >>> "+current);
			
			//current(현재 간선)를 기준으로 해당 간선에서 갈 수 있는 간선들을 큐에 저장한다.
			LinkedList list = this.graph[current];
			Node cursor = list.getNode(0); // head
			//해당 연결리스트의 모든 노드를 큐에 담는다.
			
			//로직상 간선의 수만큼 반복문이 계속 실행되나, visited에 걸러져서 이미 방문한 곳은 제외된다.
			while(null != cursor) {
				
				if(visited[cursor.item] == false) {
					queue.enqueue(cursor.item);	
					visited[cursor.item] = true;
				}
				cursor = cursor.next;
			} //while
			
		}
	}
	
	//그래프 탐색 DFS => 스택을 이용한다.
	public void DFS(int start) {
		
		//방문을 체크할 변수 생성.
		boolean [] visited = new boolean[this.graph.length];
		visited[start] = true;
		
		//미리 구현해 둔 스택을 활용한다... java.util의 Stack과 동일.
		ArrayStack stack = new ArrayStack(this.graph.length);
		stack.push(start);
		
		while(!stack.isEmpty()) {
			
			int current = stack.top(); // 꺼내지않고 값만 확인한다.
			
			//current의 리스트를 가져와서 모두 스택에 담는다.
			LinkedList list = this.graph[current];
			Node cursor = list.getNode(0); // head
			
			//current에 연결되어 있으나 방문하지 않은 간선이 있는지 체크하는 변수.
			boolean flag = false;
			
			while(null != cursor) {
				
				if(visited[cursor.item] == false) {
					stack.push(cursor.item);
					visited[cursor.item] = true;					
					flag = true;
				}
				cursor = cursor.next;
			}
			//current에 연결된 모든 간선을 방문했다면(= 가장 깊은 곳까지 탐색했다는 의미) 이제 스택에서 값을 하나씩 꺼낸다. 
			if(!flag) {
				System.out.println("DFS >>> "+stack.pop());
			}
		}
	}
	
	//재귀를 활용한 DFS
	public void DFS2(int start) {
		
		//방문채크... 이 변수를 클래스 변수로 선언해도 된다.
		boolean [] visited = new boolean[this.graph.length];
		
		this.recursiveDFS(start, visited);
		
	}
	
	
	public void recursiveDFS(int index, boolean [] visited) {
		
		visited[index] = true;
		
		//방문하지 않은 간선 탐색.
		LinkedList list = this.graph[index];
		Node cursor = list.getNode(0);
		
		while(null != cursor) {
			
			if(visited[cursor.item] == false) {
				//방문하지 않은 간선에 대해 재귀호출.
				this.recursiveDFS(cursor.item, visited);
			}
			cursor = cursor.next;
		}
		
		//맨 마지막에 호출된 함수부터 아래 출력을 실행함. (stack과 동일)
		System.out.println("DFS(recursive) >>> "+index);
		
		
	}
	

	
	
	
	
}
