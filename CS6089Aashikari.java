import java.io.File;
import java.util.Scanner;

public class CS6089Aashikari {
	
	CS6089Aashikari(){}
	
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
	
	public void insertStart(int element) 
	{     
		root = insert(root, element); //This calls the insert method - see below  
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
	    	
	static boolean search(BSTNode node, int key){   
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
	    	    
	static int smallest(BSTNode node){    
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

    void printLevelOrder() 
    { 
        int h = height(root); 
        int i; 
        for (i = 1; i <= h; i++) 
            printElementsOnALevel(root, i); 
    }
    
    int numOfNodes(BSTNode node) {   
    	 
    	  if (node == null) 
    		  return 0;
    	  return 1 + numOfNodes(node.left) + numOfNodes(node.right);
    	  
    }
    
	public static void main(String[] args) throws Exception {
		
		Integer[] dataLength = new Integer[100];
		int lengthCount = 0;
		int j = 0;
		
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
		
		//create a binary search tree from the data in the scanned file. 
		CS6089Aashikari BSTree = new CS6089Aashikari();
		
		//changed from BSTree.inputData.length to data.length... 2 lines down
		//changed from BSTree.inputData[i] to data[i]... 3 lines down
		//plugs all elements into the Binary Search Tree
		for(int i = 0; i<data.length; i++) 
			BSTree.insertStart(data[i]);
		
		
		//1. output inorder traversal of the BST
		System.out.println("Inorder traversal results: ");    
		BSTree.inOrder(BSTree.root);
		System.out.println("");
		
		
		//2. Print the height of the tree
		if (BSTree.height(BSTree.root) != 0) {
			System.out.println("The height of the binary search tree is: " 
				+ (BSTree.height(BSTree.root) - 1));
		} else {
			System.out.println("The binary tree has no elements");
		}
		
		//3. Print the level order of the tree
		System.out.print("The level order of the tree is: ");
		for (int i = 0; i <= BSTree.height(BSTree.root); i++) {     
			System.out.println();    
			BSTree.printElementsOnALevel(BSTree.root, i);    
		}
		//System.out.println("");
		
		//4. Print the number of nodes in the tree
		System.out.println("The number of nodes in the binary search tree is: " 
				+ BSTree.numOfNodes(BSTree.root));
		
		//5. Print the largest element in the tree
		System.out.println("Largest element: "+ BSTree.largest(BSTree.root)); 
		
		//6. Prompt the user for an integer to search for within the BST. 
		//Return whether the integer is found or not.
		//Repeat until the input is 0.
		int input = 1;
		while (input != 0) {
			System.out.println("What number would you like to search for? Enter 0 to end the program.");
			Scanner scan = new Scanner(System.in);
			input = scan.nextInt();
		
			if (BSTree.search(BSTree.root, input) == true) {
				System.out.println("The element has been found");
			} else {
				System.out.println("The element has not been found");
			}
		}
		
		in.close();
		//scan.close();
	}
}
