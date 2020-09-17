//784. Letter Case Permutation Leetcode Recursion Java Solution

class LetCasePerm
{
    public void solve(String ip,String op,List<String> list)
    {
        if(ip.length()==0)
        {
            list.add(op);
            return;
        }
        
        if(Character.isAlphabetic(ip.charAt(0)))
        {
            String op1=op;
            String op2=op;
            op1=op1+Character.toLowerCase(ip.charAt(0));
            op2=op2+Character.toUpperCase(ip.charAt(0));
            ip=ip.substring(1);
            solve(ip,op1,list);
            solve(ip,op2,list);
        }
        else
        {
            String op1=op;
            op1=op1+ip.charAt(0);
            ip=ip.substring(1);
            solve(ip,op1,list);
        }
    }
    public List<String> letterCasePermutation(String s)
    {
        String ip=s;
        String op="";
        List<String> list=new ArrayList<String>();
        
        solve(ip,op,list);
        
        return list;
    }
}
