/*1365. How Many Numbers Are Smaller Than the Current Number - Leetcode Java Solutions*/

/*
------------------------------Sorting-----------------------------
TC - O(nlogn)
SC - O(n)
*/
/*
class CountOfNoSmThanCurrNo
{   
    public int[] smallerNumbersThanCurrent(int[] a) 
    {

        int i;
        int [] res = new int [a.length];    
        
        int sortedNums[] = a.clone();  
		Arrays.sort(sortedNums);
        // [8,1,2,2,3] =>  [1,2,2,3,8]
    
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
        for(i=0;i<sortedNums.length;i++)
        {
			// IMP if there are duplicates in the sorted arry,
            // store the index of the first occurence
            if(map.containsKey(sortedNums[i]))
				continue;
			
			map.put(sortedNums[i], i);
		}
    //[1,2,2,3,8]
    //Map contents
    //1,0
    //2,1
    //3,3
    //8,4
        
		for(i=0;i<sortedNums.length;i++)
            res[i]=map.get(a[i]);
            // nums => [8,1,2,2,3]
            //result => [4, 01, 1, 3]
		
		return res;
    }
}

/*
------------------------------Brute Force-----------------------------
TC - O(n^2)
SC - O(n)
*/
/*
class Solution
{
    public int[] smallerNumbersThanCurrent(int[] a) 
    {
        int i,j,c=0,n=a.length;
        int res[]=new int[n];
        
        for(i=0;i<n;i++)
        {
            c=0;
            for(j=0;j<n;j++)
            {
                if(a[j]<a[i])
                    c++;
            }
            
            res[i]=c;
        }
        
        return res;
        
    }
}
*/