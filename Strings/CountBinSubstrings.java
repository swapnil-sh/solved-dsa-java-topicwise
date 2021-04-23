/*696. Count Binary Substrings - Leetcode Java Solutions*/

/*
TC - O(n)
SC - O(1)
*/
class CountBinSubstrings
{
    public int countBinarySubstrings(String s)
    {
        int i,j=0,res=0;
        int currGr=1, prevGr=0;
        
        for(i=1;i<s.length();i++)
        {
            if(s.charAt(i)!=s.charAt(i-1))
            {
                res+=Math.min(currGr, prevGr);
                prevGr=currGr;
                currGr=1;
            }
            else
                currGr++;
        }
        
        res+=Math.min(currGr, prevGr);
        return res;
    }
}

/*
TC - O(n)
SC - O(n)
*/
/*
class Solution 
{
    public int countBinarySubstrings(String s)
    {
        int a[]=new int[s.length()];
        int i,j=0,res=0;
        a[0]=1;
        
        for(i=1;i<s.length();i++)
        {
            if(s.charAt(i)!=s.charAt(i-1))
            {
                j++;
                a[j]=1;
            }
            else
                a[j]++;
        }
        
        for(i=1;i<a.length;i++)
            res+=Math.min(a[i-1], a[i]);
        
        return res;
    }
}	
*/
