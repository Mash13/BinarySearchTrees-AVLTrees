import java.io.File;
import java.util.Scanner;

public class CS6089Bashikari {

	CS6089Bashikari(){}
	
	static class BSTNode {
		
		BSTNode left;
		int element;
		BSTNode right;
		
		//constructor
		public BSTNode() {}
		//constructor
		public BSTNode(int n) {
			left = null;
			element = n;
			right = null;
		}
		
	}
	
	/* Creating a BST */ 
         
	static BSTNode root;  
	
	
	static class AVLNode {
		AVLNode left;
		int element;
		AVLNode right;
		int height;
	
		//constructor
		public AVLNode() {
			left = null;
			element = 0;
			right = null;
			height = 0;
		}
		//constructor
		public AVLNode(int n) {
			left = null;
			element = n;
			right = null;
			height = 0;
		}
	}
	
	static AVLNode AVLRoot;
	
	//BST insertStart
	public void insertStart(int element) 
	{     
		root = insert(root, element); //This calls the insert method - see below  
	}
	
	public void insertStartAVL(int element) 
	{     
		AVLRoot = insertAVL(AVLRoot, element); //This calls the insert method - see below  
	}
		
	static BSTNode insert(BSTNode node, int element)  
	{      
		if (node == null)        
			node = new BSTNode(element);    
		else      
		{       
			if (element <= node.element)      
				node.left = insert(node.left, element);     
			else            
				node.right = insert(node.right, element);   
		}      
		return node;   
	}    		
		
	static void inOrder(BSTNode node){   
	    if(node!=null)     
	    {       
	    	inOrder(node.left);     
	    	System.out.print(" "+node.element);     
	    	inOrder(node.right);   
	    }   
	}
	
	static void inOrderAVL(AVLNode node){   
	    if(node!=null)     
	    {       
	    	inOrderAVL(node.left);     
	    	System.out.print(" "+node.element);     
	    	inOrderAVL(node.right);   
	    }   
	}
	    	
	static boolean search(BSTNode node, int key){   
	    if(node==null) return false;    
	    if(node.element == key) return true;    
	    else{       
	    	if(key < node.element) return search(node.left, key);       
	    	else return search(node.right, key);    
	    }   
	} 
	
	static boolean search(AVLNode node, int key){   
	    if(node==null) return false;    
	    if(node.element == key) return true;    
	    else{       
	    	if(key < node.element) return search(node.left, key);       
	    	else return search(node.right, key);    
	    }   
	} 
	    	
	static int largest(BSTNode node){   
	    if(node==null) return -1;    
	    while(node.right!=null) {        
	    	node=node.right;}     
	    return node.element;   
	} 
	
	static int largest(AVLNode node){   
	    if(node==null) return -1;    
	    while(node.right!=null) {        
	    	node=node.right;}     
	    return node.element;   
	} 
	    	    
	static int smallest(BSTNode node){    
	   	if(node==null) return -1;  
	   	while(node.left!=null) {     
	   		node=node.left;}   
	    return node.element;  
	}  
	
	static int smallest(AVLNode node){    
	   	if(node==null) return -1;  
	   	while(node.left!=null) {     
	   		node=node.left;}   
	    return node.element;  
	}
	    	
	static void printElementsOnALevel (BSTNode node, int level)//This is from last week 
	{     
	   	if (node == null) return;     
	   	if (level == 0) System.out.print(node.element + " ");       
	    else if (level > 0)   
	    {      
	    	printElementsOnALevel(node.left, level-1);         
	    	printElementsOnALevel(node.right, level-1);     
	    } 
	}
	
	static void printElementsOnALevel (AVLNode node, int level)//This is from last week 
	{     
	   	if (node == null) return;     
	   	if (level == 0) System.out.print(node.element + " ");       
	    else if (level > 0)   
	    {      
	    	printElementsOnALevel(node.left, level-1);         
	    	printElementsOnALevel(node.right, level-1);     
	    } 
	}
	
    int height(BSTNode node)  
    { 
        if (node == null) 
            return 0; 
        else 
        { 
            /* compute the depth of each subtree */
            int leftHeight = height(node.left); 
            int rightHeight = height(node.right); 
   
            /* use the larger one */
            if (leftHeight > rightHeight) 
                return (leftHeight + 1); 
             else 
                return (rightHeight + 1); 
        } 
    }
    
