/* Top View of Binary Tree  - GeeksforGeeks Java Solution using Queue and TreeMap*/

/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class TopViewOfBT
{
    // function should print the topView of the binary tree
    static void topView(Node root)
    {
        // add your code
        class QueueObj 
        { 
            Node node; 
            int hd; 
  
            QueueObj(Node node, int hd) 
            { 
                this.node = node; 
                this.hd = hd; 
            } 
        } 
            
        Map<Integer,Node> tmap=new TreeMap<>();
        Queue<QueueObj> q=new LinkedList<>();
        
        if(root==null)
            return;
        else
            q.offer(new QueueObj(root,0));
        
        while(q.size()>0)
        {
            QueueObj temp=q.poll();
            
            if(!tmap.containsKey(temp.hd))
                tmap.put(temp.hd,temp.node);
                
            if(temp.node.left!=null)
                q.offer(new QueueObj(temp.node.left,temp.hd-1));
            
            if(temp.node.right!=null)
                q.offer(new QueueObj(temp.node.right,temp.hd+1));
            
        }
        
        for(Map.Entry<Integer,Node> entry : tmap.entrySet())
            System.out.print(entry.getValue().data+" "); 
        
    }
}