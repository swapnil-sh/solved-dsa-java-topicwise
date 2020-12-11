/* Preorder to Postorder  - GeeksforGeeks Java Solution (Construct BST from preorder)*/

/*
----------------Using Stack----------------

TC - O(N)
SC - O(N)
*/
class Pre2PostBST
{
    public static Node constructTree(int pre[], int size) 
    {
    //Your code here
        Node root = new Node(pre[0]); 
    
        Stack<Node> s = new Stack<Node>(); 
  
        // Push root 
        s.push(root); 
        int i;
        for(i=1;i<size;i++) 
        { 
            Node temp = null; 
  
            while (!s.isEmpty() && pre[i]>s.peek().data)
                temp = s.pop(); 
            
  
            // Make this greater value as the right child 
            // and push it to the stack 
            if (temp != null) 
            { 
                temp.right = new Node(pre[i]); 
                s.push(temp.right); 
            }  
              
            // If the next value is less than the stack's top 
            // value, make this value as the left child of the  
            // stack's top node. Push the new node to stack 
            else
            { 
                temp = s.peek(); 
                temp.left = new Node(pre[i]); 
                s.push(temp.left); 
            } 
        } 
  
        return root; 
    }
}