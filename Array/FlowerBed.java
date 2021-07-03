/*605. Can Place Flowers - Leetcode Java SOolution*/

/*
TC - O(n)
SSC - O(n)
*/

class FlowerBed{
    public boolean canPlaceFlowers(int[] a, int n) {
        
        if((a.length==1 && a[0]==0) || n==0)
            return true;
        
        int i=0,c=0;
        while(i<a.length){
            
            if(a[i]==0){
                
                if(i>0 && i<a.length-1 && a[i-1]==0 && a[i+1]==0){
                    n--;
                    a[i]=1;
                }
                    
                else if((i==0 && a.length!=1 && a[i+1]==0) || (i==a.length-1 && a.length!=1 && a[i-1]==0)){
                    n--;
                    a[i]=1;
                }
            }
            
            if(n==0)
                return true;
            
            i++;
        }
        
        return false;
    }
}