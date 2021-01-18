/*Decode the pattern - GeeksforGeeks Java Solution*/

import java.io.*;
import java.util.*;
  
public class DecodePattern
{
    private static String solve(int n)
    {
        if(n==1)
            return "1";
        if(n==2)
            return "11";
            
        String s="11";
        String temp;
        int i,c=1,j;
        
        for(i=3;i<=n;i++)
        {
            temp="";
            s=s+"$";
            c=1;
            for(j=1;j<s.length();j++)
            {
                if(s.charAt(j)!=s.charAt(j-1))
                {
                    temp+=c+0;
                    temp+= s.charAt(j-1); 
                    c=1; 
                }
                else
                    c++;
            }
            
            s=temp;
        }
        
        return s;
    }
    public static void main(String[] args) throws IOException 
    { 
  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        int t=Integer.parseInt(br.readLine()); 
    
        while(t-->0) 
        { 
            int n = Integer.parseInt(br.readLine()); 
            
            String res=solve(n);
            System.out.println(res);
        }
    }
}