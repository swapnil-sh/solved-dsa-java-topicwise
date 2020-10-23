/* Find position of set bit  - GeeksforGeeks Java Solution using rsb and power of two */

class PosOfSetBit 
{
    static int findPosition(int n) 
    {
        // code here
        
        int x=n;
        int rsb=0;
        int count=0;
        
        while(x!=0)
        {
            rsb=x&-x;
            x=x-rsb;
            count++;
        }
        
        if(count>1 || count==0)
            return -1;
        
        int p=0;
        while((1<<p)<=n)
            p++;
        
        p--;
        return p+1;
    }
}