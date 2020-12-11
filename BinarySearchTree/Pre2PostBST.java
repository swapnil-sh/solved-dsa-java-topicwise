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
    
        Node root = new Node(pre[0]); 
        Stack<Node> s = new Stack<Node>(); 
  
        s.push(root); 
        int i;

        for(i=1;i<size;i++) 
        { 
            Node temp = null; 
  
            while (!s.isEmpty() && pre[i]>s.peek().data)
                temp = s.pop(); 

            if (temp!=null) 
            { 
                temp.right = new Node(pre[i]); 
                s.push(temp.right); 
            }  
             
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