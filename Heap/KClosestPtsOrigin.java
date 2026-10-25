/*973. K Closest Points to Origin - Leetcode Java Solutions*/

/*
----------------------------Using MinHeap-----------------------------

Time Complexity: O(Nlog⁡N)+O(klogN), where N is the length of points.
Space Complexity: O(N) 

*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Long.compare(distance(b), distance(a))
        );
        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    private long distance(int[] point) {
        long x = point[0];
        long y = point[1];
        return x * x + y * y;
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

