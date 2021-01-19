/*Move all zeroes to end of array - GeeksforGeeks Java Solution*/


/*
-----------------Count Non Zero Elem-----------------------

TC - O(n)
SC - O(1)
*/
class MoveZeroesToEnd
{
    void pushZerosToEnd(int[] a, int n) 
    {
        // code here
        int i,j=0;
        for(i=0;i<n;i++)
        {
            if(a[i]!=0)
                a[j++]=a[i];
        }
        
        while(j<n)
            a[j++]=0;
    }
}