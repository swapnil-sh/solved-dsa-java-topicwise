/*378. Kth Smallest Element in a Sorted Matrix - Leetcode Binary Search Java Solution*/

class KSmallInMatrix 
{
    
    private int getCount(int [][]a,int mid)
    {
        int count=0,i,j,x=0;
        i=a.length-1;
        j=0;
        
        while(i>=0 && j<a[0].length)
        {
            x=a[i][j];
            if(x>mid)
                i--;
            else
            {
                j++;
                count+=i+1;
            }
        }
        
        return count;
    }
    public int kthSmallest(int[][] a, int k)
    {
        int n = a[0].length;
        int m = a.length;
        
        //System.out.println(m+" "+n);
        int st=a[0][0];
        int end=a[m-1][n-1];
         //System.out.println(st+" "+end);
        int ans=0;
        
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            int count=getCount(a,mid);
            //System.out.println("Count = "+count);
            if(count<k)
                st=mid+1;
            else
            {
                ans=mid;
                end=mid-1;
            }
        }
        
        return ans;
        
    }
}


/*
-------------------Using Heap------------------------------
TC - O(n^2logK)
SC - O(n^2)
*/
/*
class KSmallEleSortedMatrix{


  // Solution One TC : O(nlogk)
  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        pq.offer(matrix[i][j]);
        if (pq.size() > k) {
          pq.poll();
        }

      }
    }

    return pq.peek();
  }
*/