package StudyAlgorithm_P;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	Node left;
	Node right;
	int val;

	Node(int val) {
		left = right = null;
		this.val = val;
	}
}

class BinarySerachTree {
	private Node root;

	public BinarySerachTree() {
		root = null;
	}

	public void add(int val) {
		Node a = root;
		if (root == null) {
			root = new Node(val);
		} else {
			while (a != null) {
				if (a.val > val) {
					if (a.left != null) {
						a = a.left;
					} else {
						a.left = new Node(val);
						break;
					}
				} else if (a.val == val) {
					System.out.println("����");
					break;
				} else {
					if (a.right != null) {
						a = a.right;
					} else {
						a.right = new Node(val);
						break;
					}
				}
			}
		}

	}

	public Boolean search(int val) {
		Node a = root;
		if (a == null)
			return false;
		else {
			while (a != null) {
				if (a.val > val) {
					a = a.left;
				} else if (a.val < val) {
					a = a.right;
				} else
					return true;
			}
			return false;
		}
	}

//	public Boolean remove(int val) {
//
//	}

	private int getkMinVal() {
		Node a = root;
		int min = a.val;
		while (a.left != null) {
			min = a.left.val;
			a = a.left;
		}
		return min;
	}

	private int getkMaxVal() {
		Node a = root;
		int max = a.val;
		while (a.right != null) {
			max = a.right.val;
			a = a.right;
		}
		return max;
	}

	public void printTree() {
		System.out.print("[Print tree]");
		System.out.printf("\nMin value: %d", getkMinVal());
		System.out.printf("\nMax value: %d", getkMaxVal());
		System.out.print("\nIn-order : ");
		printInOrder(this.root);
		System.out.print("\nPre-order : ");
		printPreOrder(this.root);
		System.out.print("\nPost-order : ");
		printPostOrder(this.root);
		System.out.print("\nLevel-order : ");
		printLevelOrder(this.root);
	}

//	���� ��ȸ(Inorder):(left, root, right)
	private void printInOrder(Node current) {
		if (current != null) {
			printInOrder(current.left);
			System.out.print(current.val + " ");
			printInOrder(current.right);
		}
	}

//	���� ��ȸ(preorder):(root, left, right)
	private void printPreOrder(Node current) {
		if (current != null) {
			System.out.print(current.val + " ");
			printPreOrder(current.left);
			printPreOrder(current.right);
		}
	}

//	���� ��ȸ(postorder):(left, right, root)
	private void printPostOrder(Node current) {
		if (current != null) {
			printPostOrder(current.left);
			printPostOrder(current.right);
			System.out.print(current.val + " ");
		}
	}

	private void printLevelOrder(Node current) {
		// (5)�� ����
	}
}

public class BST {
	public static void main(String[] args) {
		int arr[] = { 8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15 };
		BinarySerachTree bst = new BinarySerachTree();
		for (int i = 0; i < arr.length; i++) {
			bst.add(arr[i]);
		}

		bst.printTree();
		System.out.println();
		System.out.print("\n--------------------");
		System.out.print("\nremove data : " + 4);
//		bst.remove(4);
		System.out.print("\nremove data : " + 15);
//		bst.remove(15);
		System.out.print("\nremove data : " + 2);
//		bst.remove(2);
		System.out.println("\n-------------------\n");
		bst.printTree();
	}
}
