/*15. 3Sum - Leetcode Java Solutions*/


/*
---------------------------Tabulation Solution------------------------------------
TC - O(n^2)
SC - O(1)
*/
class 3Sum
{
    public List<List<Integer>> threeSum(int[] a) 
    {
        int i,lo,hi,n=a.length,sum=0;
        Arrays.sort(a);
        List<List<Integer>> res=new ArrayList<>();
        
        for(i=0;i<n-2;i++)
        {
            if(i==0 || (i>0 && (a[i]!=a[i-1])))
            {
                sum=0-a[i];
                lo=i+1;
                hi=n-1;
                
                while(lo<hi)
                {
                    if(a[lo]+a[hi]==sum)
                    {
                        ArrayList<Integer> t=new ArrayList<>();
                        t.add(a[i]);
                        t.add(a[lo]);
                        t.add(a[hi]);
                        res.add(t);
                        
                        while(lo<hi && (a[lo]==a[lo+1]))
                            lo++;
                        
                        while(lo<hi && (a[hi]==a[hi-1]))
                            hi--;
                        
                        lo++;
                        hi--;
                    }
                    
                    else if(a[lo]+a[hi]<sum)
                        lo++;
                    else
                        hi--;
                }
            }
            
        }
        
        return res;
        
    }
}


/*
---------------------------Brute Force Solution------------------------------------
TC - O(n^3)+contains function
SC - O(1)
*/
/*
class Solution
{
    public List<List<Integer>> threeSum(int[] a) 
    {
        int i,j,k,n=a.length;
        Arrays.sort(a);
        List<List<Integer>> res=new ArrayList<>();
        for(i=0;i<n-2;i++)
        {
            for(j=i+1;j<n-1;j++)
            {
                for(k=j+1;k<n;k++)
                {
                    if(a[i]+a[j]+a[k]==0)
                    {
                        ArrayList<Integer> t=new ArrayList<>();
                        t.add(a[i]);
                        t.add(a[j]);
                        t.add(a[k]);
                        if(!res.contains(t))
                            res.add(t);
                    }
                }
            }
        }
        
        return res;
        
    }
}
*/