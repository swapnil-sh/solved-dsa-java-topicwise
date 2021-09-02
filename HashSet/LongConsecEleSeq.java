/*128. Longest Consecutive Sequence - Leetcode Java Solutions*/

/*
----------------Optimal Solution (Using HashSet)-----------------------------

TC - O(3n)
SC - O(n)
*/


class LongConsecEleSeq{
    public int longestConsecutive(int[] a) {
        
        HashSet<Integer> hs=new HashSet<>();
        for(int num: a)
            hs.add(num);
        
        int longStreak=0,currEle,currStreak=1;
        
        for(int num: a){

            if(!hs.contains(num-1)){
                
                currEle=num;
                currStreak=1;
                
                while(hs.contains(currEle+1)){
                    currEle+=1;
                    currStreak+=1;
                }
            }
            
            longStreak=Math.max(longStreak, currStreak);
        }
        
        return longStreak;
        
    }
}


/*
----------------Brute Force Solution (Using Sorting)-----------------------------

TC - O(nlogn)+O(n)
SC - O(1)
*/
