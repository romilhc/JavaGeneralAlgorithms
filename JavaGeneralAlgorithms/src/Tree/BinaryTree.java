/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Romil Chauhan
 */
public class BinaryTree {
    
    Node root;
    
    // Class Node
    protected static class Node {
        int val;
        Node left;
        Node right;
        
        Node(){}
        
        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    
    BinaryTree() {
        this.root = null;
    }
    
    // Tree BFS Traversal.
    public void BFS(Node root) {
        
        // If tree is empty then return.
        if(root == null) return;
        
        // Add root to the queue.
        Queue<Node> bfsQueue = new LinkedList<Node>();
        bfsQueue.add(root);
        
        
        // While queue is not empty.
        while(!bfsQueue.isEmpty()) {
            
            // Remove the node from queue
            Node temp = bfsQueue.remove();
            System.out.print(temp.val + "\t");
            
            // Add children of popped node to the queue.
            if(temp.left != null) {
                bfsQueue.add(temp.left);
            }
            if(temp.right != null) {
                bfsQueue.add(temp.right);
            }
            
        }
        
    }
    
    // Tree inorder traversal.
    public void inorder(Node root) {
        
        // If tree is empty then return.
        if(root == null) return;
        
        // Visit left sub tree
        inorder(root.left);
        // Print current node value
        System.out.print(root.val + "\t");
        // Visit right sub tree
        inorder(root.right);
    }
    
    // Tree preorder traversal.
    public void preorder(Node root) {
        
        // If tree is empty then return.
        if(root == null) return;
        
        // Print current node value
        System.out.print(root.val + "\t");
        // Visit left sub tree
        preorder(root.left);
        // Visit right sub tree
        preorder(root.right);
    }
    
    // Tree postorder traversal
    public void postorder(Node root) {
        
        // If tree is empty then return.
        if(root == null) return;
        
        // Visit left sub tree
        postorder(root.left);
        // Visit right sub tree
        postorder(root.right);
        // Print current node value
        System.out.print(root.val + "\t");
    }
    
    
    // Iterative inorder traversal.
    public void inorderIterative(Node root) {
        
        // If tree is empty then return.
        if(root == null) return;
        
        Stack<Node> treeStack = new Stack<Node>();
        
        while(root != null){
            treeStack.push(root);
            root = root.left;
        }
        
        while(!treeStack.empty()) {
            
            Node temp = treeStack.pop();
            System.out.print(temp.val + "\t");
            
            if(temp.right != null){
                
                temp = temp.right;
                
                while(temp!=null){
                    treeStack.push(temp);
                    temp = temp.left;
                }
            }
        }
        
    }
    
    // Delete the tree.
    public void deleteTree(Node root) {
        
        // If tree is empty then return.
        if(root == null) return;
        
        deleteTree(root.left);
        deleteTree(root.right);
        
        root = null;
               
    }
    
    // Check if two trees are identical.
    public boolean checkIdentical(Node root1, Node root2) {
        
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val == root2.val) {
            return checkIdentical(root1.left, root2.left) && checkIdentical(root1.right, root2.right);
        }
        
        return false;
        
    }
    
    // Find the size of binary tree.
    public int size(Node root) {
        if(root == null) return 0;
        
        return size(root.left) + 1 + size(root.right);
    }
    
    // Check if root to leaf path has given sum.
    public boolean root2leafPathSum(Node root, int sum) {
        
        if(root == null && sum == 0) {
            return true;
        }
        else if(root == null && sum != 0) {
            return false;
        }
        
        return root2leafPathSum(root.left, sum - root.val) || root2leafPathSum(root.right, sum - root.val);
        
                
                
        
    }
    
