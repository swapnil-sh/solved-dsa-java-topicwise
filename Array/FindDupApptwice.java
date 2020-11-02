/*442. Find All Duplicates in an Array - Leetcode Java Soltuion using concept of Hashing*/

class FindDupApptwice
{
    public List<Integer> findDuplicates(int[] a) 
    {
        List<Integer> res=new ArrayList<>();
        int i;
        
        for(i=0;i<a.length;i++)
        {
            a[Math.abs(a[i])-1]=-a[Math.abs(a[i])-1];
            if(a[Math.abs(a[i])-1] > 0)
                res.add(Math.abs(a[i]));
        }
        
        return res;
    }
}