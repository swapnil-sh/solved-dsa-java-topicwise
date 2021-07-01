/*89. Gray Code - Leetcode Java SOlution*/

/*
-------------------Recursive and Backtracking Solution----------------------------------



TC - n*O(2^n)
SC - n*O(2^n)
*/

class GrayCode{
    
    public ArrayList<String> solve(int n){
        
    
        if(n==1){
            
            ArrayList<String> res=new ArrayList<>();
            res.add("0");
            res.add("1");
            return res;
        }
        
        ArrayList<String> s1=solve(n-1);
        ArrayList<String> s2=new ArrayList<>();
        
        int i;
        for(i=0;i<s1.size();i++){
            
            
            s2.add("0"+s1.get(i));
        }
        
        for(i=s1.size()-1;i>=0;i--){
            
            s2.add("1"+s1.get(i));
        }
        
        return s2;
    }
    
    public List<Integer> grayCode(int n) {
        
        ArrayList<Integer> res=new ArrayList<>();
        ArrayList<String> bin=solve(n);
        
        for(int i=0;i<bin.size();i++){
            
            int dec=Integer.parseInt(bin.get(i),2);
            res.add(dec);
        }
        
        return res;
        
    }
}