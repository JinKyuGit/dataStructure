package datastructure_java.datastructure.binaryTree;

import datastructure_java.datastructure.binaryTree.BinaryTree.Node;

public class BinaryTreeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree tree = new BinaryTree();
		
		tree.insert2(10);
		tree.insert2(5);
		tree.insert2(15);
		tree.insert2(7);
		tree.insert2(20);
		tree.insert2(13);
		tree.insert2(14);
		tree.insert2(19);
		tree.insert2(17);
		
		tree.preOrder(tree.root);
		System.out.println();
		
	    //Node node = tree.search(tree.root, 7);
	    //System.out.println(node.item);
	    
		tree.delete3(15);
		tree.preOrder(tree.root);

	}

}
