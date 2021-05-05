/* Flattening a Linked List - GeeksforGeeks Java Solution*/
/*
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer.
*/


/*
----------------------------Using Recursion--------------------

TC - O(n)
SC - O(1)
*/

class FlattenSortedLL
{
    Node merge(Node a, Node b)
    {
        Node temp = new Node(0);
        Node res = temp; 
        
        while(a != null && b != null)
        {
            if(a.data < b.data)
            {
                temp.bottom = a; 
                temp = temp.bottom; 
                a = a.bottom; 
            }
            else 
            {
                temp.bottom = b;
                temp = temp.bottom; 
                b = b.bottom; 
            }
        }
        
        if(a != null) 
            temp.bottom = a; 
        else 
            temp.bottom = b;
        return res.bottom; 
        
    }
    Node flatten(Node root)
    {
	// Your code here
	    if(root==null || root.next == null) 
                return root;
	       
	    Node temp=flatten(root.next);
	    Node res=merge(root, temp);
	    
	    return res;
    }
}