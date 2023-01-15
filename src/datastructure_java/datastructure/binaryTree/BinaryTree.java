package datastructure_java.datastructure.binaryTree;

public class BinaryTree {
	
	//이진트리 
	public class Node {
		public int item;
		public Node left;
		public Node right;
	}
	
	//생성자.
	public BinaryTree() {
		this.root = null;
	}
	
	public Node root; // 루트 노드에 대한 포인터.
	
	//순회
	public void preOrder(Node node) {
		if(null != node) {
			System.out.println("data : "+node.item);
			this.preOrder(node.left);
			this.preOrder(node.right);
		}
	}
	
	public void inOrder(Node node) {
		if(null != node) {
			this.inOrder(node.left);
			System.out.println("data : "+node.item);
			this.inOrder(node.right);
		}
	}
	
	public void postOrder(Node node) {
		if(null != node) {
			this.postOrder(node.left);
			this.postOrder(node.right);
			System.out.println("data : "+node.item);
		}
	}
	
	
	//삽입1 - 재귀적 방법.
	public void insert(int data) {
	     this.root = this.insertItem(this.root, data);
	}
	
	public Node insertItem(Node parent, int data) {
		/*
		 * data와 기존 노드의 대소비교를 통해(탐색)
		 * 적절한 자리를 찾는 과정을 재귀적으로 함.
		 * 이 과정을 통해 기존 left, right는 다시 똑같이 지정됨.
		 */
		if(null == parent) {
			Node newNode = new Node();
			newNode.item = data;
			newNode.left = null;
			newNode.right = null;
			return newNode;
		}else if(data < parent.item) {
			parent.left = this.insertItem(parent.left, data);
			return parent;
		}else {
			parent.right = this.insertItem(parent.right, data);
			return parent;
		}
		
	}
	
	
	//삽입2 - 비재귀적 방법.
	public void insert2(int data) {
		
		Node newNode = new Node();
		newNode.item = data;
		newNode.left = null;
		newNode.right = null;
		
		if(null == this.root) {
			this.root = newNode;
		}else {
			
			Node node = this.root;
			Node parent = null;
			while(null != node) {
				
				parent = node;
				
				if(data < node.item) {
					node = node.left;
				}else {
					node = node.right;
				}
			}
			//반복이 끝난 후 parent가 새 노드의 부모.
			if(data < parent.item) {
				parent.left = newNode;
			}else {
				parent.right = newNode;
			}
		}
	}
	
	//검색. 
	public Node search(Node node, int target) {
		
		if(null == node || node.item == target) {
			return node;
		}else if(target < node.item) {
			return this.search(node.left, target);
		}else {
			return this.search(node.right, target);
		}
		
	}
	
	//삭제.
	public void delete(int target) {	
		
		//1. 삭제할 노드와 그 부모를 구한다.
		Node rootParent = new Node();
		rootParent.left = this.root;
		
		Node parent = rootParent;
		Node child = rootParent.left;
		String direct = "L";
		
		while(null != child) {
			
			if(target == child.item) {
				break;
			}else {
				parent = child;
				if(target < parent.item) {
					child = parent.left;
					direct = "L";
				}else {
					child = parent.right;
					direct = "R";
				}
			}
		}
		//예외처리 - child가 null일 경우(타겟없음)
		if(null == child) {
			System.out.println("item not found");
			return;
		}
		
		/*
		 * 삭제할 노드의 성격에 따른 분기.
		 * 1. 루트 노드인 경우
		 * 2. 루트 노드가 아닌 경우
		 *  1) 삭제할 노드의 자식이 없는 경우
		 *  2) 삭제할 노드의 자식이 1개인 경우
		 *  3) 삭제할 노드의 자식이 2개인 경우 
		 */
		
		if(null == child.left && null == child.right) {
			//이 경우 부모의 레퍼런스를 해제한다.
			if("L".equals(direct)) {
				parent.left = null;
			}else {
				parent.right = null;
			}		
			//루트인 경우.
			if(this.root == child) {
				this.root = null;
			}
			
		}else if( (null != child.left && null == child.right) || (null == child.left && null != child.right) ) {
			
			//삭제할 노드의 자식을 삭제할 노드의 부모에 연결.
			if("L".equals(direct)) {
				parent.left = (null != child.left)? child.left : child.right;
			}else {
				parent.right = (null != child.left)? child.left : child.right;
			}	
			//루트인 경우
			if(this.root == child) {
				this.root = (null != child.left)? child.left : child.right;
			}
			
		}else {
			//자식이 2개인 경우.
			//대체할 노드를 찾아야 함. 왼쪽 자식 중 가장 큰 노드 혹은 오른쪽 자식 중 가장 작은 노드.
		    
			Node replaceNodeParent = child;
			Node replaceNode = replaceNodeParent.left;
			
			//탐색.
			while(null != replaceNode.left) {
				
				replaceNodeParent = replaceNode;
				replaceNode = replaceNodeParent.left;
				
			}
			//만약 replaceNode에 자식이 있는 경우(논리상 왼쪽 자식은 없다) -> replaceNodeParent의 왼쪽에 달아줌.
			if(null != replaceNode.right) {
				replaceNodeParent.left = replaceNode.right;
			}else {
				//자식이 없는 경우기에 대체노드 부모의 대체노드 레퍼런스를 삭제.
				replaceNodeParent.left = null;
			}
			
			//삭제할 노드와 대체할 노드를 교환한다.
			if("L".equals(direct)) {
				parent.left = replaceNode;
			}else {
				parent.right = replaceNode;
			}
			
			replaceNode.left = child.left;
			replaceNode.right = child.right;
			
			//이제 child는 참조가 없으므로 메모리에서 해제된다.
			
			//루트인 경우
			if(this.root == child) {
				this.root = replaceNode;
			}
		}
	}
	



}
