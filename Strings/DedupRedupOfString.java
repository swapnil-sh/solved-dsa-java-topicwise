import java.util.HashMap;
public class DedupRedupOfString
{
      static String dedup(String inputStr, int chunkSize) 
      {
        int chunks = 0;
        StringBuilder dedup = new StringBuilder();
        for(int i = 0; i< inputStr.length();)
        {
            String str = inputStr.substring(i,i+chunkSize);
            if(dedup.indexOf(str) != -1)
            {
                int ind = dedup.indexOf(str);
                dedup.insert(dedup.indexOf(",", ind), "-"+chunks);
            }
            else
                dedup.append(str+"-"+chunks+",");
            
            chunks++;
            i+=chunkSize;
         }

        return dedup.toString();
    }

    static String redup(String deduplicatedStr, int chunkSize)
    {
        String str = "";
        for(int i = 0; i< deduplicatedStr.length();i++) 
        {
            String str1 = deduplicatedStr.substring(i, i + chunkSize);
            int chunkIndex = deduplicatedStr.indexOf(",",i+chunkSize);
            String chunk = deduplicatedStr.substring(i+chunkSize, chunkIndex);
            System.out.println(chunk);
        }

        return "";
    }

    public static void main(String[] args) {
        String dedupStr = dedup("abcdeabcdfabcde", 5);
        System.out.println(dedupStr);
        //redup(dedupStr, 5);
    }
}