    int heightAVL(AVLNode node)  
    { 
        if (node == null) 
            return 0; 
        else 
        { 
            /* compute the depth of each subtree */
            int leftHeight = heightAVL(node.left); 
            int rightHeight = heightAVL(node.right); 
   
            /* use the larger one */
            if (leftHeight > rightHeight) 
                return (leftHeight + 1); 
             else 
                return (rightHeight + 1); 
        } 
    }

    //BST
    void printLevelOrder() 
    { 
        int h = height(root); 
        int i; 
        for (i = 1; i <= h; i++) 
            printElementsOnALevel(root, i); 
    }
    
    void printLevelOrderAVL() 
    { 
        int h = heightAVL(AVLRoot); 
        int i; 
        for (i = 1; i <= h; i++) 
            printElementsOnALevel(AVLRoot, i); 
    }
    
    int numOfNodes(BSTNode node) {   
    	 
    	  if (node == null) 
    		  return 0;
    	  return 1 + numOfNodes(node.left) + numOfNodes(node.right);
    	  
    }
    
    int numOfNodes(AVLNode node) {   
   	 
  	  if (node == null) 
  		  return 0;
  	  return 1 + numOfNodes(node.left) + numOfNodes(node.right);
  	  
  }
    
	AVLNode insertAVL(AVLNode node, int element) {
		
		if (node == null)        
			node = new AVLNode(element);    
		else if (element <= node.element)  
		{            
			node.left = insertAVL(node.left, element);     
			if (heightSubtree(node.left)- heightSubtree(node.right)== 2)   
				if (element < node.left.element)
					node = singleRightRotation(node);
				else
					node = doubleRightRotation(node);
		}
		else if (element > node.element) {
			node.right = insertAVL(node.right, element);  
			if (heightSubtree(node.right) - heightSubtree(node.left) == 2)
				if (element > node.right.element)
					node = singleLeftRotation(node);
				else
					node = doubleLeftRotation(node);
		}
		else
			System.out.println("Element already exists in the tree");
		node.height = larger(heightSubtree(node.left), heightSubtree(node.right))+ 1; 
 
		
		return node; 
	}
	
	private int heightSubtree(AVLNode node) {
		if(node == null) return -1;
		else return (node.height);
	}
	
	int larger(int a, int b) {
		if (a>b) return a;
		else return b;
	}
	
	private AVLNode singleRightRotation(AVLNode A) {
		AVLNode temp = A.left;
		A.left = temp.right;
		temp.right = A;
		A.height = larger(heightSubtree(A.left), heightSubtree(A.right)) + 1;
		temp.height = larger(heightSubtree(temp.left), temp.height) + 1;
		return temp;
	}
	
	private AVLNode singleLeftRotation(AVLNode A) {
		AVLNode temp = A.right;
		A.right = temp.left;
		temp.left = A;
		A.height = larger(heightSubtree(A.left), heightSubtree(A.right)) + 1;
		temp.height = larger(heightSubtree(temp.right), A.height) + 1;
		return temp;
	}
	
	AVLNode doubleRightRotation(AVLNode A) {
		return singleRightRotation(A);
	}
	
	AVLNode doubleLeftRotation(AVLNode A) {
		A.right = singleRightRotation(A.right);
		return singleLeftRotation(A);
	}
    
