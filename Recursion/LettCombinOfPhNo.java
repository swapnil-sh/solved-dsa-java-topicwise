/*17. Letter Combinations of a Phone Number - Leetcode Recursion DFS approach
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
*/


/*
-------------------------Recursive Approach - 1 --------------------------------

For each number we will have 3 letters so we are storing the values using a hashmap(unordered set) 
And we are doing our work for the first number and asking recursion to do other task as we have 3 letters we are traversing those letters and calling recursive functions and pushing the answers into temp and doing backtracking step and finding ans and stopping the tree when it reaches bound.

Time complexity: O(3^N) [ As most of the letters has 3 choices so we can approximately say time complexity as 3^N]
Space Complexity: O(N) [ N is the size of the given string. This is because we can only process till i < s.size() , that's why Space Complexity is O(N)]

*/

class LettCombinOfPhNo {
    public List<String> letterCombinations(String digits) {
        
        String keyValues[] = {"","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.length() == 0)
            return res;
        
        util(keyValues, digits, 0, "", res);
        return res;
    }
    
    private void util(String[] keyValues, String digits, int i, String op, List<String> res) {
        
        if(i >= digits.length()) {
            res.add(op);
            return;
        }
            
        
        String s = keyValues[Character.getNumericValue(digits.charAt(i))-1];
        
        for(int j = 0; j < s.length(); j++) {
            op = op + s.charAt(j);
            util(keyValues, digits, i + 1, op, res);
            op = op.substring(0, op.length()-1);
        }                    
    }
}

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
