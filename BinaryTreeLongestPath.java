package com;

import java.util.ArrayList;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data) {
		this.data=data;
	}
}
class TreeNodeOperation{
	public static ArrayList<Integer> findLongestPathOfTree(TreeNode node){
		//if rootnode is null;
		if(node==null) { 
		  ArrayList<Integer> al= new ArrayList<>(); 
		  return al; 
		  }
		 ArrayList<Integer> leftNode = findLongestPathOfTree(node.left);
		ArrayList<Integer> rightNode = findLongestPathOfTree(node.right);
		//if(leftNode.size()==rightNode.size()){
			//return al;
		//}
		
			if(leftNode.size()>rightNode.size()) {
			leftNode.add(node.data);  //stores that nodes value
		}else {
			rightNode.add(node.data);
		}
		if(leftNode.size()>rightNode.size()) {
			return leftNode;
		}else {
			return rightNode;
		}
	}
	public static void displayNodeData(TreeNode node) {
		if(node!=null) {
			displayNodeData(node.left);
			System.out.print(" "+node.data);
			displayNodeData(node.right);
		}
	}
}
public class BinaryTreeLongestPath {

	public static void main(String[] args) {
    TreeNode rootNode = new TreeNode(100);
    TreeNode node20 = new TreeNode(20);
    TreeNode node130 = new TreeNode(130);
    TreeNode node10 = new TreeNode(10);
    TreeNode node50 = new TreeNode(50);
    TreeNode node110 = new TreeNode(110);
    TreeNode node140 = new TreeNode(140);
    TreeNode node5 = new TreeNode(5);
    
    rootNode.left=node20;
    rootNode.right=node130;
    
    node20.left=node10;
    node20.right=node50;
    
    node10.left=node5;
    
    node130.left=node110;
    node130.right=node140;
    
    TreeNodeOperation.displayNodeData(rootNode);
    System.out.println();
    System.out.println("Longest Path of Tree is ");
    ArrayList<Integer> output = TreeNodeOperation.findLongestPathOfTree(rootNode);
    
    int size=output.size();
    if(size==0) {
    	System.out.println("Node is Empty");
    	 } else {
    		 for(int i=0;i<size;i++) {
    			 System.out.print(" "+output.get(i));
    		 }
    	 }
	}

}
