/* Special array reversal - GeeksforGeeks Java Solutions*/

/*
-----------------Optimized Solution---------------------
TC - O(n)
SC - O(1)
*/
class SpArrayReversal
{
    public String reverse(String s)
    {
        //complete the function here
        char cArr[]=s.toCharArray();
        int j=s.length()-1,i=0;
        
        while(i<=j)
        {
            if(!(cArr[i]>=97 && cArr[i]<=122) && !(cArr[i]>=65 && cArr[i]<=90))
                i++;
                
            else if(!(cArr[j]>=97 && cArr[j]<=122) && !(cArr[j]>=65 && cArr[j]<=90))
                j--;
            
            else
            {
                char c=cArr[i];
                cArr[i]=cArr[j];
                cArr[j]=c;
                i++;
                j--;
            }
                
            
        }
        
        return new String(cArr);
    }
}


/*
-----------------Brute Force---------------------
TC - O(n)
SC - O(n)
*/
/*
class Solution
{
    public String reverse(String s)
    {
        //complete the function here
        char cArr[]=new char[s.length()];
        int j=s.length()-1,i=0;
        
        while(i<=j)
        {
            if(!(s.charAt(i)>=97 && s.charAt(i)<=122) && !(s.charAt(i)>=65 && s.charAt(i)<=90))
            {
                cArr[i]=s.charAt(i);
                i++;
                
            }
            else if(!(s.charAt(j)>=97 && s.charAt(j)<=122) && !(s.charAt(j)>=65 && s.charAt(j)<=90))
            {
                cArr[j]=s.charAt(j);
                j--;
            }
            else
            {
                cArr[i]=s.charAt(j);
                cArr[j]=s.charAt(i);
                i++;
                j--;
            }
                
            
        }
        
        return new String(cArr);
    }
}
*/