/*204. Count Primes - Leetcode Java Solution*/

/*
TC - O(nloglogn)
SC - O(1)
*/
class SieveOfEratosthenes
{
    public int countPrimes(int n) 
    {
        if(n==0 || n==1)
            return 0;
        
        boolean prime[]=new boolean[n];
        int i,j,res=0;
        
        prime[0]=prime[1]=false;
        
        for(i=2;i<n;i++)
            prime[i]=true;
        
        for(i=2;i<Math.sqrt(n);i++)
        {
            if(prime[i]==true)
            {
                for(j=i*i;j<n;j=j+i)
                    prime[j]=false;
            }
        }
        
        for(i=0;i<n;i++)
        {
            if(prime[i]==true)
                res++;
        }
        
        return res;
    }
}