/*find all possible combinations by replacing given digits with characters of corresponding list - Techie Delight Java Recursion*/

import java.io.*;
import java.util.*;

public class FindCombfromList 
	{
	    public static void findComb(List<List<Character>> list,int[] keys,String res,int index,Map<Integer,Character> map)
	    {
		if(index==-1)
		{
		    System.out.println(res+" ");//OUTPUT
		    return;
		}

		int digit=keys[index];
		int len=list.get(digit).size();

		if(!map.containsKey(digit))
		{
		    for(int i=0;i<len;i++)
		    {
		        map.put(digit,list.get(digit).get(i));
		        findComb(list,keys,list.get(digit).get(i)+res,index-1,map);
		        map.remove(digit);
		    }
		    return;
		}

		findComb(list,keys,map.get(digit)+res,index-1,map);
	    }
		public static void main(String[] args)
		{
			
			List<List<Character>> list = Arrays.asList(
					Arrays.asList( 'A', 'B', 'C', 'D' ),
					Arrays.asList( 'E', 'F', 'G', 'H', 'I', 'J', 'K' ),
					Arrays.asList( 'L', 'M', 'N', 'O', 'P', 'Q' ),
					Arrays.asList( 'R', 'S', 'T' ),
					Arrays.asList( 'U', 'V', 'W', 'X', 'Y', 'Z' )
			);

			
			int[] keys = {0, 2, 0};//INPUT

			
			Map<Integer, Character> map = new HashMap<Integer, Character>();

			
			findComb(list,keys,"",keys.length-1,map);
		}

	}
