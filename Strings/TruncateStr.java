/*1816. Truncate Sentence - Leetcode Java Solutions*/


/*----------------------------Approch 1:[Linear Solution]--------------------------------------

Complexity:
TC - O(n)
SC - O(1) [Big O notation average time complexity is better than approch 2]
*/

public class TruncateStr{
    public String truncateSentence(String s, int k) {

        int i;
        int spaceCount=0;
        
        while(i<s.length() && spaceCount<k){
            if(s.charAt(i)==' ') spaceCount++;
            i++;
        }

        // if(spaceCount<k) means we have to include whole string 
        return spaceCount==k?s.substring(0,i-1):s;
    }
}

/*
----------------------------------Approch 2:[using split]-------------------------------------------

Complexity:
Time:O(n)
Space:O(n)

Note: Split function will iterate over the string to split on the basis of "". thats why time is O(n) not O(k)

*/
/*
public String truncateSentence(String s, int k) {
        String[] str=s.split(" ");
        StringBuilder truncatedSentence=new StringBuilder();
        for(int i=0;i<k-1;i++){
            truncatedSentence.append(str[i] +" ");
        }
        truncatedSentence.append(str[k-1]); //because we don't want  space for last word
        return truncatedSentence.toString();
    }

*/

