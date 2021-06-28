/*219. Contains Duplicate II - Leetcode Java Solution*/


/*
------------------------Better Optimised HashSet Solution-----------------------------------

TC - O(n)
SC - O(k)
*/

class ContainsDupII{
    public boolean containsNearbyDuplicate(int[] a, int k) {
        
        HashSet<Integer> hs = new HashSet<Integer>();
        
        for(int i=0;i<a.length;i++){
            
            if(!hs.add(a[i])) 
                return true;
            if(i>=k){
                //Keep only k element in the set at a time
                hs.remove(a[i-k]);
            } 
        }
        
        return false;
    }
}

/*
------------------------Optimized HashMap SOlution------------------------------------------
TC - O(n)
SC - O(n)
*/
/*
class Solution {
    public boolean containsNearbyDuplicate(int[] a, int k) {
        
        HashMap<Integer, Integer> hm=new HashMap<>();
        
        for(int i=0;i<a.length;i++){
            
            if(hm.containsKey(a[i])){
                
                int j=hm.get(a[i]);
                if(a[j]==a[i]){
                
                    if(Math.abs(j-i)<=k)
                        return true;
                }
            }
            
            hm.put(a[i], i);
        }
     
        return false;
        
    }
}
*/