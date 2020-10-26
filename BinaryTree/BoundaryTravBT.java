/* Boundary Traversal of binary tree - GeeksforGeeks Recursive and Iterative Java Solution*/

//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class BoundaryTravBT
{
    void leftBoundary(Node root,ArrayList<Integer> res)
    {
        if(root!=null)
        {
           
            if(root.left!=null)
            {
                res.add(root.data);
                leftBoundary(root.left,res);
            }
            
            else if(root.right!=null)
            {
                res.add(root.data);
                leftBoundary(root.right,res);
            }
            
            else
                return;
        }
        
        return;
    }
    
    void rightBoundary(Node root,ArrayList<Integer> res)
    {
        if(root!=null)
        {
            if(root.right!=null)
            {
                rightBoundary(root.right, res);
                res.add(root.data);
            }
            else if(root.left!=null)
            {
                rightBoundary(root.left, res);
                res.add(root.data);
            }
    
        }
        
        return;        
    }
    
    void leafNodes(Node root, ArrayList<Integer> res)
    {
        if(root!=null)
        {
            leafNodes(root.left, res);
            if(root.left==null && root.right==null)
                res.add(root.data);
            leafNodes(root.right, res);
        }
        
    }
    
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> res=new ArrayList<>();
	    if(node==null)
	        return res;
	    
	    res.add(node.data);
	    leftBoundary(node.left, res);
	    
	    leafNodes(node.left, res);
	    leafNodes(node.right, res);
	    
	    rightBoundary(node.right, res);
	    
	    return res;   
	    
	}
}
