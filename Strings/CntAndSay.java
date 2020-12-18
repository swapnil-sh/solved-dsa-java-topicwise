/*38. Count and Say - Leetcode Java Solutions*/

/*

TC - O(n^2)
SC - O(1)
*/

class CntAndSay
{
    public String countAndSay(int n) 
    {

        String s="1";
        int i,j,count;
        
        for(i=1;i<=n-1;i++)
        {
            StringBuilder res = new StringBuilder();
            char c=s.charAt(0);
            count=1;
            for(j=1;j<s.length();j++)
            {
                if(c!=s.charAt(j))
                {
                    res.append(count);
                    res.append(c);
                    c=s.charAt(j);
                    count=1;   
                }
                else
                {
                    count++;
                }
            }
            res.append(count);
            res.append(c);
            s=res.toString();
            
        }
        
        return s;
        
    }
}


/*
class Solution 
{
    public String countAndSay(int n) 
    {
        
        if(n==1)
            return "1";
        if(n==2)
            return "11";
        
        String res="11";
        String temp="";
        int i,j,count=1;
        
        for(i=3;i<=n;i++)
        {
            temp="";
            res=res+"$";
            count=1;
             
            for(j=1;j<res.length();j++)
            {
                if(res.charAt(j)!=res.charAt(j-1))
                {
                    temp+=String.valueOf(count)+res.charAt(j-1);
                    //System.out.println(j+" "+temp);
                    count=1;
                }
                else
                    count++;
               
            }
            
            res=temp;
           
        }
        
        return res;
    }
}
*/