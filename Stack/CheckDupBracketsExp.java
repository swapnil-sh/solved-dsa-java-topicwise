/*Expression contains redundant bracket or not - GeeksforGeeks Java Solution*/


/*
------------------------------------Using Stack--------------------------------------

Time complexity: O(n)
Auxiliary space: O(n)
*/

import java.io.*; 
import java.util.*; 
  
public class CheckDupBracketsExp
{ 
    public static void main(String[] args) throws IOException 
    { 
  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        int t=Integer.parseInt(br.readLine()); 
        while(t-->0) 
        { 
            String s=br.readLine(); 
            int i,flag=0;
            char ch='a';
            Stack<Character> st=new Stack<>();

            for(i=0;i<s.length();i++)
            {
                ch=s.charAt(i);
                if(ch==')')
                {
                    char top=st.peek();
                    st.pop();

                    flag=1;
                    while(!st.isEmpty() && top!='(')
                    {
                        if(top=='+' || top=='-' || top=='/' || top=='*')
                            flag=0;
                        top=st.peek();
                        st.pop();

                    }

                    if(flag==1)
                    {
                        System.out.println("YES");
                        break;
                    }
                }
                else
                    st.push(ch);
            }

            if(flag==0)
                System.out.println("No"); 
        } 
    } 
} 
