/*1909. Remove One Element to Make the Array Strictly Increasing - Leetcode Java Solutions*/


/*
-----------------------------Linear Solution-----------------------------------
TC - O(n)
SC - O(1)
*/
class MakeArrStrictIncr{
    public boolean canBeIncreasing(int[] a) {
        
        int i;
        boolean rem=false;
        
        for(i=1;i<a.length;i++){
            
            if(a[i-1]>=a[i]){
                
                if(rem)
                    return false;
                rem=true;
                if(i>1 && a[i-2]>=a[i])
                    a[i]=a[i-1];
            }
        }
        
        return true;
        
    }
}


/*
-------------------DP Solution--------------------------------
This question can be done iteratively but doing this ques with dp is fun and easy to understand if you don't know the concept of L I S this solution is not for you so the approach is simple and short find out the length of longest increasing subsequence and subtract it from total size of the array eg : 1 , 2 , 10 , 5 , 7 longest increasing subsequence is 1 -> 2 -> 5 ->7 of size 4 now Array Size - LIS = 1 
so we only need to remove one element this is possible return false if in case this diff is greater than 1
*/

/*
class Solution {
public:
    int lis(vector<int>& nums){
        int dp[nums.size()];
        dp[0] = 1 ;
        int oMax = 0;
        for(int i = 1 ;i<nums.size();i++){
            int mx = 0;
            for(int j = 0 ; j<i; j++){
                if(nums[i]>nums[j]){
                    mx = max(mx, dp[j]);
                }
            }
            dp[i] = mx+1;
            oMax = max(oMax,dp[i]);
        }
        return oMax;
    }
    bool canBeIncreasing(vector<int>& nums) {
        int ls = lis(nums);
        int x = nums.size()-ls;
        return x<2;
    }
};
*/