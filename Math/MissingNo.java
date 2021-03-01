/*268. Missing Number - Leetcode Java Solutions*/

/*
-------------------------Using Sum of N Nautural No's Formula----------------------

TC - O(n)
SC - O(1)

*/

class MissingNo
{
    public int missingNumber(int[] a)
    {
        int sum1=0,sum2=0,res=0,i;
        int n=a.length;
        for(i=0;i<n;i++)
        {
            sum1+=a[i];
        }
        
        sum2=n*(n+1)/2;
        res=Math.abs(sum2-sum1);
        
        return res;
    }
}


/*
Modification for Overflow  

    Approach: The approach remains the same but there can be overflow if n is large. In order to avoid integer overflow, pick one number from known numbers and subtract one number from given numbers. This way there won't have Integer Overflow ever.
    Algorithm: 
        Create a variable sum = 1 to which will store the missing number and a counter c = 2.
        Traverse the array from start to end.
        Update the value of sum as sum = sum - array[i] + c and update c as c++.
        Print the missing number as a sum.
*/

/*
class GFG
{

    // a represents the array
    // n : Number of elements in array a
    static int getMissingNo(int a[], int n) 
    {
        int total = 1;
        for (int i = 2; i <= (n + 1); i++)
        {
            total += i;
            total -= a[i - 2];
        }
        return total;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 5 };
        System.out.println(getMissingNo(arr, arr.length));
    }
}
*/

/*
------------------------Using XOR Bit Manip---------------------

Intuition

We can harness the fact that XOR is its own inverse to find the missing element in linear time.

Algorithm

Because we know that nums contains n numbers and that it is missing exactly one number on the range [0..n−1], we know that nnn definitely replaces the missing number in nums.
Therefore, if we initialize an integer to n and XOR it with every index and value, we will be left with the missing number. 
Consider the following example (the values have been sorted for intuitive convenience, but need not be):

TC - O(n)
SC - O(1)

*/


/*
class Solution 
{
    public int missingNumber(int[] nums) 
    {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) 
            missing ^= i ^ nums[i];
        
        return missing;
    }
}
*/



/*
-------------------------Using Sorting----------------------

TC - O(nlogn)
SC - O(1)

*/
/*
class Solution 
{
    public int missingNumber(int[] nums) 
    {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) 
	{
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) 
	{
            return 0;
        }

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) 
	{
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum)
	    {
                return expectedNum;
            }
        }

        // Array was not missing any numbers
        return -1;
    }
}
*/



/*
-------------------------Using HashSet----------------------

TC - O(n)
SC - O(n)

*/
/*
class Solution
{
    public int missingNumber(int[] nums) 
    {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++)
	{
            if (!numSet.contains(number))
	    {
                return number;
            }
        }
        return -1;

*/