//Find all binary strings that can be formed from given wildcard pattern - Techie Delight Java Recursion Solution

import java .io.*;
import java.util.*;

public class WildcardPerm
{
    public static void wildPerm(String ip,String op,ArrayList<String> list)
    {
        if(ip.length()==0)
        {
            list.add(op);
            return;
        }

        if(ip.charAt(0)=='?')
        {
            String op1=op;
            op1=op1+'1';
            String op2=op;
            op2=op2+'0';
            ip=ip.substring(1);
            wildPerm(ip,op1,list);
            wildPerm(ip,op2,list);
        }
        else
        {
            String op3=op+ip.charAt(0);
            ip=ip.substring(1);
            wildPerm(ip,op3,list);
        }
    
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip=br.readLine();
        String op="";
        ArrayList<String> list=new ArrayList<String>();
        wildPerm(ip,op,list);
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
}


/*
INPUT
"1?11?00?1?"

OUTPUT 
16
"1011000010"
"1011000011"
"1011000110"
"1011000111"
"1011100010"
"1011100011"
"1011100110"
"1011100111"
"1111000010"
"1111000011"
"1111000110"
"1111000111"
"1111100010"
"1111100011"
"1111100110"
"1111100111"
*/
