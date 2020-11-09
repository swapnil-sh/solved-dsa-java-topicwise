/*31. Next Permutation - Leetcode Java Solution*/

/*
-------------------------Optimal Solution-------------------------------------

1.Find the first smaller number from last
2.Find the smallest number greater than the smaller number found above
3.Swap the two numbers
4.Reverse after the ith position



TC - O(n)
SC - O(1)

In-place
*/

class NextPerm
{
    void swap(int a[],int i, int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    
    public void nextPermutation(int[] a)
    {
        int i,j;
        int n=a.length;
        
        i=n-2;
        
        while(i>=0 && a[i+1]<=a[i])
            i--;
        
        if(i>=0)
        {
            j=n-1;
            while(j>=0 && a[j]<=a[i])
                j--;
            
            swap(a,i,j);
        }
        
        int st=i+1;
        int end=n-1;
        while(st<end)
        {
            swap(a,st,end);
            st++;
            end--;
        }
        
    }
}

/*
---------------Brute Force-------------------
Generate all the possible combos and sort them lexicographically and then check for the given number in the list of combos and return the next number.

TC - O(n!*n)
SC - O(n)

*/