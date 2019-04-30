package practise;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(list);
		BST(0 , list.size()-1 , list , new Node());
	}

	public static void BST(int left , int right ,List<Integer> list, Node root) {
	
		  if(left == right){
			  root.setValue(list.get(left));
			  System.out.println("my values" + root.getValue());
		  }else{
	  int mid = 	left + (right - left)/ 2 ;
	  root.setValue(list.get(mid));
	  //BST on left
	  System.out.println("my values" + root.getValue());
	
	  if(mid-1 >= left){
		
	  BST(left , mid -1 , list , root.getLeft());
	  }
	  // BST on right
	  if(mid + 1 <= right){
		  BST(mid +1 , right ,list, root.getRight() );  
		  
	  }
	  
		
	}
	}
	

}
