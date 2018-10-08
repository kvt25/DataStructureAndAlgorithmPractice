package org.datastructures.binarytree;

public class BinaryMainApp {

	public static void main(String args[])  
    { 
		int option = 7;
        BinaryTree tree = initializeTree();
        System.out.println("http://cslibrary.stanford.edu/110/BinaryTrees.html");
        System.out.println("Choose the number to run below functions:");
        System.out.println("2. size()");
        System.out.println("3. maxDepth()");
        System.out.println("4. minValue()");
        System.out.println("5. printTree() : inOrder traversal");
        System.out.println("6. printTree() : postOrder traversal");
        System.out.println("7. hasPathSum()");
        System.out.println("8. printPaths()");
        System.out.println("9. mirror()");
        System.out.println("10. doubleTree()");
        
        switch(option) {
        case 2:
        	problem2(tree);
        	break;
        case 3:
        	problem3(tree);
        	break;
        case 4:
        	problem4(tree);
        	break;
        case 5:
        	problem5(tree);
        	break;
        case 6:
        	problem6(tree);
        	break;
        case 7:
        	problem7(tree);
        	break;
        case 8:
        	problem8(tree);
        	break;
        case 9:
        	problem9(tree);
        	break;
        case 10:
        	problem10(tree);
        	break;
        default:
        	
        }
    }

	private static void problem10(BinaryTree tree) {
		tree.printAllPaths();
        tree.doubleTree(tree.root);
        tree.printAllPaths();
	}

	private static void problem9(BinaryTree tree) {
		tree.printAllPaths();
        tree.mirror(tree.root);
        tree.printAllPaths();
	}

	private static void problem8(BinaryTree tree) {
		 tree.printAllPaths();
	}
	
	private static void problem7(BinaryTree tree) {
		int sum = 29;
        System.out.println("\nhasPathSum equals to " + sum);
        System.out.println(tree.hasPathSum(tree.root, sum));
        System.out.println(tree.hasPathSumArray(tree.root, sum));
        
        System.out.println("\nhasPathSum2 equals to " + sum);
        System.out.println(tree.hasPathSum2(tree.root, sum));
	}

	private static void problem6(BinaryTree tree) {
		System.out.println("\npostOrder traversal:");
        tree.printTreePostorder(tree.root);
	}

	private static void problem5(BinaryTree tree) {
		System.out.println("inOrder traversal:");
        tree.printTree(tree.root);
        System.out.println("\ninOrder traversal iteration:");
        tree.printTreeIteration(tree.root);
	}

	private static void problem4(BinaryTree tree) {
		System.out.println(tree.minValue(tree.root));
        System.out.println(tree.minValueIteration(tree.root));
	}

	private static void problem3(BinaryTree tree) {
		System.out.println(tree.maxDepth(tree.root));
        System.out.println(tree.maxDepthIteration(tree.root));
	}

	private static void problem2(BinaryTree tree) {
		System.out.println(tree.size(tree.root));
        System.out.println(tree.sizeIteration(tree.root));
	}

	private static BinaryTree initializeTree() {
		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(6);
        tree.root.right.left = new Node(9); 
        tree.root.right.right = new Node(15);
        tree.root.right.left.right = new Node(7);
		return tree;
	} 

}
