/*Word Break - GeeksforGeeks Java Solutions*/


/*
--------------------Tabulation Solution-------------------------------

*/

class WordBreak
{
    private static int solve(String s, Set<String> dict)
    {
        int T[][] = new int[s.length()][s.length()];
        
        for(int i=0; i < T.length; i++)
        {
            for(int j=0; j < T[i].length ; j++)
            {
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }
        
        //fill up the matrix in bottom up manner
        for(int l = 1; l <= s.length(); l++)
        {
            for(int i=0; i < s.length() -l + 1 ; i++)
            {
                int j = i + l-1;
                String str = s.substring(i,j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(dict.contains(str))
                {
                    T[i][j] = i;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true 
                for(int k=i+1; k <= j; k++)
                {
                    if(T[i][k-1] != -1 && T[k][j] != -1)
                    {
                        T[i][j] = k;
                        break;
                    }
                }
            }
            
        }
        
        if(T[0][s.length()-1] == -1)
            return 0;
        else
            return 1;
    }
    
    public static int wordBreak(String s, ArrayList<String> dict)
    {
        //code here
        Set<String> hs=new HashSet<>();
        int i;
        
        for(i=0;i<dict.size();i++)
            hs.add(dict.get(i));
        
        return solve(s,hs);
    }
}
/*
--------------------Memoization Solution-------------------------------

*/
/*
class WordBreak
{
    static HashMap<String, Integer> dp=new HashMap<>();
    private static int solve(String s, Set<String> hs)
    {
        int size=s.length();
        if(size==0)
            return 1;
        
        if(dp.containsKey(s) && dp.get(s)!=0)
            return dp.get(s);
        
        int i,j;
        for(i=1;i<=size;i++)
        {
            String s1=s.substring(0,i);
            if(hs.contains(s1) && solve(s.substring(i, size), hs)==1)
            {
                dp.put(s, 1);
                return 1;
            }
        }
        
        return 0;
    }
    public static int wordBreak(String s, ArrayList<String> dict)
    {
        //code here
        Set<String> hs=new HashSet<>();
        int i;
        
        for(i=0;i<dict.size();i++)
            hs.add(dict.get(i));
        
        return solve(s,hs);
    }
}
*/
/*
--------------------Recursive Solution-------------------------------

*/
/*
class WordBreak
{
    private static boolean solve(String s, Set<String> hs)
    {
        int size=s.length();
        
        if(size==0)
            return true;
        
        int i;
        for(i=1;i<=s.length();i++)
        {
            // Now we will first divide the word into two parts , 
            // the prefix will have a length of i and check if it is  
            // present in dictionary ,if yes then we will check for  
            // suffix of length size-i recursively. if both prefix and  
            // suffix are present the word is found in dictionary. 
  
            if(hs.contains(s.substring(0,i)) && solve(s.substring(i,size), hs)) 
                return true; 
        }
        
        return false;
    }
    public static int wordBreak(String s, ArrayList<String> dict)
    {
        //code here
        Set<String> hs=new HashSet<>();
        int i;
        
        for(i=0;i<dict.size();i++)
            hs.add(dict.get(i));
        
        return solve(s,hs)==true?1:0;
    }
}
*/