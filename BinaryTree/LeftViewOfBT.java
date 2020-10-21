/*Left View of Binary Tree - GeeksforGeeks Iterative using Queue(LevelOrderTrav Approach) and Recursive Java Solution*/



//-------------------------------Iterative Solution---------------------------------------

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class LeftViewOfBT
{
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        
        Queue<Node> q=new LinkedList<>();
        
        q.offer(root);
        while(q.size()>0)
        {
            int level=q.size();
            ArrayList<Node> temp=new ArrayList<>();
            for(int i=0;i<level;i++)
            {
                if(q.peek().left!=null)
                {
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null)
                {
                    q.offer(q.peek().right);
                    
                }
                
                temp.add(q.poll());
            }
            
            res.add(temp.get(0).data);
        }
    
      return res;
    }
}



//-----------------------------------Recursive Solution------------------------------------


/*


class Tree
{
    
    
    static int max_level=-1;
    
    public static void leftViewSolve(Node node, int level,ArrayList<Integer> res) 
    { 
        
        if(node==null) 
            return; 
  
       
        if(max_level<level) 
        { 
            res.add(node.data); 
            max_level = level; 
        } 
  
         
        leftViewSolve(node.left, level + 1,res); 
        leftViewSolve(node.right, level + 1,res); 
    } 
    
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
    
        leftViewSolve(root,0,res);
        return res;
    }
}

*/