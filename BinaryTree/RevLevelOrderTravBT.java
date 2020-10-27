/* Reverse Level Order Traversal - GeeksforGeeks Recursive and Iterative using Stack and Queue Java Solution*/

class RevLevelOrderTravBT
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        if(node==null)
            return res;
        
        int h=height(node);
        for(int i=h;i>=1;i--)
            solve(node,i,res);
        
        return res;
    }
    
    public int height(Node node) 
    {
        if (node == null)
            return 0;
        else
        {
            int lheight=height(node.left);
            int rheight=height(node.right);
  
            if(lheight>rheight)
                return(lheight+1);
            else
                return(rheight+1);
        }
    }
    
    public void solve(Node root,int level,ArrayList<Integer> res)
    {
        if(root==null)
            return;
        if(level==1)
            res.add(root.data);
        else if(level>1)
        {
            solve(root.left,level-1,res);
            solve(root.right,level-1,res);
        }
    }
    
} 



//--------------------------Iterative Solution using Stack and Queue--------------------------------


/*

class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        if(node==null)
            return res;
        
        Stack<Node> st = new Stack();
        Queue<Node> q = new LinkedList();
        q.offer(node);
        
        Node temp;
        while(!q.isEmpty())
        {
            temp=q.poll();
            st.push(temp);
            
            if(temp.right!=null)
                q.offer(temp.right);
            
            if(temp.left!=null)
                q.offer(temp.left);
        }
        
        while(!st.isEmpty())
            res.add(st.pop().data);
            
        return res;
    }

*/