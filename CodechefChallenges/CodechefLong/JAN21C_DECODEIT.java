/*
----------------------Using Binary Search-------------------------
*/

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 

public class JAN21C_DECODEIT
{ 
    public static void main(String[] args)throws IOException 
    { 
  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
  
        StringTokenizer stok=new StringTokenizer(br.readLine()); 
        int t=Integer.parseInt(stok.nextToken()); 

        while(t--!=0) 
        { 
            int n=Integer.parseInt(br.readLine()); 
            int i,j;
            String str=br.readLine();
		    String s="";
		    String res="";
		    
		    for(i=0;i<n;i=i+4)
            {
		       s=str.substring(i,i+4);
		            
		       int st=0;
		       int mid=0;
		       
		      String arr="abcdefghijklmnop";
		      int end=arr.length();
		      String a="";
		      
		      for(j=0;j<s.length();j++){
		          
		          if(s.charAt(j)=='0'){
		              mid=(st+end)/2;
		              a=arr.substring(st,mid);
		              end=mid;
		          }
		          else{
		              mid=(st+end)/2;
		              if(end==16)
		                  a=arr.substring(mid);
		              else
		                  a=arr.substring(mid,end);
		              st=mid;
		          }
		      }
		      res=res+a;
		    }
		    System.out.println(res);
        } 
    } 
} 



/*
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
  
public class Main
{ 
    public static void main(String[] args) throws IOException 
    { 
  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
  
        StringTokenizer st=new StringTokenizer(br.readLine()); 
        int t=Integer.parseInt(st.nextToken()); 

        while (t--!=0) 
        { 
            int n=Integer.parseInt(br.readLine()); 
            int i;
            String s=br.readLine();
            String sArr[]=new String[n/4];
            int k=0;
            for(i=0;i<n;i=i+4)
            {
                sArr[k]=s.substring(i, i+4);
                //System.out.println(sArr[k]);
                k++;
            }

            String alph="abcdefghijklmnop";
            String res="";
            for(i=0;i<sArr.length;i++)
            {
                int decimal=Integer.parseInt(sArr[i],2); 
                res=res+alph.charAt(decimal);
            }

            System.out.println(res);
        } 
    } 
} 

*/

/*
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 

public class Main
{ 
    public static void main(String[] args) throws IOException 
    { 
  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
  
        StringTokenizer st=new StringTokenizer(br.readLine()); 
        int t=Integer.parseInt(st.nextToken()); 

        while (t--!=0) 
        { 
            int n=Integer.parseInt(br.readLine()); 
            int i;
            String s=br.readLine();
            String res="";
            //String alph="abcdefghijklmnop"; 
            HashMap<String, Character> hm=new HashMap<>();

            hm.put("0000", 'a');
            hm.put("0001", 'b');
            hm.put("0010", 'c');
            hm.put("0011", 'd');
            hm.put("0100", 'e');
            hm.put("0101", 'f');
            hm.put("0110", 'g');
            hm.put("0111", 'h');
            hm.put("1000", 'i');
            hm.put("1001", 'j');
            hm.put("1010", 'k');
            hm.put("1011", 'l');
            hm.put("1100", 'm');
            hm.put("1101", 'n');
            hm.put("1110", 'o');
            hm.put("1111", 'p');
            for(i=0;i<n;i=i+4)
            {
                String temp=s.substring(i, i+4);
                res=res+hm.get(temp);
            }

            System.out.println(res);
        } 
    } 
} 
*/
