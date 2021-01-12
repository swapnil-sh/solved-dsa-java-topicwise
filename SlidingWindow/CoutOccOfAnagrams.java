/*Count Occurences of Anagrams - GeeksforGeeks Java Solutions*/

/*
------------------------------Sliding Window----------------------------------------
TC - O(n)
SC - O(length(Pattern))

*/
class CoutOccOfAnagrams
{

    int search(String pat, String txt)
    {
        HashMap<Character, Integer> hm=new HashMap<>();
        int i;
        
        for(i=0;i<pat.length();i++)
        {
            char c=pat.charAt(i);
            if(hm.containsKey(c))
                hm.put(c, hm.get(c)+1);
            else
                hm.put(c, 1);
        }
        
        i=0;
        int j=0;
        int count=hm.size();
        int res=0;
        
        while(j<txt.length())
        {
            char ch=txt.charAt(j);
            if(hm.containsKey(ch))
            {
                hm.put(ch, hm.get(ch)-1);
                
                if(hm.get(ch)==0)
                    count--;
            }
            
            if(j-i+1==pat.length())
            {
                if(count==0)
                    res++;
                
                ch=txt.charAt(i);
                if(hm.containsKey(ch))
                {
                    hm.put(ch, hm.get(ch)+1);
                    if(hm.get(ch)==1)
                        count++;
                }
            
                i++;
                j++;
            }
            else
                j++;
        }
        
        return res;
    }
}