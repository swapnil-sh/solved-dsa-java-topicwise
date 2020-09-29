/*349. Intersection of Two Arrays - Leetcode Binary Search Java Solution*/

class IntersectionOfArr 
{
    public boolean binarySearch(int a[],int n,int x)
    {
        int st=0;
        int end=n-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(a[mid]==x)
                return true;
            else if(x<a[mid])
                end=mid-1;
            else
                st=mid+1;
        }
        
        return false;
    }
    
    public int[] intersection(int[] a, int[] b) 
    {
        if(a.length==0)
            return a;
        if(b.length==0)
            return b;
        
        int i;
        Set<Integer> hash_Set=new HashSet<Integer>(); 
        
        Arrays.sort(b);
        for(i=0;i<a.length;i++)
        {
             if(binarySearch(b,b.length,a[i])==true)
                hash_Set.add(a[i]);
        }
        
        int res[]=new int[hash_Set.size()]; 

        i=0;
        for(int j: hash_Set)
            res[i++] = j;

        return res;
        
    }
}
