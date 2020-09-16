//1309. Decrypt String from Alphabet to Integer Mapping String Leetcode Easy Java Solution

class DecryStr
{
    public String freqAlphabets(String s)
    {
        int i=1;
        HashMap<String,Character> hm=new HashMap<String,Character>();
        for(char c='a';c<='i';c++)
        {
            hm.put(Integer.toString(i),c);
            //System.out.println(hm.get(Integer.toString(i)));
            i++;
        }
        i=10;
        for(char c='j';c<='z';c++)
        {
            hm.put(Integer.toString(i)+"#",c);
            //System.out.println(hm.get(Integer.toString(i)+"#"));
            i++;
        }       
        
        String key="";
        StringBuffer sb=new StringBuffer();  
        for(i=0;i<s.length();i++)
        {
            key="";
            
            if(s.charAt(i)=='#')
            {
                sb.delete(sb.length()-2,sb.length());
                key=s.substring(i-2,i+1);
                //System.out.println("Key2="+key);
                sb.append(hm.get(key));
                //System.out.println("String1="+sb.toString());
            }
            else
            {
                key=Character.toString(s.charAt(i));
                //System.out.println("Key1="+key);
                if(hm.containsKey(key))
                    sb.append(hm.get(key));
                else
                    sb.append("x");
                //System.out.println("String2="+sb.toString());
            }
        }
        
        return sb.toString();
    }
}
