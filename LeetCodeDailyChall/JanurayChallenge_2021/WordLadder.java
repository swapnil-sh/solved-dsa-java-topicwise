/*127. Word Ladder - Leetcode Java Solution (HARD)*/


/*
-----------------------BFS Approach---------------------------

*/
class WordLadder
{
    private void transformStr(String w, Queue<String> q, HashMap<String,Boolean> hm)
    {
        int i,j;
        for(i=0;i<w.length();i++)
        {
            char cArr[]=w.toCharArray();
            for(j=0;j<26;j++)
            {
                char ch=(char)('a'+j);
                cArr[i]=ch;
                String s=String.valueOf(cArr);
                
                if(hm.containsKey(s) && hm.get(s)==false)
                {
                    q.offer(s);
                    hm.put(s, true);
                }
            }
        }
        
        
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        if(!wordList.contains(endWord))
            return 0;
        
        int i,j,res=1;
        HashMap<String, Boolean> hm=new HashMap<>();
        Queue<String> q=new LinkedList<>();
        
        for(i=0;i<wordList.size();i++)
            hm.put(wordList.get(i), false);
        
        
        q.offer(beginWord);
        hm.put(beginWord, true);
        
        while(!q.isEmpty())
        {
            int size=q.size();
            for(j=0;j<size;j++)
            {
                String w=q.poll();
                if(w.equals(endWord))
                    return res;
                
                transformStr(w,q,hm);
            }
            res++;
        }
        
        
        return 0;
    }
}