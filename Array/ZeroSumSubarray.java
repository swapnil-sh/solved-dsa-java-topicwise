/*Find if there is a subarray with 0 sum - GeeksforGeeks Java Solution*/


/*
-------------------------Using HashSet----------------------------------
TC - O(n)
SC - O(n)
*/

class ZeroSumSubarray 
{
    // Returns true if arr[] 
    // has a subarray with sero sum
    static Boolean subArrayExists(int arr[])
    {
        // Creates an empty hashset hs
        Set<Integer> hs = new HashSet<Integer>();
 
        // Initialize sum of elements
        int sum = 0;
 
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) 
        {
            // Add current element to sum
            sum += arr[i];
 
            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            if (arr[i] == 0
                || sum == 0
                || hs.contains(sum))
                return true;
 
            // Add sum to hash set
            hs.add(sum);
        }
 
        // We reach here only when there is
        // no subarray with 0 sum
        return false;
    }

/*
class SubarraySum
{ 

    int subArraySum(int arr[], int n, int sum) 
    { 
        int curr_sum, i, j; 
  
        // Pick a starting point 
        for (i = 0; i < n; i++) 
	{ 
            curr_sum = arr[i]; 
  
            // try all subarrays starting with 'i' 
            for (j = i + 1; j <= n; j++) 
	    { 
                if(curr_sum == sum)
		{ 
                    int p = j - 1; 
                    System.out.println( "Sum found between indexes " + i " and " + p); 
                    return 1; 
                } 
                if (curr_sum > sum || j == n) 
                    break; 
                curr_sum = curr_sum + arr[j]; 
            } 
        } 
  
        System.out.println("No subarray found"); 
        return 0; 
    }
}
*/