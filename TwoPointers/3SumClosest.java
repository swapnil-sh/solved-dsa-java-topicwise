/*16. 3Sum Closest - Leetcode Java Solution*/

/*
----------------------Two Pointer------------------------------

TC - O(n^2)
SC - O(1)
*/
class 3SumClosest
{
    public int threeSumClosest(int[] a, int t) 
    {
        if(a.length==0)
            return 0;
        
        Arrays.sort(a);
        int i,j,k,n=a.length;
        int minDiff=Integer.MAX_VALUE,closestSum=Integer.MAX_VALUE;
        
        for(i=0;i<n-2;i++)
        {
            j=i+1;
            k=n-1;
            
            while(j<k)
            {
                int tripletSum=a[i]+a[j]+a[k];
                
                if(Math.abs(t-tripletSum)<=minDiff)
                {
                    minDiff=Math.abs(t-tripletSum);
                    closestSum=tripletSum;
                    System.out.println(closestSum);
                }
                
                if(tripletSum==t)
                    return tripletSum;
                
                else if(tripletSum<t)
                    j++;
                
                else
                    k--;
            }
        }
        
        return closestSum;
    }
}