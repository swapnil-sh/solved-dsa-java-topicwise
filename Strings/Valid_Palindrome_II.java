//680. Valid Palindrome II Leetcode Solution

class Valid_Palindrome_II
{
    public boolean validPalindrome(String s)
    {
        int i,j;
        i=0;
        j=s.length()-1;
        
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return (checkPal(s,i+1,j) || checkPal(s,i,j-1));
            
            i++;
            j--;
        }
        
        return true;
    }
    
    public boolean checkPal(String s,int i,int j)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;          
    }
}
