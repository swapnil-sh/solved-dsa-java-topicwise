/*1684. Count the Number of Consistent Strings - Leetcode Java Solutions*/


/*
-------------------------HashSet Solution--------------------------------

TC - O(lengthOfArray * lengthOFeveryWord)
SC - O(LengthOfPattern)


*/


class CountConsistStrings{
    public int countConsistentStrings(String s, String[] w) {
        
        int i,j,flag=0,res=0;
        HashSet<Character> hs=new HashSet<>();// added Set to search in O(1)
        
        for(i=0;i<s.length();i++)
            hs.add(s.charAt(i));
        
        for(i=0;i<w.length;i++){
            flag=0;
            for(j=0;j<w[i].length();j++){
                if(!hs.contains(w[i].charAt(j))){
                    flag=1;
                    break;
                }
            }
            
            if(flag==0)
                res++;
        }
        
        return res;
        
    }
}


/*
-------------------------Brute Force Solution--------------------------------

TC - O(lengthOFeveryWord * lengthOfArray * 26)
SC - O(1)
*/

/*
class Solution {
    public int countConsistentStrings(String s, String[] w) {
        
        int i,j,flag=0,res=0;
        
        for(i=0;i<w.length;i++){
            flag=0;
            for(j=0;j<w[i].length();j++){
                if(s.indexOf(w[i].charAt(j))==-1){
                    flag=1;
                    break;
                }
            }
            
            if(flag==0)
                res++;
        }
        
        return res;
        
    }
}
*/