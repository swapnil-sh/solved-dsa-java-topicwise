/*697. Degree of an Array - Leetcode Java Solutions*/

/*
----------------Using HashMaps------------------

TC - O(n)
SC - O(n)
*/
class DegOfArr
{
    public int findShortestSubArray(int[] a)
    {
        if(a.length==0)
            return 0;
        
        HashMap<Integer,Integer> count=new HashMap<>();
        HashMap<Integer,Integer> st=new HashMap<>();
        HashMap<Integer,Integer> end=new HashMap<>();

        int i;
        for(i=0;i<a.length;i++)
            count.put(a[i], count.getOrDefault(a[i], 0)+1);

        for(i=0;i<a.length;i++)
        {
            if(!st.containsKey(a[i]))
                st.put(a[i], i);
            
            end.put(a[i], i);
        }

        int ans = a.length;
        int degree = Collections.max(count.values());
        
      
        for(int x: count.keySet())
        {
            if(count.get(x) == degree)
                ans = Math.min(ans, end.get(x) - st.get(x) + 1);
        }
        
        return ans;
        
    }
}

/*
--------------Brute Force Solution--------------

TC - O(n^2)
SC - O(n)
*/

/*
class Solution 
{
    public int degree(int[] arr,int start,int end)
    {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();

        for(int i=start;i<=end;i++)
            if(hm.containsKey(arr[i]))
                hm.put(arr[i],hm.get(arr[i])+1);
            else
                hm.put(arr[i],1);
        return Collections.max(hm.values());
    }

    public int findShortestSubArray(int[] nums)
    {
        int minlen=nums.length;
        int ardeg=degree(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++)
            for(int j=i+1;j<nums.length;j++)
            {
                if(degree(nums,i,j)==ardeg)
                    if((j-i+1)<minlen)
                        minlen=j-i+1;
            }
        return minlen;
    }
}
*/