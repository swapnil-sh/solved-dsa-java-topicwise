/*Height of Binary Tree - GeeksforGeeks Recursive and Iterative Java Solution*/


//-----------------------------Iterative Solution using BFS-Queue------------------------------
/*
TC - O(n)
SC - O(n)
*/

/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */


class HeightOfBTree 
{
    int height(Node node) 
    {
        // code here 
        
        if(node==null)
            return 0;
        
        int i,levelNo=0,h=0;    
        Queue<Node> q=new LinkedList<>();
        
        q.offer(node);
        Node temp=null;
        
        while(q.size()>0)
        {
            levelNo=q.size();
            for(i=0;i<levelNo;i++)
            {
                temp=q.peek();
                if(temp.left!=null)
                    q.offer(temp.left);
                
                if(temp.right!=null)
                    q.offer(temp.right);
                    
                q.remove();
            }
            
            h++;
        }
        
        return h;
    }
}



//-----------------------------Recursive Solution------------------------------
/*
TC - O(n)
SC - O(n) Stack Space
*/

/*
class Solution 
{
    int height(Node node) 
    {
        // code here 
        
        if(node==null)
            return 0;
            
        return Math.max(height(node.left),height(node.right))+1;
    }
}

*/

