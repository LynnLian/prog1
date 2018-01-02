public class
Node {

	private double frequency;
	private Node parentNode;
	private Node trueNode;
	private Node falseNode;
	private char symbol; 

	public Node(double frequency, char symbol) {
		this.frequency = frequency;
		this.symbol = symbol;
	}

	public Node(Node trueNode, Node falseNode, Node parentNode) {
		
	}
	
	public Node(Node trueNode, Node falseNode) {
		this.trueNode = trueNode;
		this.falseNode = falseNode;
		this.frequency = trueNode.getFrequency() + falseNode.getFrequency();
		
	}
	public double getFrequency() {
		return this.frequency;
	}
	
	// Get a boolean representing 0 or 1 and return the corresponding child node
	public Node getNode(boolean nodeType) {
		return nodeType ? trueNode : falseNode;
	}
	
	public Node[] getChildNodes() {
		Node[] childNodes = null;
		
		if(this.falseNode != null) {
			childNodes = new Node[2]; 
			childNodes[0] = falseNode;
			childNodes[1] = trueNode;
		}
		return childNodes;
	}
	
	public String toString() {
		
		return "Parent: " + String.valueOf(getFrequency()); 
				
	}
	
	// Just an attempt to print, doesn't look very good
	public void print() {
		Node[] children = getChildNodes();
		if(children != null) {
			System.out.println("--" + children[0].frequency + "--");
			System.out.println("--" + children[1].frequency + "--");
			children[0].print();
			children[1].print();
		}
		else {
			System.out.println("--" + this.frequency + "--" + this.symbol + "\n");
		}
	}
}
