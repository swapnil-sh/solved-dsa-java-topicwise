/*
557. Reverse Words in a String III
 - https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
*/


class ReverseWords {
    public String reverseWords(String s) {
        char[] tempArray = s.toCharArray();
        int startIndex = 0;
        int endIndex = 0;
        for (int i=0;i<tempArray.length;i++) {
            if (tempArray[i] == ' ') {
                endIndex = i-1;
                System.out.println(tempArray[i-1] + " " +startIndex +" "+endIndex);
                revWord(tempArray, startIndex, endIndex);
                startIndex = i+1;
            } else if(i == tempArray.length-1) {
                revWord(tempArray, startIndex, i);
            }
        }

        return new String(tempArray);
    }

    private void revWord(char[] tempArray, int i, int j) {
        while(i<j) {
            char temp = tempArray[i];
            tempArray[i] = tempArray[j];
            tempArray[j] = temp;
            i++;
            j--;
        }
    }
}
