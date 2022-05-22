/*1. Two Sum - Leetcode Java Solutions
https://leetcode.com/problems/two-sum/
*/

/*
---------------------Single Pass HashMap Solution------------------------------

TC - O(n)
SC - O(n)

*/
/*
class TwoSum
{
    public int[] twoSum(int[] a, int t)
    {
        int res[]=new int[2];
        if(a.length==0)
            return res;
        
        int n=a.length;
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i=0,diff=0;
        

        for(i=0;i<n;i++)
        {
            diff=t-a[i];
            if(hm.containsKey(diff))
            {
                res[0]=i;
                res[1]=hm.get(diff);
                break;
            }
            
            hm.put(a[i],i);
        }
        return res;
    }
}
*/


/*
-----------------------Two Pass HashMap Solution-----------------------------------

TC - O(n)
SC - O(n)

*/
/*
class Solution 
{
    public int[] twoSum(int[] a, int t)
    {
        int res[]=new int[2];
        if(a.length==0)
            return res;
        
        int n=a.length;
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i=0,diff=0;
        
        
        for(i=0;i<n;i++)
            hm.put(a[i],i);

        
        for(i=0;i<n;i++)
        {
            diff=t-a[i];
            if(hm.containsKey(diff) && i!=hm.get(diff))
            {
                res[0]=i;
                res[1]=hm.get(diff);
                break;
            }
        }
        return res;
    }
}
*/

/*
----------------------------Brute Force Solution----------------------------------

TC - O(n^2)
SC - O(1)

*/

/*class Solution {
    public int[] twoSum(int[] a, int t) {

        int res[]=new int[2];
        if(a.length==0)
            return res;
        
        int i,j,diff=0;
        int n=a.length;
        
        for(i=0;i<n-1;i++) {
            diff=t-a[i];
            for(j=i+1;j<n;j++){
            	if(a[j]==diff){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return null;
    }
}*/