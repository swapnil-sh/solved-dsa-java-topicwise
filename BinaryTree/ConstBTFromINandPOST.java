/* Tree from Postorder and Inorder - GeeksforGeeks Java Solution using HashMap and Recursion*/


class ConstBTFromINandPOST
{
    // Complete the function
    
    int curr;
    Map<Integer,Integer> hmap=new HashMap<>();
    
    Node create(int in[],int post[], int ins,int ine)
    {
        if(ins>ine)
            return null;
        
        Node root=new Node(post[curr--]);
        
        int rootIndex=hmap.get(root.data);
        
        
        root.right=create(in,post,rootIndex+1,ine);
        root.left=create(in,post,ins,rootIndex-1);
        
        return root;
    }
    Node buildTree(int in[], int post[], int n)
    {
        // Your code here
        if(n==0)
            return null;
            
        for(int i=0;i<n;i++)
            hmap.put(in[i],i);
            
        curr=n-1;
        return create(in,post,0,n-1);
    }
}