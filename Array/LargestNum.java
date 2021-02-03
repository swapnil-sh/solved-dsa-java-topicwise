/*Largest Number - InterviewBit Java Solutions*/

/*
-------------------Using Comparator---------------------

TC - O(nlogn)
SC - O(n)
*/

public class LargestNum
{
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public String largestNumber(final int[] A)
    {
        String[] s=new String[A.length];
        int i;
        String res="";
        
        for(i=0;i<A.length;i++)
            s[i]=Integer.toString(A[i]);
        
        Arrays.sort(s, new Comparator<String>()
        {
            public int compare(String a, String b)
            {
                String o1=a+b;
                String o2=b+a;
                
                return o2.compareTo(o1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String st: s)
            sb.append(st);
        
        while(sb.charAt(0)=='0' && sb.length()>1)
            sb.deleteCharAt(0);
            
        return sb.toString();
    }
}
