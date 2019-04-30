package practise;

import java.util.HashMap;

public class BinarySearchColumnSolution {
	
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(7);
		root.right.right = new Node(6);
		//column , counter
		HashMap<Integer, Integer> columnCounterMap= new HashMap<>();
		int columnCount = 0 ;
		columnCounterMap.put(columnCount , root.value);
		BST(root.left , columnCounterMap , columnCount - 1 );
		BST(root.right , columnCounterMap , columnCount + 1);
		
		System.out.println(columnCounterMap);
		
	}

	private static void BST(Node root , HashMap<Integer, Integer> columnCounterMap , int columnCount) {
		
		if(null != root){
			if(columnCounterMap.containsKey(columnCount)){
				int value = columnCounterMap.get(columnCount);
				columnCounterMap.put(columnCount, value + root.value);
			}else{
				columnCounterMap.put(columnCount, root.value);
			}
			
			BST(root.left, columnCounterMap, columnCount-1);
			BST(root.right, columnCounterMap, columnCount + 1);
		}
		
		
		
	}

}
