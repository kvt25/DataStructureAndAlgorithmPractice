package org.datastructures.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
	public Node root;

	/*
	 * 2. size()
	 * Use Stack for iterative solution	
	 */
	public int size(Node rootNode) {
		if(rootNode == null) {
			return 0;
		} else {
			if(rootNode.left == null && rootNode.right == null) {
				return 1;
			} else {
				return 1 + size(rootNode.left) + size(rootNode.right);
			}
		}
	}
	public int sizeIteration(Node rootNode) {
		Deque<Node> nodes = new LinkedList<>();
		nodes.push(rootNode);
		int size = 0;
		while(!nodes.isEmpty()) {
			size++;
			Node node = nodes.pop();
			if(node.left != null) {
				nodes.push(node.left);
			}
			if(node.right != null) {
				nodes.push(node.right);
			}
		}
		return size;
	}
	
	/*
	 * 3. maxDepth()
	 * Use Queue for iterative solution
	 */
	public int maxDepth(Node rootNode) {
		if(rootNode == null) {
			return 0;
		} else {
			if(rootNode.left == null && rootNode.right == null) {
				return 1;
			} else {
				int leftDepth = 1 + maxDepth(rootNode.left);
				int rightDepth = 1 + maxDepth(rootNode.right);
				
				return leftDepth > rightDepth ? leftDepth : rightDepth;
			}
		}
	}
	public int maxDepthIteration(Node rootNode) {
		Deque<Node> nodes = new ArrayDeque<>();
		nodes.push(rootNode);
		int maxDepth = 0;
		int nodesCount = 0;
		nodes.add(rootNode);
		while(true) {
			nodesCount = nodes.size();
			
			if(nodesCount == 0) {
				return maxDepth;
			}
				
			maxDepth++;
			while(nodesCount > 0) {
				Node aNode = nodes.poll();
				if(aNode.left != null) {
					nodes.add(aNode.left);
				}
				if(aNode.right != null) {
					nodes.add(aNode.right);
				}
				nodesCount--;
			}
		}
	}
	
	/*
	 * 4. minValue()
	 */
	public int minValue(Node rootNode) {
		if(rootNode == null) {
			return 0;
		} else {
			if(rootNode.left == null) {
				return rootNode.data;
			} else {
				return minValue(rootNode.left);
			}
		}
	}
	public int minValueIteration(Node rootNode) {
		int minValue = 0;
		Deque<Node> nodes = new LinkedList<>();
		nodes.push(rootNode);
		while(!nodes.isEmpty()) {
			Node node = nodes.pop();
			if(node.left != null) {
				nodes.push(node.left);
			} else {
				minValue = node.data;
			}
		}
		return minValue;
	}
	
	/*
	 * 5. printTree(): inOrder traversal
	 * Use Stack for iterative solution
	 */
	public void printTree(Node rootNode) {
		if(rootNode == null) {
			return;
		} else if (rootNode.left == null && rootNode.right == null) {
			System.out.print(rootNode.data + " ");
		} else {
			printTree(rootNode.left);
			System.out.print(rootNode.data + " ");
			printTree(rootNode.right);
		}
	}
	public void printTreeIteration(Node rootNode) {
		Deque<Node> nodes = new LinkedList<>();
		Node currentNode = rootNode;
		while(currentNode != null || !nodes.isEmpty()) {
			while(currentNode != null) {
				nodes.push(currentNode);
				currentNode = currentNode.left;
			}
			Node aNode = nodes.pop();
			System.out.print(aNode.data + " ");
			currentNode = aNode.right;
		}
	}
	
	/*
	 * 6. printTree(): inOrder traversal
	 */
	public void printTreePostorder(Node rootNode) {
		if(rootNode == null) {
			return;
		} else if (rootNode.left == null && rootNode.right == null) {
			System.out.print(rootNode.data + " ");
		} else {
			printTreePostorder(rootNode.left);
			printTreePostorder(rootNode.right);
			System.out.print(rootNode.data + " ");
		}
	}
	
	/*
	 * 7. hasPathSum()
	 */
	public boolean hasPathSum2(Node rootNode, int sum) {
		if(rootNode == null) {
			return sum == 0;
		} else {
			return hasPathSum2(rootNode.left, sum - rootNode.data) || hasPathSum2(rootNode.right, sum - rootNode.data);
		}
	}
	public boolean hasPathSum(Node rootNode, int sum) {
		List<Node> path = new ArrayList<>();
		
		if(checkPathEqualsToSum(rootNode, path, sum)) {
			printPath(path);
			return true;
		}
		return false;
	}
	private boolean checkPathEqualsToSum(Node rootNode, List<Node> path, int sum) {
		if(rootNode == null) {
			return false;
		} 
		
		if(rootNode.left == null && rootNode.right == null) {
			if(calculatePathSum(path) + rootNode.data == sum) {
				path.add(rootNode);
				return true;
			} else {
				return false;
			}
		} else {
			path.add(rootNode);
			if(checkPathEqualsToSum(rootNode.left, path, sum)) {
				return true;
			} else {
				return checkPathEqualsToSum(rootNode.right, path, sum);
			}
		}
		
	}
	private void printPath(List<Node> path) {
		for(Node n : path) {
			System.out.print(n.data + " ");
		}
	}
	private int calculatePathSum(List<Node> path) {
		int sum = 0;
		for(Node n : path) {
			sum += n.data;
		}
		return sum;
	}
	// Array implementation
	public boolean hasPathSumArray(Node rootNode, int sum) {
		Node[] path = new Node[100];
		
		if(checkPathEqualsToSumArray(rootNode, path, 0, sum)) {
			printPathArray(path);
			return true;
		}
		return false;
	}
	private boolean checkPathEqualsToSumArray(Node rootNode, Node[] path, int pathLength, int sum) {
		if(rootNode == null) {
			return false;
		} 
		
		path[pathLength] = rootNode;
		pathLength++;
		if(rootNode.left == null && rootNode.right == null) {
			return calculatePathSumArray(path) == sum;
		} else {
			if(checkPathEqualsToSumArray(rootNode.left, path, pathLength, sum)) {
				return true;
			} else {
				return checkPathEqualsToSumArray(rootNode.right, path, pathLength, sum);
			}
		}
		
	}
	private void printPathArray(Node[] path) {
		for(Node n : path) {
			if(n==null) {
				break;
			}
			System.out.print(n.data + " ");
		}
		System.out.println();
	}
	private int calculatePathSumArray(Node[] path) {
		int sum = 0;
		for(Node n : path) {
			if(n==null) {
				break;
			}
			sum += n.data;
		}
		return sum;
	}
	
	/*
	 * 8. printPaths()
	 */
	public void printAllPaths() {
		Node[] path = new Node[100];
		printAppPathsRecursive(this.root, path, 0);
	}
	private void printAppPathsRecursive(Node rootNode, Node[] path, int pathLength) {
		if(rootNode == null) {
			return;
		}
		path[pathLength] = rootNode;
		pathLength++;
		if(rootNode.left == null && rootNode.right == null) {
			printPathArray(path, pathLength);
		} else {
			printAppPathsRecursive(rootNode.left, path, pathLength);
			printAppPathsRecursive(rootNode.right, path, pathLength);
		}
	}
	private void printPathArray(Node[] path, int pathLength) {
		for(int i=0; i < pathLength; i++) {
			System.out.print(path[i].data + " ");
		}
		System.out.println();
	}
	
	/*
	 * 9. mirror()
	 */
	public void mirror(Node rootNode) {
		if(rootNode == null) {
			return;
		}
		if(rootNode.left != null || rootNode.right != null) {
			swapLeftRightNodes(rootNode);
			mirror(rootNode.left);
			mirror(rootNode.right);
		}
	}
	private void swapLeftRightNodes(Node rootNode) {
		Node temp = rootNode.left;
		rootNode.left = rootNode.right;
		rootNode.right = temp;
	}
	
	/*
	 * 10. doubleTree()
	 */
	public void doubleTree(Node rootNode) {
		if(rootNode == null) {
			return;
		}
		
		Node duplicateNode = new Node(rootNode.data);
		Node curLeftNode = rootNode.left;
		rootNode.left = duplicateNode;
		duplicateNode.left = curLeftNode;
		
		doubleTree(curLeftNode);
		doubleTree(rootNode.right);
	}
}
