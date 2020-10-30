/* Leaf at same level  - GeeksforGeeks Java Solution Recursive and Iterative TC - O(n) for both*/



class LeafsAtSameLevBT
{
    int leafLev=0;
    boolean check(Node root,int level)
    {
        if(root==null)
            return true;
        
        if(root.left==null && root.right==null)
        {
            if(leafLev==0)
            {
                leafLev=level;
                return true;
            }
            
            return (leafLev==level);
        }
	   
	    return (check(root.left,level+1) && check(root.right,level+1));
    }
    boolean check(Node root)
    {
	   if(root==null)
	    return false;
	   
	   return check(root,0);
    }
}


//----------------------------Iterative Solution using Queue-------------------------------

/*
class GfG
{
    
    boolean check(Node root)
    {
        if(root==null)
	        return true;
	        
	    Queue<Node> q=new LinkedList<>();
	    q.offer(root);
	    
	    int res=-1;
	    int level=0;
	    Node temp;
	    int size;
	    while(!q.isEmpty())
	    {
	        size=q.size();
	        level++;
	        
	        while(size>0)
	        {   
	            temp=q.poll();
	            if(temp.left!=null)
	            {
	                q.add(temp.left);
	            
    	            if(temp.left.left==null && temp.left.right==null)
    	            {
    	                if(res==-1)
    	                    res=level;
    	                    
    	                else if(res!=level)
    	                    return false;
    	                
    	            }
	            }
    	            
	            if(temp.right!=null)
	            {
	                q.add(temp.right);
	            
    	            if(temp.right.right==null && temp.right.left==null)
    	            {
    	                if(res==-1)
    	                    res=level;
    	                
    	                else if(res!=level)
    	                    return false;
    	            }
	            }   
	            size--;
	        }
	        
	    }
	   
	   
	   return true;
    }
}


*/