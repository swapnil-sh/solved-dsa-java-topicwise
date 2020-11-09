/* First non-repeating character in a stream - GeeksforGeeks Java Solution*/

//------------------------Using Queue and Hashmap O(n)------------------------------------

import java.util.*;

class FirNonRepChar
{
    public static void printFirstNonRepeatingCharactersInStream(char[] stream) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        
        for(int i = 0; i < stream.length; i++) 
        {
          map.put(stream[i], map.getOrDefault(stream[i], 0) + 1);
          
          if(map.get(stream[i]) == 1) {
            q.add(stream[i]);
          }
            
          while(!q.isEmpty()) 
          {
                char c = q.peek();
                if(map.get(c) == 1) 
                  break;
                else 
                  q.remove();
                
          }
          
          if(q.isEmpty())
            System.out.print(-1 + " ");
           else 
            System.out.print(q.peek() + " ");
          
        }
    }
	public static void main (String[] args)
	{
	        Scanner sc = new Scanner(System.in);
		    int t = sc.nextInt();               // test case input
		    while(t--!=0)
		    {
		        int n = sc.nextInt();  
		        char crr[]=new char[n];// input
		        for(int i=0;i<n;i++)
                {
                    char c=sc.next().charAt(0);
                    crr[i]= c;
                }
                
                printFirstNonRepeatingCharactersInStream(crr);
                System.out.println();
		    }
	}
}

/*
-------------------------Brute Force Approach-------------------------------------


*/

/*
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static String solve(String s)
    {
        int freq[]=new int[26];
        int i,j,flag=0;
        String res="";
        res+=s.charAt(0);
        freq[Math.abs('a'-s.charAt(0))]++;
        char c='a';
        for(i=1;i<s.length();i++)
        {
            freq[Math.abs('a'-s.charAt(i))]++;
            for(j=0;j<=i;j++)
            {
                if(freq[Math.abs('a'-s.charAt(j))] == 1)
                {
                    res+=" "+s.charAt(j);
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                res+=" "+"-1";
        }
        
        return res;
    }
	public static void main (String[] args)throws IOException
	{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int t;
	    t = Integer.parseInt(br.readLine());
	    
	    while(t-->0)
	    {
	        int n=Integer.parseInt(br.readLine());
	        //char c[] = new int[n];
            String s = br.readLine(); // to read multiple integers line
            String[] strs = s.trim().split("\\s+");
            s="";
            for (int i=0;i<n;i++) 
                s+=strs[i].charAt(0);
            
            System.out.println(solve(s));
            
	    }
	    
	}
}
*/
