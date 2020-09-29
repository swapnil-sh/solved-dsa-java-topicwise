/*392. Is Subsequence - Leetcode Two Pointers Java Solution*/

class ISSubseq 
{
    public boolean isSubsequence(String s, String t) 
    {
        int i=0,j=0,count=0;
        
        while(i<s.length() && j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
                count++;
            }
            else
                j++;
            
        }
        if(count==s.length())
            return true;
        return false;
    }
}
