/*414. Third Maximum Number - Leetcode Java SOlutions*/

/*
--------------------------Linear Solution-----------------------------------
TC - O(n)
SC - O(1)
*/
class ThirdMaxNo{
    public int thirdMax(int[] a) {
        
        Integer maxA = null;
        Integer maxB = null;
        Integer maxC = null;

        for(Integer x: a){
            
            if(x.equals(maxA) || x.equals(maxB) || x.equals(maxC)) 
                continue;
            
            if(maxA==null || x>maxA){
                
                
                maxC=maxB;
                maxB=maxA;
                maxA=x;
            }
            else if(maxB==null || x>maxB){

                maxC=maxB;
                maxB=x;
            }
            else if(maxC==null || x>maxC){
               maxC=x;
            }
        }
        
        return maxC==null? maxA:maxC;
        
    }
}


/*
-----------------------------HashSet and Priority Queue(Heap) Solution------------------------------
TC - O(n)
SC - O(n)
*/

/*
public class Solution {
    public int thirdMax(int[] a) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        for (int i : a) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }

        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
*/