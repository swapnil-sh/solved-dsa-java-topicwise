/* Construct Tree from Inorder & Preorder - GeeksforGeeks Multiple Solutions*/


//--------------------------------Recursive Solution using HashMap----------------------------------

/* This solution takes O(n) time complexity since it requires O(1) time to search each node in map to find its position. But it requires O(n) extra space to store the inorder array in a map, also O(n) extra space is needed for recursion function call stack */

class ConstBTFromINOPREO
{
    int st=0;
    Map<Integer, Integer> mp=new HashMap<>();
    public Node create(int in[],int pre[],int ins,int ine)
    {
        if(ins>ine)
            return null;
        
        Node root=new Node(pre[st++]);
        int rootIndex=mp.get(root.data); //getting th index of root node from inorder array
        
        root.left=create(in,pre,ins,rootIndex-1); //chehcking in left half of inorder arrat for left subtree
        root.right=create(in,pre,rootIndex+1,ine); ////checking in left half of inorder arrat for left subtree
        
        return root;
    }
    
    public Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        if(n==0)
            return null;
        
        if(n==1)
            return new Node(inorder[0]);
        
        for(int i = 0; i < n; i++)
            mp.put(inorder[i], i);

            
        return create(inorder,preorder,0,n-1);
    }
}

//--------------------------------Recursive Solution----------------------------------

/* This solution takes O(n * n) time complexity since it requires to search each node in inorder array to find its position and to find its left and right subtree. O(n) extra space is needed for recursion function call stack */

/*
class Solution
{
     int st=0;
    
    public Node create(int in[],int pre[],int ins,int ine)
    {
        if(ins>ine)
            return null;
        
        Node temp=new Node(pre[st]);
        int rootIndex=-1;
        for(int i=ins;i<=ine;i++)
        {
            if(pre[st]==in[i])
            {
                rootIndex=i;
                break;
            }
        }
        st++;
        
        temp.left=create(in,pre,ins,rootIndex-1);
        temp.right=create(in,pre,rootIndex+1,ine);
        
        return temp;
    }
    
    public Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        if(n==0)
            return null;
        
        if(n==1)
            return new Node(inorder[0]);
            
        return create(inorder,preorder,0,n-1);
    }
}

*/





//--------------------------------Recursive Solution C++ (Descriptive - Coding Ninjas)----------------------------------

/*

Node* helper(int preorder[],int inorder[],int preS,int preE,int inS,int inE)
    {
        //Base...
        if(inS > inE)
            return NULL;
        
        int rootData = preorder[preS];
        
        int rootIndex = -1;
        
        for(int i=inS;i <= inE; ++ i) // Finding the index of current subtree root....
        {
            if(rootData == inorder[i])
            {
                rootIndex = i;
                break;
            }
        }
        
        //Variables for left subtree.........
        int lPreS = preS + 1; //start of Preorder array
        int lInS = inS; // start of Inorder array
        int lInE = rootIndex - 1; // end of Inorder array
        int lPreE = lInE - lInS + lPreS; // end of Preorder array
        
        //Variables for right subtree...........
        int rPreS = lPreE + 1; //start of Preorder array
        int rPreE = preE; // end of Preorder array
        int rInS = rootIndex + 1; // start of Inorder array
        int rInE = inE; // end of Inorder array
        
        Node *root = new Node(rootData); // creating node...
        
        root->left = helper(preorder,inorder,lPreS,lPreE,lInS,lInE);
        
        root->right = helper(preorder,inorder,rPreS,rPreE,rInS,rInE);
        
        return root;
    }


Node* buildTree(int inorder[],int preorder[], int n)
{
//add code here.
     return helper(preorder,inorder,0,n-1,0,n-1 );
}
*/