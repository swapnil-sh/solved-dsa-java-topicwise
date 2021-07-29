/*1346. Check If N and Its Double Exist - Leetcode Java Solutions*/

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


/*
---------------------Binary Search Solution------------------------------

TC - O(nlogn)
SC - O(1)
*/
/*
class Solution {
    
    public int binarySearch(int a[], int x){
        
        int st=0;
        int end=a.length-1;
        
        while(st<=end){
            
            int mid=st+(end-st)/2;
            if(a[mid]==x)
                return mid;
            else if(x>a[mid])
                st=mid+1;
            else
                end=mid-1;
        }
        
        return -1;
    }
    public boolean checkIfExist(int[] a) {
        
        
        Arrays.sort(a);
        
        int i,zeroCount=0;
        for(i=0;i<a.length;i++){
            
            if(a[i]!=0){
                
                int index=binarySearch(a, a[i]*2);
                if(index!=-1 && index!=i)
                    return true;
            }
            else
                zeroCount++;
        }
        
        return zeroCount>=2;
    }
}
*/