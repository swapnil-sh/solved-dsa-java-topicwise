/*Print Diagonal Ttaversal of Binary Tree - Techies Delight and GeeksforGeeks Java Recursive Solution using Preorder and HashMap and Iterative Solution using Queue*/

class DiagonalTravBT
{
	// Recursive function to do a pre-order traversal of the tree and
	public static void printDiagonal(Node node, int diagonal,Map<Integer, List<Integer>> map)
	{
		
		if (node == null) {
			return;
		}

		
		map.putIfAbsent(diagonal, new ArrayList<>());
		map.get(diagonal).add(node.data);

		
		printDiagonal(node.left, diagonal + 1, map);
		printDiagonal(node.right, diagonal, map);
	}

	public static void printDiagonal(Node root)
	{
		Map<Integer, List<Integer>> map = new HashMap<>();

		
		printDiagonal(root, 0, map);

		
		for (int i = 0; i < map.size(); i++)
			System.out.println(map.get(i));

	}
}



//-------------------------Iterative Using Queue---------------------------

class Main
{
	public static void diagonalPrint(Node root)
	{
		
		Queue<Node> q = new ArrayDeque<>();

		// create a dummy node to denote end of a diagonal
		Node dummy= new Node(-1);

		// enqueue all nodes of first diagonal in binary tree
		while (root != null) {
			q.add(root);
			root = root.right;
		}

		// enqueue dummy node at the end of each diagonal
		q.add(dummy);

		// run till only dummyis left
		while (q.size() != 1)
		{
			// dequeue front node
			Node front = q.poll();

			if (front != dummy)
			{
				
				System.out.print(front.data + " ");

				
				Node node = front.left;
				while (node != null)
				{
					q.add(node);
					node = node.right;
				}
			}
			else
			{
				q.add(dummy);
				System.out.println();
			}
		}
	}
}


/*
---------------------------------------GFG Solution using Recursion and HashMap-----------------------------

TC - O(n)
SC- O(n)
*/

/*
class Tree
{
    public void solve(Node root, int hd, Map<Integer, ArrayList<Integer>> tm)
    {
        if(root==null)
            return;
        
        if(tm.containsKey(hd))
            tm.get(hd).add(root.data);
        else
        {
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(root.data);
            tm.put(hd, temp);
        }
        
        solve(root.left, hd+1, tm);
        solve(root.right, hd, tm);
    }
     public ArrayList<Integer> diagonal(Node root)
     {
           //add your code here.
           ArrayList<Integer> res=new ArrayList<>();
           if(root==null)
                return res;
        
            Map<Integer, ArrayList<Integer>> tm=new HashMap<>();
            
            solve(root,0,tm);
            
            for(Map.Entry<Integer, ArrayList<Integer>> entry:tm.entrySet())
            {
                ArrayList<Integer> al = entry.getValue();
                for(Integer i : al)
                    res.add(i);
            }
            
            return res;
      }
}

*/

/*
---------------------------------------GFG Solution using Iteration and Queue-----------------------------

TC - O(n)
SC - O(n)
*/

/*
class Tree
{
    public void solve(Node root, ArrayList<Integer> res)
    {
        if(root==null)
            return;
        
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        
        Node top=null;
        while(!q.isEmpty())
        {
            top=q.poll();
            while(top!=null)
            {
                res.add(top.data);
                if(top.left!=null)
                    q.offer(top.left);
                top=top.right;
            }
            
        }
    }
     public ArrayList<Integer> diagonal(Node root)
     {
           //add your code here.
           ArrayList<Integer> res=new ArrayList<>();
           if(root==null)
                return res;
        
            solve(root,res);
            return res;
      }
}

*/