// Permutation with Spaces - GeeksforGeeks Java Solution


import java.util.*;
import java.lang.*;
import java.io.*;

class PermwithSpaces 
{
	public static void permSpaces(String ip,String op,ArrayList<String> list)
	{
		if(ip.length()==1)
		{
		    list.add(op);
		    return;
		}
		
		String op1=op;
		String op2=op;
		op1=op1+ip.charAt(1);
		op2=op2+" "+ip.charAt(1);
		ip=ip.substring(1);
		
		permSpaces(ip,op1,list);
		permSpaces(ip,op2,list);
		
	}
	public static void main (String[] args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t;
		t=Integer.parseInt(br.readLine());
		while(t!=0)
		{
			String ip=br.readLine();
			String op="";
			ArrayList<String> list=new ArrayList<String>();

			permSpaces(ip,op+ip.charAt(0),list);
			    
			Collections.sort(list);
			    
			for(int i=0;i<list.size();i++)
		        	System.out.print("("+list.get(i)+")");
		        
			System.out.println();
		    	t--;
		}
	}
}
