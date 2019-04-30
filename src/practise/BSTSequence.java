package practise;

import java.util.ArrayList;
import java.util.List;

public class BSTSequence {

	Node root;
	public static void main(String[] args) {
		BSTSequence bst = new BSTSequence();
		bst.root = new Node(2);
		bst.root.left = new Node(1);
		bst.root.right = new Node(3);
		List<Integer> arr= new ArrayList<>();
		bst.inOrderTraversal(bst.root , arr);
		
	}
	
private void inOrderTraversal(Node root , List arr) {
		
		if(null != root){
			visit(root , arr);
			inOrderTraversal(root.left , arr);
			inOrderTraversal(root.right , arr);
		}

}

private void visit(Node root2, List arr) {
	arr.add(root2.value);
	System.out.println(arr);
	System.out.println(root2.value);
}
}
