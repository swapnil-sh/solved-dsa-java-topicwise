/*475. Heaters - Leetcode Binary Search Java Soltuion*/

class Heaters 
{
    private int minRadius(int house, int[] heaters) 
    {
        int st=0;
        int end=heaters.length - 1;
        int min=Integer.MAX_VALUE;
        
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            
            if (heaters[mid] == house) 
                return 0;
            
            else if (heaters[mid]>house) 
            {
                min=Math.min(min,heaters[mid]-house);
                end=mid-1;
            } 
            else
            {
                min=Math.min(min,house-heaters[mid]);
                st=mid+1;
            }
        }
        return min;
    }  
    
    
    public int findRadius(int[] houses, int[] heaters) 
    {
        
        Arrays.sort(heaters);
        
        int i,r=0;
        for (i=0;i<houses.length;i++)
            r = Math.max(r, minRadius(houses[i], heaters));
        
        return r;
    }
}



/*Brute Force Solution*/


// class Solution 
// {
//     public int findRadius(int[] h, int[] w)
//     {
//         if(h.length==1 && w.length==1)
//             return Math.abs(w[0]-h[0]);
        
//         int i,j,rad=0;
//         int res[]=new int[h.length];
        
//         for(i=0;i<h.length;i++)
//         {
//             res[i]=0;
//         }
//         for(i=0;i<w.length;i++)
//         {
//             for(j=0;j<h.length;j++)
//             {
//                 int x=Math.abs(w[i]-h[j]);
//                 if(x==0)
//                     res[j]=-1;
//                 else
//                 {
//                     if(res[j]==0)
//                         res[j]=x;
//                     else
//                         res[j]=Math.min(res[j],x);
//                 }
                
//             }
//         }
        
//         Arrays.sort(res);
        
//         if(res[res.length-1]==-1)
//             return 0;
//         return res[res.length-1];
        
        
//     }
// }
