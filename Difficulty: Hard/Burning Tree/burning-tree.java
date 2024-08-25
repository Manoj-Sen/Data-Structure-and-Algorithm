//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    static int timeTaken;
    public static int minTime(Node root, int target) 
    {
        timeTaken=0;
        solve(root,target);
        return timeTaken;
    }
    
    static Info solve(Node root,int target){
        if(root==null)
        return new Info(false,-1);
        Info left=solve(root.left,target);
        Info right=solve(root.right,target);
        
        int max=1+Math.max(left.height,right.height);
        //timeTaken=Math.max(timeTaken,max);
        if(root.data==target){
            // check and update height with children
            timeTaken=Math.max(timeTaken,max);
            right.fireSet=true;
            right.height=0;
            return right;
        }
        if(left.fireSet){
            timeTaken=Math.max(timeTaken,left.height+right.height+2);
            left.height+=1;
            return left;
        }
        if(right.fireSet){
            timeTaken=Math.max(timeTaken,left.height+right.height+2);
            right.height+=1;
            return right;
        }
        left.height=max;
        return left;
    }
    
    
    static class Info{
        boolean fireSet;
        int height;
        Info(boolean fireSet,int height){
            this.fireSet=fireSet;
            this.height=height;
        }
    }
}