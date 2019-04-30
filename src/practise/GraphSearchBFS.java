package practise;

public class GraphSearchBFS {

	Node prev = null;
	Node root = null;
	int first = 28;
	int second =28;
	boolean found = false;
	public static void main(String[] args) {
		GraphSearchBFS tree = new GraphSearchBFS(); 
		tree.root = new Node(4); 
		
		tree.root.right = new Node(5); 
		tree.root.right.left = new Node(10); 
		tree.root.right.right = new Node(15); 
		tree.root.right.right.left = new Node(28);
		tree.root.right.right.right = new Node(30);
		
		
		tree.root.left = new Node(2); 
		tree.root.left.left = new Node(1); 
		tree.root.left.right = new Node(3); 
		tree.root.left.right.left = new Node(45); 
		tree.root.left.right.right = new Node(50); 
		
		
		
		
		tree.inOrderTraversal(tree.root , null);
		if(!tree.found){
			System.out.println("No Ancestor exists");
		}
	
		
		
		
	}
	private void inOrderTraversal(Node root , Node prev) {
		
		if(null != root){
			visit(root , prev);
			inOrderTraversal(root.left , root);
			inOrderTraversal(root.right , root);
		}
		
		
		
	}
	private void visit(Node root , Node prev) {
		

		root.prev = prev;
		if(null != root.prev){
			System.out.println(root.prev.value + "<<<<----" + root.value);
		}
		
		if(root.value == first){
			Node fetch = root;
			while(null !=fetch){
				if(fetch.visited){
					found = true;
					System.out.println("first common anscestor--->>> " + fetch.value);
				break;
					
				}else{
					fetch.visited = true;
					fetch = fetch.prev;
				}
			}
		}
		
		if(root.value == second){
			Node fetch = root;
			while(null !=fetch){
				if(fetch.visited){
					System.out.println("first common anscestor--->>> " + fetch.value);
					found = true;
					break;
				}else{
					fetch.visited = true;
					fetch = fetch.prev;
				}
			}
		}
		
		
	}

}
