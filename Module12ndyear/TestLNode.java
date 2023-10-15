package Module12ndyear;

public class TestLNode {

	public static void main(String[] args) {
		LNode<Object>node = new LNode<>();
		
		node.addAtPosition(13, 0);
		node.addAtPosition(45,0);
		node.addAtPosition(8, 3);
		node.deleteValue(36);
		
		System.out.println(node.traverse());
	}
}
