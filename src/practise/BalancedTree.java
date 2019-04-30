package practise;

public class BalancedTree {

	public static void main(String[] args) {
    
		Node root = new Node('a');
		Node left = new Node('b');
		Node right = new Node('c');
		root.setLeft(left);
		root.setRight(right);
		
		Node leftChildOfb = new Node('d');
		left.setLeft(leftChildOfb);
		
		leftChildOfb.setLeft(new Node('e'));
		
		
		isBalanced(root);
		
		
		
		

	}

	private static void isBalanced(Node root) {
		
		traverse(root);
		
	}

	private static void traverse(Node root ) {
		
		if(null != root){
			visit(root , root.getHeight());
			traverse(root.getLeft() );
			traverse(root.getRight());
		}
		
	}

	private static void visit(Node root , int height) {
		
		int lh = height(root.getLeft());
		int rh = height(root.getRight());
		
		if(Math.abs(lh-rh) > 1){
			System.out.println("Not Balanced");
		}
		//searchRightSubtree(root , height);
		
		
		
	}
	
	  private static int height(Node node)  
	    { 
	        /* base case tree is empty */
	        if (node == null) 
	            return 0; 
	   
	        /* If tree is not empty then height = 1 + max of left 
	         height and right heights */
	        return 1 + Math.max(height(node.getLeft()), height(node.getRight())); 
	    } 

	private static void searchLeftSubtree(Node root , int height) {
		  root = root.getLeft();
		if(root != null){
			height++;
			searchLeftSubtree(root, height);
			searchRightSubtree(root, height);
		}
		
			
		
		
	}

	private static void searchRightSubtree(Node root , int height) {
		 root = root.getRight();
		 if(root != null){
				height++;
				searchLeftSubtree(root, height);
				searchRightSubtree(root, height);
			}
	
	}

}
