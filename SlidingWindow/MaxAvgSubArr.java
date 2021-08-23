/*643. Maximum Average Subarray I - Leetcode Java Solutions (https://leetcode.com/problems/maximum-average-subarray-i/)*/


/*
-------------Sliding Window Solution----------------- 

TC - O(n)
SC - O(1)
*/
class MaxAvgSubArr {
    public double findMaxAverage(int[] a, int k) {
        
        int n=a.length;
        int i=0,j=0;
        double avg=0.0,maxAvg=Integer.MIN_VALUE,sum=0.0;
        
        while(j<n){
            
            sum+=a[j];
            if(j-i==k-1){
                
                avg=sum/k;
                maxAvg=Math.max(avg, maxAvg);
                sum-=a[i];
                i++;
                j++;
            }
            else
                j++;
            
        }
        
        return maxAvg;
        
    }
}

/*
-------------Brute Force Solution----------------- 

TC - O(k*(n-k))
SC - O(1)
*/

/*
class Solution {
    public double findMaxAverage(int[] a, int k) {
        
        
        int n=a.length;
        if(n==1 && k==1)
            return a[0]/1;
        int i=0,j=0;
        double avg=0.0,maxAvg=Integer.MIN_VALUE,sum=0.0;
        
        while(i<=n-k){
            sum=0.0;
            for(j=i;j<i+k;j++)
                sum+=a[j];
            avg=sum/k;
            maxAvg=Math.max(avg, maxAvg);
            i++;
            
        }
        
        return maxAvg;
        
    }
}
*/

