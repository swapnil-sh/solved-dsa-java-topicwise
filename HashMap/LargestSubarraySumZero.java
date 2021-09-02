/*Largest subarray with 0 sum - GFG Java Solution 
https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
*/


/*
--------------------------Optimal Approach using HasmMap------------------------------
TC - O(n)
SC - O(n)
*/
class LargestSubarraySumZero
{
    int maxLen(int a[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> hm=new HashMap<>();
        
        int i,maxLen=0,currLen=0,sum=0;
        for(i=0;i<n;i++){
            
            sum+=a[i];
            if(sum==0)
                maxLen=i+1;
            else{
                
                if(hm.containsKey(sum))
                    maxLen=Math.max(maxLen, i-hm.get(sum));
                else
                    hm.put(sum,i);
            }
        }
        
        return maxLen;
    }
}



/*
--------------------------Brute Force Approach------------------------------
TC - O(n^2) or O(n^3) (Similar to KEdanes Algo finding all the subarrays and then checking for zero)
SC - O(1)
*/