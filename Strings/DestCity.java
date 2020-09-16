//1436. Destination City - LeetCode Strings Java Solution

class DestCity 
{

    public String destCity(List<List<String>> paths) 
    {
        
        HashMap<String, String> hm=new HashMap<>();
        int i;
        for(i=0;i<paths.size();i++)
        {
            hm.put(paths.get(i).get(0),paths.get(i).get(1));
        }
        String st=paths.get(0).get(0);
        while(hm.containsKey(st))
            st=hm.get(st);
        
        return st;
    }
}
