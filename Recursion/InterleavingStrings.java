//Print all interleavings of given two strings - Java Recursion Solution GFG and Techie Delight

import java.io.*;
import java.util.*;

public class InterleavingStrings 
{
    public static void interleavings(String ip1,String ip2,String op,Set<String> list)
    {
        if(ip1.length()==0 && ip2.length()==0)
        {
            list.add(op);
            return;
        }

        if(ip1.length()>0)
        {
            String op1=op;
            op1=op1+ip1.charAt(0);
            interleavings(ip1.substring(1),ip2,op1,list);
        }

        if(ip2.length()>0)
        {
            String op2=op;
            op2=op2+ip2.charAt(0);
            interleavings(ip1,ip2.substring(1),op2,list);
        }

    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String ip1=br.readLine();
        String ip2=br.readLine();
        String op="";
        Set<String> list=new HashSet<>();

        interleavings(ip1,ip2,op,list);
        
        System.out.println(list.size());
	list.stream().forEach(System.out::println);
    }
}
