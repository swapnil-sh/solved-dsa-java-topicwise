//1347. Minimum Number of Steps to Make Two Strings Anagram - Leetcode Java Solution

class MinStepAnagram
{
    public int minSteps(String s, String t) 
    {
        
        HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
        int i;
        char c;
        
        for(i=0;i<s.length();i++)
        {
            c=s.charAt(i);
            if(hmap.containsKey(c))
                hmap.put(c,hmap.get(c)+1);
            else
                hmap.put(c,1);
        }
//         for (Map.Entry<Character,Integer> entry : hmap.entrySet())  
//             System.out.println("Key = " + entry.getKey() + 
//                              ", Value = " + entry.getValue()); 
        
        for(i=0;i<t.length();i++)
        {
            c=t.charAt(i);
            if(hmap.containsKey(c))
            {
                if(hmap.get(c)==0)
                    hmap.put(c,0);
                else
                    hmap.put(c,hmap.get(c)-1);
            }
        }
        
        // for (Map.Entry<Character,Integer> entry : hmap.entrySet())  
        //     System.out.println("Key = " + entry.getKey() + 
        //                      ", Value = " + entry.getValue()); 
        
        int ans=0;
        for(Map.Entry<Character,Integer> entry : hmap.entrySet())
        {
            ans+=entry.getValue();
        }
        
        return ans;
    }
}
