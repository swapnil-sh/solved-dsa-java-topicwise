/*Word Break - GeeksforGeeks Java Solutions*/

/*
--------------------Memoization Solution-------------------------------

*/
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