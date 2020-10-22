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



//--------------------------------------Recursive Code (Coding Simplified)----------------------------------------
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