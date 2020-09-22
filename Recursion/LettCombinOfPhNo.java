//17. Letter Combinations of a Phone Number - Leetcode Recursion DFS approach

class LettCombinOfPhNo
{
    public static void solve(String digits,int index,HashMap<Character, char[]> dict,char cArr[],ArrayList<String> res) 
    {
        if(index==digits.length())
        {
            res.add(new String(cArr));
            return;
        }

        char[] letters=dict.get(digits.charAt(index));
        for(int i=0;i<letters.length;i++)
        {
            cArr[index]=letters[i];
            solve(digits,index+1,dict,cArr,res);
        }

    }
 
    public List<String> letterCombinations(String digits)
    {
        
        HashMap<Character, char[]> dict = new HashMap<Character, char[]>();
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});


        ArrayList<String> res=new ArrayList<String>();
        if(digits==null||digits.length()==0)
            return res;
        
         char[] cArr=new char[digits.length()];
         solve(digits,0,dict,cArr,res);
        
        return res;
        
    }
}
