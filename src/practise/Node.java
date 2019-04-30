package practise;

public class Node {
	
	
	Node left;
	Node right;
	int height;
	int value;
	char letter;
	Node next;
	Node prev;
	Node parent;
	boolean visited;
	
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Node(int value) {
		super();
		this.value = value;
	}
	
	

	public Node(char letter) {
		super();
		this.letter = letter;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public Node(Node left, Node right, int value) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	

}