    // Find max depth
    public int maxDepth(Node root) {
        
        // If tree is empty then return null
        if(root == null) return 0;
        
        // Get max depth of left and right subtree
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // Return height of left subtree + height of right subtree + 1
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    // Check if the tree is balanced binary tree
    public boolean isBalanced(Node root) {
        // If the tree is unbalanced return false
        return isBalancedHelper(root) != -1;
    }
    
    // Helper function for check if tree is balanced
    public int isBalancedHelper(Node root) {
        if(root == null) return 0;
        
        // Get height of left and right subtree
        int leftSubtreeHeight = isBalancedHelper(root.left);
        int rightSubtreeHeight = isBalancedHelper(root.right);
        
        // If any left or right subtree is unbalanced return -1
        if(leftSubtreeHeight == -1 || rightSubtreeHeight == -1) return -1;
        
        // If current tree is unbalanced return -1
        if(Math.abs(leftSubtreeHeight - rightSubtreeHeight) >= 1) return -1;
        
        // Return height of current tree
        return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }
    
    // maxDiameter is needed to keep track of maximum diameter at current node
    private class maxDiameter {
        int max = 0;
    }
    
    // Find diameter of binary tree
    public int diameter(Node root) {
        maxDiameter md = new maxDiameter();
        return diameterHelper(root, md);
    }
    
    // Helper function to calculate diameter
    public int diameterHelper(Node root, maxDiameter md) {
        if(root == null) return 0;
        
        // Get height of left and right subtree
        int leftHeight = diameterHelper(root.left, md);
        int rightHeight = diameterHelper(root.right, md);
        
        // Compare max and current diameter to get the new max diameter
        md.max = Math.max(md.max, Math.max(leftHeight, rightHeight));
        
        // Return height of current tree
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // Find total leaf nodes
    public int findLeafNodes(Node root) {
        
        // If leaf node is reached return 1
        if(root.left == null && root.right == null) return 1;
        int leftLeafNodes = 0, rightLeafNodes = 0;
        
        // Get total number of leaf nodes in left subtree
        if(root.left != null) {
            leftLeafNodes = findLeafNodes(root.left);
        }
        
        // Get total number of leaf nodes in right subtree
        if(root.right != null) {
            rightLeafNodes = findLeafNodes(root.right);
        }
        
        
        return leftLeafNodes + rightLeafNodes;
        
    }
    
    // Find minimum depth of the tree
    public int minDepth(Node root) {
        
        if(root == null) return 0;
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        
    }
    
    // Check if every parent is sum of its children
    public boolean isChildSumProperty(Node root) {
        
        // If left and right both child is null
        if(root.left == null && root.right == null) return true;
        
        // If only right child is there
        if(root.left == null && root.right != null && root.val == root.right.val) return true;
        
        // If only left child is there
        if(root.right == null && root.left != null && root.val == root.left.val) return true;
        
        // If parent = left + right
        if(root.val == (root.left.val + root.right.val)) return true;
        
        return false;
        
    }
    
    private class maxPathSumTracker {
        int val = Integer.MIN_VALUE;
    }
    
    // Get maximum path sum
    public int getMaxPathSum(Node root) {
        
        maxPathSumTracker sum = new maxPathSumTracker();
        int rootSum = getMaxPathSumHelper(root, sum);
        
        return sum.val;
        
    }
    
    // Helper function to get maximum path sum in a tree
    public int getMaxPathSumHelper(Node root, maxPathSumTracker sum) {
        if(root == null) return 0;
        
        // Get sum from left and right subtree
        int leftMaxPathSum = getMaxPathSumHelper(root.left, sum);
        int rightMaxPathSum = getMaxPathSumHelper(root.right, sum);
        
        // Taking current as root from left to right
        int maxSingle = Math.max(Math.max(leftMaxPathSum, rightMaxPathSum) + root.val, root.val);
        
        // Calculate global sum
        int maxGlobal = Math.max(maxSingle, leftMaxPathSum + rightMaxPathSum + root.val);
        
        // Reset global sum
        sum.val = Math.max(sum.val, maxGlobal);
        return maxSingle;
    }
    
    // Is valid BST using PreOrder
    public boolean isPreorderValidBST(int[] arr) {
        
        int n = arr.length;
        Stack<Integer> treeStack = new Stack<>();
        int currRoot = Integer.MIN_VALUE;
        
        // Iterate through an array to check if its a valid BST. 
        for(int i = 0; i < n; i++) {
            
            // If the current value is less than root once the right subtree of
            // root has started
            if(arr[i]  < currRoot) {
                return false;
            }
            
            
            // Empty stack until u get value greater than stack top.
            // Basically empty left subtree.
            while(!treeStack.isEmpty() && arr[i] > treeStack.peek()) {
                currRoot = treeStack.pop();
            }
            
            // Push the element to the stack
            treeStack.push(arr[i]);
            
        }
        
        // Full array is traversed and is a valid BST.
        return true;
    }
   
    // Check if it is a full binary tree.
    public boolean isFullBinaryTree(Node root) {
        
        if(root == null) return true;
        
        if(root.left == null && root.right == null) return true;
        
        if(root.left != null && root.right != null) {
            return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
        }
        
        return false;
    }
    
    // Cut tree path with less than length K
    public Node cutPathAtK(Node root, int k) {
        return cutPathAtKHelper(root, 1, k);
    }
    
    // Helper function for cut tree path with less than length K
    public Node cutPathAtKHelper(Node root, int length, int k) {
        
        if(root == null) return null;
        
        // Cut left and right subtree
        root.left = cutPathAtKHelper(root.left, length + 1, k);
        root.right = cutPathAtKHelper(root.right, length + 1, k);
        
        // If the leaf node is reached and length is less than k then return null
        if(root.left == null && root.right == null && length < k) {
            root = null;
        }
        
        return root;
    }
    
    // Check if tree is mirror image
    public abstract boolean isMirror(Node root);
    
    // Make tree mirror image of itself
    public Node createMirror(Node root) {
        if(root == null) return null;
        
        root.left = createMirror(root.right);
        root.right = createMirror(root.left);
        
        return root;
    }
    
    public static void main(String args[]) {
        
        BinaryTree bt = new BinaryTree();
        
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left =  new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.left.left.right = new Node(7);
        
        BinaryTree bt1 = new BinaryTree();
        
        bt1.root = new Node(10);
        bt1.root.left = new Node(8);
        bt1.root.right = new Node(2);
        bt1.root.left.left =  new Node(3);
        bt1.root.left.right = new Node(5);
        
        System.out.println("BFS OUTPUT: ");
        bt.BFS(bt.root);
        
        System.out.println("\nInorder OUTPUT: ");
        bt.inorder(bt.root);
        
        System.out.println("\nPreorder OUTPUT: ");
        bt.preorder(bt.root);
        
        System.out.println("\nPostorder OUTPUT: ");
        bt.postorder(bt.root);
        
        System.out.println("\nInorder OUTPUT: ");
        bt.inorderIterative(bt.root);
        
        //bt.deleteTree(bt.root);
        
        System.out.println("\nMaximum depth of tree is: " + bt.maxDepth(bt.root));
        
        System.out.println("Are tree1 and tree2 identical? " + bt.checkIdentical(bt.root,bt1.root));
    
        System.out.println("Size of binary tree1 is: " + bt.size(bt.root));
        
        System.out.println("Check if tree1 has root to leaf sum of 14? " + bt.root2leafPathSum(bt.root,14));
    
        System.out.println("Is tree balanced? " + bt.isBalanced(bt.root));
    
        System.out.println("Max diameter of tree is " + bt.diameter(bt.root));
    
        System.out.println("Total leaf nodes in the tree are " + bt.findLeafNodes(bt.root));
    
        System.out.println("Does tree2 statisfy Child Sum Property? " + bt1.isChildSumProperty(bt.root));
        
        System.out.println("Minimum depth of a tree: " + bt.minDepth(bt.root));
    
        System.out.println("Maximum path sum: " + bt.getMaxPathSum(bt.root));
        
        System.out.println("Is valid bst possible using array: " + Arrays.toString(new int[]{2,4,3}) + "? " + bt.isPreorderValidBST(new int[]{2,4,3}));
    
        System.out.println("Is tree1 a full binary tree: " + bt.isFullBinaryTree(bt.root));
    
    }
}
