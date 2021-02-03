/*First Missing Integer - InterviewBit Java Solutions*/

/*
TC - O(n)
SC - O(1)
*/
public class FirstMissNo
{
    public int firstMissingPositive(ArrayList<Integer> A) 
    {
        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            int pos = num - 1;
            
            if (pos >= 0 && pos < A.size() && A.get(pos) != num) {
                A.set(i, A.get(pos));
                A.set(pos, num);
                i--;
            }
        }
        
        for (int i = 0; i < A.size(); i++)
            if (A.get(i) != i + 1)
                return i + 1;
        
        return A.size() + 1;
    
    }
}

/*
public class Solution {
    public int firstMissingPositive(int[] a) {
        
        int n=a.length;

        int j=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]<=0)
            {
                int tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
                j++;
            }
        }
        
         
        for(int i=j;i<n;i++)
        {
                int x=0;
                if(a[i]<0)x-=a[i];
                else x=a[i];
                x+=(j-1);
                if(x>=0 && x<n)a[x]=-a[x];
                
        }
        int ans=1;
        for(int i=j;i+j<n;i++)
        {
            if(a[i]>0)break;
            
            ans++;
            
        }
        return ans;
    }
}


*/


/*
public class Solution {
    public int firstMissingPositive(int[] A) 
    {
        Arrays.sort(A);
       int m=1;
       for(int i=0;i<A.length;i++)
       {
           if(A[i]>0)
           {
              if(m==A[i])
              m++;
              else
              return m;
           }
       }
       return m;
    }
}

*/
