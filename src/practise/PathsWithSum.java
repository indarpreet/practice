package practise;

import java.util.ArrayList;
import java.util.List;

public class PathsWithSum {
      PathsWithSum root;
      int valueToFind = 5;
	public static void main(String[] args) {
		List<Node> paths = new ArrayList<>();
		PathsWithSum path = new PathsWithSum();
		Node root = path.createTree();
		path.preOrderTraversal(null , root , paths);
		System.out.println(paths);
		
		path.findTheSumOfThePaths(path.valueToFind , paths);

	}
	
	
	private void findTheSumOfThePaths(int valueToFind, List<Node> paths) {
		for(Node node : paths){
			if(node.value == valueToFind){
				System.out.println("--->>>"+ node.value);
			}
			StringBuilder sb = new StringBuilder();
			checkForPaths(node , node.value , valueToFind , sb.append(node.value + "---->"));
		}
		
	}


	private void checkForPaths(Node node  , int value , int valueToFind , StringBuilder sb) {
		
		if(null != node.parent ){
			value = value + node.parent.value;
			sb.append(node.parent.value + "---->");
			if(valueToFind == value){
				System.out.println(sb.toString());
			}
			checkForPaths(node.parent, value , valueToFind , sb);
		}
		
	}


	public void preOrderTraversal( Node parent ,Node root , List<Node> paths){
		
		if(null != root){
			visit(parent , root , paths);
			preOrderTraversal(root , root.left , paths);
			preOrderTraversal(root , root.right , paths);
		}
		
	}
	public void visit(Node parent , Node root , List<Node> paths) {
	
		root.parent = parent;
		paths.add(root);
		
	}


	public Node createTree(){
		
		Node root = new Node(10);
		 root.left = new Node(1);
		root.right = new Node(3);
		
		root.left.left = new Node(-6);
		root.left.right = new Node(-3);
		
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(-3);
		
		root.right.left = new Node(6);
		root.right.right = new Node(2);
		
		root.right.right.left = new Node(9);
		root.right.right.right = new Node(10);
		
		return root;
	}

}
