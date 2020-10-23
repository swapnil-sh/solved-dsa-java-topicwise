/* Finding the numbers  - GeeksforGeeks Java Solution using Bit Manipulation*/


class FindTwoNonRepNo
{
    public int[] singleNumber(int[] a)
    {
        // Code here
        int sum=0;
        int i;
        for(i=0;i<a.length;i++)
            sum=sum^a[i];
        
        sum=sum&-sum;
        int x=0;
        int y=0;
        
        int res[]=new int[2];
        for(i=0;i<a.length;i++)
        {
            if((a[i]&sum)>0)
                res[0]=res[0]^a[i];
            else
                res[1]=res[1]^a[i];
        }
        
        if(res[0]>res[1])
        {
            int temp=res[0];
            res[0]=res[1];
            res[1]=temp;
            
            return res;
        }
        return res;   
    }
}