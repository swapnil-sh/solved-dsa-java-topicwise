/*326. Power of Three - Leetcode Java Solutions*/

/*
------------------Using Log-------------------------
*/

class PowOf3
{
    public boolean isPowerOfThree(int n) 
    {
            return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}


/*
---------------------------MATH Solution-------------------

Find the maximum integer that is a power of 3 and check if it is a multiple of the given input.

*/
/*
class Solution 
{
    public boolean isPowerOfThree(int n) 
    {
        int maxPowerOfThree = (int)Math.pow(3, (int)(Math.log(0x7fffffff) / Math.log(3)));
        return n>0 && maxPowerOfThree%n==0;
    }
}
*/

/*
--------------Recursive Solution--------------------------
*/
/*
class Solution 
{
    public boolean isPowerOfThree(int n) 
    {
        return n>0 && (n==1 || (n%3==0 && isPowerOfThree(n/3)));
    }
}
*/

/*
--------------Iterative Solution--------------------------
*/
/*
class Solution 
{
     public boolean isPowerOfThree(int n)
     {
    	if(n>1)
            while(n%3==0) n /= 3;
            return n==1;
     }
}
*/
