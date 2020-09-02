//434. Number of Segments in a String - JAVS LEETCODE Solution

class No_of_Seg_in_String 
{
    public int countSegments(String s) 
    {
        s=s.trim();
        if(s.length()==0)
            return 0;

        String words[] = s.split("\\s+");
        return words.length;
    }
}
