/*1011. Capacity To Ship Packages Within D Days - Leetcode Binary Search and Brute Force Java Solution*/

class MinCap 
{
	/*
		weights = [1,2,3,4,5,6,7,8,9,10],
		D = 5 (divide array in 5 parts)
		Output: 15
		[1,2,3,4,5],[6,7],[8],[9],[10]
		min=10(max value that can be shipped on 1 day) max=55(sum of all elements)
	    
		Solution 1:
		
		Start from min value and check how many days it will take if we take max wt to be min 
		T.C = O(n*(min-max))

		Solution 2:

		Apply Binary search within range of min-max
		T.C = O(n*log(min-max))
 	*/

    public int findReqDays(int w[],int cap)
    {
        int days=1,sum=0;
        
        for(int weight:w)
        {
            if(sum+weight>cap)
            {
                sum=weight;
                days++;
            }
            else
                sum+=weight;
        }
        
        return days;
        
    }
    public int shipWithinDays(int[] w, int D)
    {
        int min = 0, max = 0;
        for (int weight : w) 
        {
            min = Math.max(min, weight);
            max += weight;
        }
        
        int res=0;
        while(min<=max)
        {
            int mid=min+(max-min)/2;
            int reqDays=findReqDays(w,mid);
            if(reqDays>D)
                min=mid+1;
            else
            {
                res=mid;
                max=mid-1;
            }
                
        }
        
        return res;
    }
    
    /*public int shipWithinDays(int[] w, int D)
    {
        int min = 0, max = 0;
        for (int weight : w) 
        {
            min = Math.max(min, weight);
            max += weight;
        }
      
        int temp=min;
        while(temp<=max)
        {
            int day = 1, sum = 0;
            for (int weight : w) 
            {
                if (sum+weight>temp)
                {
                    sum=weight;
                    day++;
                }
                else
                    sum+=weight;
            }
            
            if(day<=D)
                break;
            temp++;
            
        }
        return temp;
        
    }
*/
}
