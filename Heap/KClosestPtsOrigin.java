/*973. K Closest Points to Origin - Leetcode Java Solutions*/

/*
----------------------------Using MinHeap-----------------------------

Time Complexity: O(Nlog⁡N)+O(klogN), where N is the length of points.
Space Complexity: O(N) 

*/

class KClosestPtsOrigin
{
    public int[][] kClosest(int[][] points, int K) 
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {
            return b[0]-a[0];
        });
        
        for(int[] p : points) 
        {
            int dist = p[0] * p[0] + p[1] * p[1];
            pq.add(new int[]{dist, p[0], p[1]});
            
            if(pq.size()>K) 
                pq.poll();
            
        }
        
        int[][] res = new int[K][2];
        int i=0;
        while(!pq.isEmpty()) 
        {
            int[] tmp = pq.poll();
            res[i][0] = tmp[1];
            res[i++][1] = tmp[2];
        }
        
        return res;
    }
}

/*
----------------------------Using Sorting-----------------------------

Time Complexity: O(Nlog⁡N), where N is the length of points.
Space Complexity: O(N) 

*/
/*
class Solution 
{
    public int[][] kClosest(int[][] points, int K) 
    {
        int n=points.length;
        int[] dists = new int[n];
        
        int i;
        for (i=0;i<n;i++)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        
        for (i=0;i<n;i++)
        {
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        }
        
        
        return ans;
    }

    public int dist(int[] point) 
    {
        return point[0] * point[0] + point[1] * point[1];
    }
}
*/ 

/*
----------------------------Using QuickSelect/Div&Conq-----------------------------



Time Complexity: O(N) in average case and O(N2) in the worst case, where N is the length of points.

Space Complexity: O(N)

*/

