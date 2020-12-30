/*133. Clone Graph - Leetcode Java Solutions*/

/*
-----------------------------Using DFS---------------------------

TC - O(V*E)


*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class CloneGraph
{
    public void dfs(Node curNode, Node copyNode, Node[] visited)
    {
        visited[copyNode.val]= copyNode;
        
        for(Node neighbour: curNode.neighbors)
        {
            if(visited[neighbour.val]==null)
            {
                Node newNode= new Node(neighbour.val);
                copyNode.neighbors.add(newNode);
                dfs(neighbour, newNode, visited);
            } 
            else
                copyNode.neighbors.add(visited[neighbour.val]);
        }
        
    }
    public Node cloneGraph(Node node) 
    {
        if(node==null) 
            return null;
        
        Node[] vis= new Node[101];
        Node copyNode= new Node(node.val);
        
        vis[node.val]= copyNode;
        
        for(Node neighbour: node.neighbors)
        {
            if(vis[neighbour.val]==null)
            {
                Node newNode= new Node(neighbour.val);
                copyNode.neighbors.add(newNode);
                dfs(neighbour, newNode, vis);
            } 
            else
                copyNode.neighbors.add(vis[neighbour.val]);
            
        }
        return copyNode;
    }
}