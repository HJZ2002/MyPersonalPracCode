package TestClassPackage;

public class TestBinaryTree {

	public static void main(String[] args) {
		
		System.out.println("Test run by: Hosea James Zacarias");
		 BinaryTree tree = new BinaryTree();
	        System.out.println("--- Before Adding Nodes ---");
	        System.out.println("Empty: " + tree.isEmpty());
	        System.out.println("Number of nodes: " + tree.count());
	        System.out.println("Level order: " + tree.printLevelOrder());

	        // Adding tree nodes
	        tree.addNode(12);
	        tree.addNode(40);
	        tree.addNode(50);

	        System.out.println("--- After Adding Nodes ---");
	        System.out.println("Empty: " + tree.isEmpty());
	        System.out.println("Number of nodes: " + tree.count());
	        System.out.println("Level order: " + tree.printLevelOrder());

	        tree.addNode(25);
	        tree.addNode(30);
	        tree.addNode(10);

	        System.out.println("--- After Adding few more Nodes ---");
	        System.out.println("Empty: " + tree.isEmpty());
	        System.out.println("Number of nodes: " + tree.count());
	        System.out.println("Level order: " + tree.printLevelOrder());

	        // Access the root using the getRoot() method
	        Node root = new Node();
	        root = tree.getRoot();

	        System.out.println(" " + tree.printInOrder(root));
	        System.out.println(" " + tree.printPreOrder(root));
	        System.out.println(" " + tree.printPostOrder(root));
	}
}