	public static void main(String[] args) throws Exception {
		
		Integer[] dataLength = new Integer[100];
		int lengthCount = 0;
		int j = 0;
		long start = 0;
		long elapsedTime = 0;
		long BSTreeConstructTime = 0;
		long AVLTreeConstructTime = 0;
		long BSTreeSearchTime = 0;
		long AVLTreeSearchTime = 0;
		
		//scan data file to in
		//The file contains only integers... separated by a space???
		Scanner in = new Scanner(new File("BSTData.txt"));
		
		//place data within int array dataLength 
		//to later find the exact amount of numbers to be added to the tree
		while (in.hasNextInt())
	    {
	        dataLength[j] = in.nextInt();
	        j++;
	    }
		j = 0;
		
		//if an arrayOutOfBounds error is given, dataLength may need to be filled with nulls.
		//makes lengthCount equal to the correct number of elements to be inserted
		while (dataLength[j] != null)
		{
			lengthCount++;
			j++;
		}
		
		//instantiates the array that the input data is stored in. 
		//This array has length equal to the amount of elements
		int[] data = new int[lengthCount];
		
		//transfers elements scanned into dataLength to data
		for(int i = 0; i < data.length; i++)
		{
			data[i] = dataLength[i];
		}
		
		start = System.nanoTime();
		//create a binary search tree from the data in the scanned file.  
		CS6089Bashikari BSTree = new CS6089Bashikari();
		
		//changed from BSTree.inputData.length to data.length... 2 lines down
		//changed from BSTree.inputData[i] to data[i]... 3 lines down
		//plugs all elements into the Binary Search Tree
		for(int i = 0; i<data.length; i++) 
			BSTree.insertStart(data[i]);
		
		elapsedTime = System.nanoTime() - start;
		BSTreeConstructTime = elapsedTime;
		System.out.println("Time taken to construct BST in nanoseconds: " + BSTreeConstructTime);

		start = System.nanoTime();
		//create an AVL tree from the data in the file.
		CS6089Bashikari AVLTree = new CS6089Bashikari(); // this must not be right... AVL must be made differently
		
		//changed from BSTree.inputData.length to data.length... 2 lines down
		//changed from BSTree.inputData[i] to data[i]... 3 lines down
		//plugs all elements into the Binary Search Tree
		for(int i = 0; i<data.length; i++) 
			AVLTree.insertStartAVL(data[i]);
		
		elapsedTime = System.nanoTime() - start;
		AVLTreeConstructTime = elapsedTime;
		System.out.println("Time taken to construct AVL tree in nanoseconds: " + AVLTreeConstructTime);
		//1. output inorder traversal of both the BST and AVL
		//output inorder traversal of the BST
		
		//BST
		System.out.println("BST Inorder traversal results: ");    
		BSTree.inOrder(BSTree.root);
		System.out.println("");
		
		//AVL
		System.out.println("AVL Inorder traversal results: ");    
		AVLTree.inOrderAVL(AVLTree.AVLRoot);
		System.out.println("");
		
		//2. Print the height of the tree... both BST and AVL
		
		//BST
		if (BSTree.height(BSTree.root) != 0) {
			System.out.println("The height of the binary search tree is: " 
				+ (BSTree.height(BSTree.root) - 1));
		} else {
			System.out.println("The binary tree has no elements");
		}
		
		//AVL
		if (AVLTree.heightAVL(AVLTree.AVLRoot) != 0) {
			System.out.println("The height of the AVL tree is: " 
				+ (AVLTree.heightAVL(AVLTree.AVLRoot) - 1));
		} else {
			System.out.println("The AVL tree has no elements");
		}
		
		//3. Print the level order of the tree... both BST and AVL
		
		//BST
		System.out.print("The level order of the binary search tree is: ");
		for (int i = 0; i <= BSTree.height(BSTree.root); i++) {     
			System.out.println();    
			BSTree.printElementsOnALevel(BSTree.root, i);    
		}
		
		//AVL
		System.out.print("The level order of the AVL tree is: ");
		for (int i = 0; i <= AVLTree.heightAVL(AVLTree.AVLRoot); i++) {     
			System.out.println();    
			AVLTree.printElementsOnALevel(AVLTree.AVLRoot, i);    
		}
		
		//4. Print the largest element in the tree
		
		//BST
		System.out.println("BST largest element: "+ BSTree.largest(BSTree.root));
		
		//AVL
		System.out.println("AVL largest element: "+ AVLTree.largest(AVLTree.root));
		
		//5. Print the time taken (in nanoseconds) for the construction of each tree.
		//use java method, System.nanoTime().
		
		
		//7. Prompt the user for an integer to search for within both the BST and AVL trees. 
		//Return whether the integer is found or not.
		//Repeat until the input is 0. Print the time taken for each search of each tree. 
		//Print the time in nanoseconds.
		
		int input = 1;
		while (input != 0) {
			System.out.println("What number would you like to search for? Enter 0 to move to end program.");
			Scanner scan = new Scanner(System.in);
			input = scan.nextInt();
		
			start = System.nanoTime();
			if (BSTree.search(BSTree.root, input) == true) {
				System.out.println("The element has been found (BST)");
			} else {
				System.out.println("The element has not been found (BST)");
			}
			elapsedTime = System.nanoTime() - start;
			BSTreeSearchTime = elapsedTime;
			System.out.println("Time taken to search BST in nanoseconds: " + BSTreeSearchTime);
			
			start = System.nanoTime();
			if (AVLTree.search(AVLTree.AVLRoot, input) == true) {
				System.out.println("The element has been found (AVL tree)");
			} else {
				System.out.println("The element has not been found (AVL tree)");
			}
			elapsedTime = System.nanoTime() - start;
			AVLTreeSearchTime = elapsedTime;
			System.out.println("Time taken to search AVL in nanoseconds: " + AVLTreeSearchTime);
		}
		
		
		in.close();
		
	}
}
