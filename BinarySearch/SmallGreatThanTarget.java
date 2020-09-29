/*744. Find Smallest Letter Greater Than Target - Leetcode Binary Search Java Solution*/

class SmallGreatThanTarget
{
    public char nextGreatestLetter(char[] a, char t) 
    {
        int st=0,end=a.length-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(a[mid]<=t)
                st=mid+1;
            else
                end=mid-1;
        }
        
        return a[st%a.length];
        
    }
}


/*class Solution
{
    public char nextGreatestLetter(char[] a, char t) 
    {
        int st=0,end=a.length-1;
        char c=' ';
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(a[mid]<=t)
            {
                
                st=mid+1;
            }
            else
            {
                c=a[mid];
                end=mid-1;
            }
        }
        
        if(c==' ' && a.length!=0)
            return a[0];
        return c;
        
    }
}*/
