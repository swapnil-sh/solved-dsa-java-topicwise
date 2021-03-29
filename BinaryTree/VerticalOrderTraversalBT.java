/*987. Vertical Order Traversal of a Binary Tree - Leetcode Java Solution using Queue and HashMap */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class VerticalOrderTraversalBT 
{
    class Node
    {
        TreeNode root;
        int hd;
        int vd;
        public Node(TreeNode root, int hd, int vd)
        {
            this.root = root;
            this.hd = hd;
            this.vd = vd;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
            
        if (root==null) 
            return res;
        
        Map<Integer, List<Node>> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        q.offer(new Node(root, 0, 0));
        int minHd = 0;
        int maxHd = 0;
        
        while (!q.isEmpty()) 
        {
            Node cur = q.poll();
            map.putIfAbsent(cur.hd, new ArrayList<>());
            
            minHd = Math.min(minHd, cur.hd);
            maxHd = Math.max(maxHd, cur.hd);
            
            map.get(cur.hd).add(cur);
            
            if (cur.root.left != null) 
                q.offer(new Node(cur.root.left, cur.hd - 1, cur.vd - 1));
            
            if (cur.root.right != null) 
                q.offer(new Node(cur.root.right, cur.hd + 1, cur.vd - 1));
          
        }
        
        int index = 0;
        for (int i = minHd; i <= maxHd; i++)
        {
            Collections.sort(map.get(i), (a, b) -> {
                if (a.vd == b.vd) {
                    return a.root.val - b.root.val;
                } else {
                    return b.vd - a.vd;
                }
            });
            res.add(new ArrayList<>());
            for (Node node : map.get(i)) 
            {
                res.get(index).add(node.root.val);
            }
            index++;
        }
        
        return res;
    }
}



//--------------------------------------Recursive Code - Using Preorder Traversal and TreeMap(Coding Simplified)----------------------------------------
/*
  public void printVerticalOrder(Node node) {
    if (node == null) {
      return;
    }
    int hd = 0;

    TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<Integer, ArrayList<Integer>>();

    getVerticalOrder(node, hd, m);
    
    for (Map.Entry<Integer, ArrayList<Integer>> cm : m.entrySet()) {
      System.out.println(cm.getValue());
    }
  }

  public void getVerticalOrder(Node node, int hd, TreeMap<Integer, ArrayList<Integer>> m) {
    if (node == null) {
      return;
    }

    if (m.get(hd) == null) {
      ArrayList<Integer> l = new ArrayList<Integer>();
      l.add(node.data);
      m.put(hd, l);
    } else {
      ArrayList<Integer> l = m.get(hd);
      l.add(node.data);
      m.put(hd, l);
    }

    getVerticalOrder(node.left, hd - 1, m);
    getVerticalOrder(node.right, hd + 1, m);
  }

*/



/*

------------------------------------------GFG Solution using Queue--------------------------------------------

TC - O(nlogn)
SC - O(n)
*/
/*
class BinaryTree
{
    static class TreeNode
    {
        Node root;
        int hd;
        
        TreeNode(Node root, int hd)
        {
            this.root=root;
            this.hd=hd;
        }
    }
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        
        int hd=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(new TreeNode(root, hd));
        
        TreeMap<Integer, ArrayList<Integer>> hm=new TreeMap<>();
        
        while(!q.isEmpty())
        {
            TreeNode temp=q.poll();
            hd=temp.hd;
            
            if(hm.containsKey(hd))
                hm.get(hd).add(temp.root.data);
            else
            {
                ArrayList<Integer> subList=new ArrayList<>();
                subList.add(temp.root.data);
                hm.put(hd, subList);
            }
            
            if(temp.root.left!=null)
                q.offer(new TreeNode(temp.root.left, hd-1));
                
            if(temp.root.right!=null)
                q.offer(new TreeNode(temp.root.right, hd+1));
        }
        
        for (Map.Entry<Integer, ArrayList<Integer> > entry : hm.entrySet())
        {
            ArrayList<Integer> al = entry.getValue();
            for (Integer i : al)
                res.add(i);
        }
        
        return res;
    }
}

*/


/*
----------------------------------------GFG Recursive MinMax Solution---------------------------------

Time Complexity: Time complexity of below algorithm is O(w*n) where w is width of Binary Tree and n is number of nodes in Binary Tree.
In worst case, the value of w can be O(n) (consider a complete tree for example) and time complexity can become O(n2).
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
   
class Values 
{
    int max, min;
}
   
class BinaryTree 
{
    Node root;
    Values val = new Values();
   
    // A utility function to find min and max distances with respect
    // to root.
    void findMinMax(Node node, Values min, Values max, int hd) 
    {
        // Base case
        if (node == null) 
            return;
   
        // Update min and max
        if (hd < min.min) 
            min.min = hd;
        else if (hd > max.max) 
            max.max = hd;
   
        // Recur for left and right subtrees
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }
   
    // A utility function to print all nodes on a given line_no.
    // hd is horizontal distance of current node with respect to root.
    void printVerticalLine(Node node, int line_no, int hd) 
    {
        // Base case
        if (node == null) 
            return;
   
        // If this node is on the given line number
        if (hd == line_no) 
            System.out.print(node.data + " ");        
   
        // Recur for left and right subtrees
        printVerticalLine(node.left, line_no, hd - 1);
        printVerticalLine(node.right, line_no, hd + 1);
    }
   
    // The main function that prints a given binary tree in
    // vertical order
    void verticalOrder(Node node) 
    {
        // Find min and max distances with resepect to root
        findMinMax(node, val, val, 0);
   
        // Iterate through all possible vertical lines starting
        // from the leftmost line and print nodes line by line
        for (int line_no = val.min; line_no <= val.max; line_no++) 
        {
            printVerticalLine(node, line_no, 0);
            System.out.println("");
        }
    }
   
*/