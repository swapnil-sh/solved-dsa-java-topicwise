class Solution:
    def maxProfit(self, a: List[int]) -> int:
    
        i = 0
        buy = a[0]
        sell = a[0]
        profit = 0
        
        while(i<len(a)-1):
            
            while(i<len(a)-1 and a[i]>=a[i+1]):
                i=i+1
            buy=a[i]
            
            while(i<len(a)-1 and a[i]<=a[i+1]):
                i=i+1
            sell=a[i]
            
            profit=profit+sell-buy
        return profit
