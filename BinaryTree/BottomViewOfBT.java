/*Bottom View of Binary Tree - GeeksforGeeks Java Solution using Queue and TreeMap*/


// class Node
// {
//     int data; //data of the node
//     int hd; //horizontal distance of the node
//     Node left, right; //left and right references
 
//     // Constructor of tree node
//     public Node(int key)
//     {
//         data = key;
//         hd = Integer.MAX_VALUE;
//         left = right = null;
//     }
// }


class BottomViewOfBT
{
    // Method that returns the bottom view.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root==null)
            return res;
        int hd=0;
            
        Queue<Node> q=new LinkedList<>();
        TreeMap<Integer,Integer> tmap=new TreeMap<>();
        
        root.hd=hd;
        q.offer(root);
        
        while(q.size()>0)
        {
            Node temp=q.poll();
            
            hd=temp.hd;
            tmap.put(hd,temp.data);
                
            if(temp.left!=null)
            {
                temp.left.hd=hd-1;
                q.offer(temp.left);
            }
                
            if(temp.right!=null)
            {
                temp.right.hd=hd+1;
                q.offer(temp.right);
            }
                
        }
        
       for(Map.Entry<Integer,Integer> entry:tmap.entrySet())
          res.add(entry.getValue());
      
        return res;
    }
}