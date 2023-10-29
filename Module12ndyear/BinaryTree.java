package TestClassPackage;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class BinaryTree {
	
	//Node class of data members/attributes
	
	    private Node root;

	    public Node getRoot() {
	        return root;
	    }

	    public BinaryTree() {
	        root = null;
	    }
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public Node add(Node node, int data) {
		if(isEmpty()) {
			root = new Node(data);
		}else {
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			
			while(!q.isEmpty()) {
				node = q.peek();
				q.remove();
				if(node.getLeft() == null) {
					node.setLeft(new Node(data));
					break;
				}else q.add(node.getLeft());
				
				if (node.getRight() == null) {
					node.setRight (new Node(data));
					break;
				}else q.add(node.getRight());
			}//end of loop
		}//end of if
		return root;
	}//end of method
	public String printLevelOrder() {
		return printLevelOrder(root);
	}
	
	public String printLevelOrder(Node node) {
		String hold = "";
		if(node == null)
			hold = "Tree is empty";
		else {
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			while(!q.isEmpty()) {
				Node newNode = q.poll();
				
				hold+=newNode.getData()+" ";
				if(newNode.getLeft()!=null)
					q.add(newNode.getLeft());
				if(newNode.getRight()!=null)
					q.add(newNode.getRight());
			}//end of while loop
		}//end of if
		return hold;
	}//end of method
	public void addNode(int data) {
		root = add(root,data);
	}
	public int count () {
		return count (root);
		
	}
	private int count (Node node ) {
		if(node == null) {
			return 0;
		} else {
			int ctr = 1;
			ctr+= count (node.getLeft());
			ctr+= count (node.getRight());
			return ctr;
		}
	}
	public String printInOrder (Node node) {
		String hold = "";
		if(node == null) {
			return "Tree is empty";
		} else {
			Stack<Node> s = new Stack<Node>();
			Node newnode = node;
			while(!s.isEmpty()|| newnode!=null) {
				if(newnode!=null) {
					s.push(newnode);
					newnode = newnode.getLeft();
				} else {
					Node value = s.pop();
					hold+=value.getData() + " ";
					newnode = value.getRight();
				}
			}
			return hold;
		}
	}
	public String printInOrder() {
		return inOrder(root);
		
	}
	
	public String inOrder(Node node) {
		if(node!=null)
			return inOrder(node.getLeft())+node.getData()
			+" "+inOrder(node.getRight());
		else return "";
	}//end of method
	public String levelOrder() {
		return printLevelOrder(root);
		
	}
	public String traverseLevelOrder() {
		return printLevelOrder(root);
	}
	public String PreOrder() {
		return printPreOrder(root);
	}
	
	public String printPreOrder() {
		return printPreOrder(root);
	}
	
	public String printPreOrder(Node node) {
		if(node != null) {
			String result = node.getData() + " " + printPreOrder(node.getLeft()) + printPreOrder(node.getRight());
			return result;
		}else {
			return "";
		}
	}
	
	//Post-Order
	public String printPostOrder() {
		return printPostOrder(root);
	}
	
	public String printPostOrder(Node node) {
		if(node != null) {
			String result = printPostOrder(node.getLeft()) + printPostOrder(node.getRight()) + node.getData() + " ";
			return result;
		}else {
			return "";
		}
	}
	public boolean search(int val) {
		if(isEmpty()) {
			return false;
		}else {
			return search(root, val);
		}
	}
	
	private boolean search(Node node, int val) {
		if(node.getData() == val) {
			return true;
		}
		if(node.getLeft() != null) {
			if(search(node.getLeft(), val)) {
				return true;
			}
		}
		if(node.getRight() != null) {
			if(search(node.getRight(), val)) {
				return true;
			}
		}
		return false;
	}
	
	//cut the tree
	public void cutTheTree() {
		root = null;
	}

	public String printParents() {
		return printParents(root);
	}
	private String printParents(Node node) {
		StringBuilder sb = new StringBuilder();
		if(node == null) {
			return sb.toString();
		}
		if(node.getLeft()!=null || node.getRight() != null) {
			sb.append(node.getData()).append(" ");
		}
		sb.append(printParents(node.getLeft()));
		sb.append(printParents(node.getRight()));
		return sb.toString();
	}
	
	//Setting up for the leaves
	public String printLeaves() {
		return printLeaves(root);
	}
	public String printLeaves(Node node ) {
		StringBuilder sb = new StringBuilder();
		if(node == null) {
			return sb.toString();
		}
		if(node.getLeft() == null && node.getRight() == null) {
			sb.append(node.getData()).append(" ");
		}
		sb.append(printLeaves(node.getLeft()));
		sb.append(printLeaves(node.getRight()));
		return sb.toString();
	}
	//method for height
	public int height() {
		return height(root);
	}
	private int height(Node node) {
		if(node == null) {
			return 0;
		}
		int leftheight = height(node.getLeft());
		int rightheight = height(node.getRight());
		
		return Math.max(leftheight, rightheight) + 1;
	}
	// method for depth
	 public int depth() {return getDepth(root);}

	    public int getDepth(Node root) {
	        if (root == null) {
	            return 0;
	        } else {
	            int leftDepth = getDepth(root.getLeft());
	            int rightDepth = getDepth(root.getRight());
	            return Math.max(leftDepth, rightDepth) + 1;
	        }
	    }
	    //setting up the display
	    public int displayLevels(Node root) {
	        if (root == null) {
	            return  0;
	        }

	        Queue<Node> queue = new LinkedList<>();
	        queue.add(root);

	        int currentLevel = 0;
	        int nodesInCurrentLevel = 1;
	        int nodesInNextLevel = 0;

	        while (!queue.isEmpty()) {
	            Node currentNode = queue.poll();
	            nodesInCurrentLevel--;

	            System.out.println("Node " + currentNode.getData() + " is at level " + currentLevel);

	            if (currentNode.getLeft() != null) {
	                queue.add(currentNode.getLeft());
	                nodesInNextLevel++;
	            }
	            if (currentNode.getRight() != null) {
	                queue.add(currentNode.getRight());
	                nodesInNextLevel++;
	            }

	            if (nodesInCurrentLevel == 0) {
	                nodesInCurrentLevel = nodesInNextLevel;
	                nodesInNextLevel = 0;
	                currentLevel++;
	            }
	        }

	        return currentLevel;

	    }
	    public int level() {return displayLevels(root);
	    }
	    //Complete tree
	    public boolean isCompleteTree(Node root) {
	        if (root == null) {
	            return true;
	        }

	        Queue<Node> queue = new LinkedList<>();
	        queue.add(root);
	        boolean lastLevel = false;

	        while (!queue.isEmpty()) {
	            Node current = queue.poll();

	            if (current != null) {
	                if (lastLevel) {
	                    return false;
	                }

	                queue.add(current.getLeft());
	                queue.add(current.getRight());
	            } else {
	                lastLevel = true;
	            }
	        }

	        return true;
	    }
	    //Complete tree
	    public boolean completetree() {return isCompleteTree(root);}
	    //Setting up the tree type
	    public String treeType(){
	       if (fullTree()){
	            return "Full Tree";
	        } else if (completetree()){
	            return "Complete Tree";
	        } else {
	            return "";
	        }
	    }

	    //FullTree
	    public boolean isFullTree(Node root) {
	        if (root == null)
	            return true;

	        if (root.getLeft() == null && root.getRight() == null)
	            return true;

	        if ((root.getLeft()) != null && (root.getRight() != null))
	            return isFullTree(root.getLeft()) && isFullTree(root.getRight());

	        return false;
	    }

	    public boolean fullTree() {return isFullTree(root);
	    }
	    //Setting up the remove node
	    public void remove(int value){
	    	removenode(root,value);
	    }
	    
	    public static void removenode(Node root, int key)
	    {
	        if (root == null)
	            return;

	        if (root.getLeft() == null && root.getRight() == null) {
	            if (root.getData() == key) {
	                root = null;
	                return;
	            }
	            else
	                return;
	        }

	        Queue<Node> q = new LinkedList<Node>();
	        q.add(root);
	        Node temp = null, keyNode = null;

	        // Do level order traversal until
	        // we find key and last node.
	        while (!q.isEmpty()) {
	            temp = q.peek();
	            q.remove();

	            if (temp.getData() == key)
	                keyNode = temp;

	            if (temp.getLeft() != null)
	                q.add(temp.getLeft());

	            if (temp.getRight() != null)
	                q.add(temp.getRight());
	        }

	        if (keyNode != null) {
	            int x = temp.getData();
	            delnode(root, temp);
	            keyNode.setData(x) ;
	        }
	    }
	    public static void delnode(Node root, Node delNode)
	    {
	        Queue<Node> q = new LinkedList<Node>();
	        q.add(root);

	        Node temp = new Node();

	        // Do level order traversal until last node
	        while (!q.isEmpty()) {
	            temp = q.peek();
	            q.remove();

	            if (temp == delNode) {
	                temp = null;
	                return;
	            }
	            if (temp.getRight() != null) {
	                if (temp.getRight() == delNode) {
	                    temp.setRight(null) ;
	                    return;
	                }
	                else
	                    q.add(temp.getRight());
	            }

	            if (temp.getLeft() != null) {
	                if (temp.getLeft() == delNode) {
	                    temp.setLeft(null);
	                    return;
	                }
	                else
	                    q.add(temp.getLeft());
	            }
	        }
	    }

}//end of class