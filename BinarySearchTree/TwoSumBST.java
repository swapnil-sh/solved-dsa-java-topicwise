/* Find a pair with given target in BST - GeeksforGeeks Java Solutions*/

/*
-------------------Using 2 stacks--------------------
TC - O(n)
SC - O(h)
*/

class TwoSumBST
{
    // root : the root Node of the given BST
    // target : the target sum
    public void pushInStack(Node root, Stack<Node> st, int dir)
    {
        if(dir==1)
        {
            while(root!=null)
            {
                st.push(root);
                root=root.left;
            }
        }
        else
        {
            while(root!=null)
            {
                st.push(root);
                root=root.right;
            }
        }
    }
    public int isPairPresent(Node root, int target)
    {
        // Write your code here
        if(root==null)
            return 0;
        
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();
        
        pushInStack(root, st1, 1);
        pushInStack(root, st2, 0);
        
        while(!st1.isEmpty() && !st2.isEmpty())
        {
            int x=st1.peek().data;
            int y=st2.peek().data;
            
            if((x+y)==target)
                return 1;
                
            if((x+y)<target)
            {
                Node temp=st1.pop();
                if(temp.right!=null)
                    pushInStack(temp.right, st1, 1);
                
            }
            else
            {
                Node temp=st2.pop();
                if(temp.left!=null)
                    pushInStack(temp.left, st2, 0);
                
            }
        }
        
        return 0;
    }
}

/*
---------Using Inorder Traversal and an Array----------------------

TC - O(n^2)
SC - O(n)

TC - O(n) (Using Two Pointers i and j)
SC - O(n)

*/