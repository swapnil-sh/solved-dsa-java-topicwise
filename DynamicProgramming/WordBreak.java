/*Word Break - GeeksforGeeks Java Solutions*/

/*
--------------------Recursive Solution-------------------------------

*/


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