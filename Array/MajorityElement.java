/*169. Majority Element - Leetcode Java Solutions*/

/*
----------------------Using HashMap---------------------------

TC - O(n)
SC - O(n)
*/

class MajorityElement
{
    public int majorityElement(int[] a)
    {
        if(a.length==0)
            return 0;
        int i;
        HashMap<Integer, Integer> hm=new HashMap<>();
        
        for(i=0;i<a.length;i++)
            hm.put(a[i], hm.getOrDefault(a[i], 0)+1);
        
        for(Map.Entry itr: hm.entrySet())
        {
            System.out.println(itr.getKey()+" "+itr.getValue());
            if((int)itr.getValue()>(a.length)/2)
                return (int)itr.getKey();
        }
        
        return 0;
        
    }
}

/*
----------------------Using Sorting-----------------

TC - O(nlogn)
SC - O(1)
*/
/*
class Solution
{
    public int majorityElement(int[] a)
    {
        if(a.length==0)
            return 0;
        Arrays.sort(a);
        
        return a[a.length/2];
        
    }
}
*/


/*
----------------------Brute Force---------------------------

TC - O(n^2)
SC - O(1)
*/
/*
class Solution
{
    public int majorityElement(int[] a)
    {
        if(a.length==0)
            return -1;
        
        int i,j,count=0;
        for(i=0;i<a.length;i++)
        {
            count=0;
            for(j=i+1;j<a.length;j++)
            {
                if(a[i]==a[j])
                    count++;
            }
            
            if(count>=a.length/2)
                return a[i];
        }
        return -1;
    }
}
*/