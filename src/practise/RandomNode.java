package practise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RandomNode {

	List<Node> ran = new ArrayList<>();
	Node root;
	int top = -1;
	public static void main(String[] args) {
		
		RandomNode rn = new RandomNode();
		rn.root = new Node(10);
		rn.root.left = new Node(5);
		rn.root.right = new Node(15);
		
		rn.root.left.left = new Node(2);
		rn.root.left.right = new Node(7);
		
		rn.root.right.left = new Node(12);
		rn.root.right.right = new Node(25);
		
		rn.inOrderTraversal(rn.root , rn.ran);
		Iterator<Node> it = rn.ran.iterator();
		while(it.hasNext()){ 
			System.out.print(it.next().value + " ");
			}
		System.out.println();
		System.out.println(rn.getRandomNode(rn.ran).value);
		System.out.println(rn.getRandomNode(rn.ran).value);
		System.out.println(rn.getRandomNode(rn.ran).value);
		System.out.println(rn.getRandomNode(rn.ran).value);
		System.out.println(rn.getRandomNode(rn.ran).value);
		System.out.println(rn.getRandomNode(rn.ran).value);
		System.out.println(rn.getRandomNode(rn.ran).value);
		System.out.println(rn.getRandomNode(rn.ran).value);
		System.out.println(rn.getRandomNode(rn.ran).value);
		System.out.println(rn.getRandomNode(rn.ran).value);
		
		if(rn.delete(new Node(15) , rn.root , rn)){
			System.out.println("Successfully deleted!!!");
		}
		
		System.out.println(rn.root.right == null);
		
		System.out.println(rn.ran.get(4).value);

	}
	private void inOrderTraversal(Node root , List<Node> ran) {
		
		if(null !=root ){
		System.out.println(root);
		ran.add(root);
		inOrderTraversal(root.left, ran);
		inOrderTraversal(root.right, ran);
		}
	}
	
	private Node getRandomNode(List<Node> ran){
		
		int index = (int)Math.floor(Math.random() * ran.size());
		System.out.println("index--->>" + index);
		
		return ran.get(index);
	}
	
	
	private boolean delete(Node delete , Node root , RandomNode rn ){
		if(null != root){
			return traverse(root , root, delete , rn);
			 
		}else{
			return false;
		}
		
	}
	private boolean traverse(Node prev ,Node root , Node delete , RandomNode rn) {
		
		if(root.value == delete.value){
			
			return true;
		}else if (delete.value > root.value){
			
		 return	traverse(root ,root.right , delete , rn);
		}else{
		return	traverse(root ,root.left , delete , rn);
		}
	}


}
