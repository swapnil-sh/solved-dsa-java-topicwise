/*1346. Check If N and Its Double Exist -- Leetcode Java Solutions*/

/*
-----------------------HashSet Solution-----------------------------

TC - O(n)
SC - O(n)
*/

class CheckNDoubleExists{
    public boolean checkIfExist(int[] a) {
        
        int i;
        HashSet<Integer> hs=new HashSet<>();
        
        hs.add(a[0]);
        for(i=1;i<a.length;i++){
            
            if(hs.contains(a[i]*2) || (a[i]%2==0 && hs.contains(a[i]/2)))
                return true;
            hs.add(a[i]);
        }
        
        return false;
    }
}