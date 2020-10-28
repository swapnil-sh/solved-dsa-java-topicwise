/*Print Diagonal Ttaversal of Binary Tree - Techies Delight Java Recursive Solution using HashMap and Iterative Solution using Queue*/

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