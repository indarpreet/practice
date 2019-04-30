package practise;

public class InOrderSuccessor {
	Node root; 
	 Node prev ;
	
	
	
	
	public static void main(String[] args) {
		InOrderSuccessor tree = new InOrderSuccessor(); 
		tree.root = new Node(4); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(1); 
		tree.root.left.right = new Node(3); 
		int value = 1;
		if(tree.InOrderTraversal(tree.root , value)){
			System.out.println("NOt Found");
		}else{
			System.out.println("Founded");
		}
		System.out.println(tree.root);
	}




	private boolean InOrderTraversal(Node root , int value) {
	
		if(null != root){
			InOrderTraversal(root.left , value);
			if(!visit(root , value)){
				return false;
			}
			InOrderTraversal(root.right , value);
		}
		
		return true;
	}




	private  boolean visit(Node root2 , int inOrderValue) {
		if(null !=prev){
			root2.prev = prev;
			prev = root2;
		}else{
			prev = root2;
		}
		System.out.println(root2.value);
		if(null != root2.prev){
		if(root2.prev.value == inOrderValue){
			System.out.println("Inorder Successor of "+inOrderValue +" is ---- >>>" + root2.value);
			return false;
		}
		}
		return true;
	}
}
