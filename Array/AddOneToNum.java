/*Add One to Number - InterviewBit Array Section Java Solution*/

public class AddOneToNum
{
    public int[] plusOne(int[] a) 
    {
        ArrayList<Integer> res=new ArrayList<>();
        int n=a.length;
        int i,carry=1,count=0;
        
        for(i=0;i<n-1;i++)
        {
            if(a[i]==9)
                count++;
            else
                break;
        }
        
        if(count==n)
        {
            for(i=0;i<n;i++)
                res.add(0);
        }
        else if(a[n-1]==9)
        {
            i=n-1;
            while(i>=0)
            {
                int sum=a[i]+carry;
                carry=sum/10;
                res.add(sum%10);
                i--;
            }
            if(carry==1)
                res.add(1);
        }
        else
        {
            for(i=n-1;i>=0;i--)
            {
                if(i==n-1)
                    res.add(a[i]+1);
                else
                    res.add(a[i]);
            }
        }
        
        count=0;
        for(i=res.size()-1;i>=0;i--)
        {
            if(res.get(i)==0 && res.size()>=1)
                res.remove(i);
            else
                break;
        }
        
        
        int ans[]=new int[res.size()];
        int j=0;
        if(res.size()==1)
        {
            ans[0]=res.get(0);
            return ans;
        }
        else
            for(i=res.size()-1;i>=0;i--)
                ans[j++]=res.get(i);
        
        return ans;
        
    }
}
