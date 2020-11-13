/*412. Fizz Buzz - Leetcode Java Solutions*/


/*
---------------Approach 3:HashMap-----------------------------

Time Complexity: O(N)
Space Complexity: O(1)

*/

class FizzBuzz
{
    public List<String> fizzBuzz(int n)
    {
        List<String> res=new ArrayList<>();
        

    // Hash map to store all fizzbuzz mappings.
        HashMap<Integer, String> fizzBizzDict =
            new HashMap<Integer, String>() {
              {
                put(3, "Fizz");
                put(5, "Buzz");
              }
            };

        int i;
        for (i=1;i<=n;i++) 
        {

              String numAnsStr = "";

              for (Integer key : fizzBizzDict.keySet()) 
              {

                // If the num is divisible by key,
                // then add the corresponding string mapping to current numAnsStr
                if (i%key == 0)
                  numAnsStr += fizzBizzDict.get(key);

              }

              if (numAnsStr.equals(""))
                numAnsStr += Integer.toString(i);

              res.add(numAnsStr);
        }

        return res;
    }
}


/*
---------------Approach 2: String Concatenation-----------------------------

Time Complexity: O(N)
Space Complexity: O(1)

*/

/*
class Solution {
    public List<String> fizzBuzz(int n)
    {
        List<String> res=new ArrayList<>();
        
        int i;
        for(i=1;i<=n;i++) {

          boolean divisibleBy3 = (i % 3 == 0);
          boolean divisibleBy5 = (i % 5 == 0);

          String numAnsStr = "";

          if (divisibleBy3)
            numAnsStr += "Fizz";


          if (divisibleBy5) 
            numAnsStr += "Buzz";
          

          if (numAnsStr.equals(""))
            numAnsStr += Integer.toString(i);
          
          res.add(numAnsStr);
        }

        return res;
    }
}

*/


/*
---------------Approach 1: Naive Approach-----------------------------

Time Complexity: O(N)
Space Complexity: O(1)

*/

/*
class Solution
{
    public List<String> fizzBuzz(int n)
    {
        List<String> res=new ArrayList<>();
        
        int i;
        for(i=1;i<=n;i++)
        {
            if(i%3==0 && i%5==0)
                res.add("FizzBuzz");
            else if(i%3==0)
                res.add("Fizz");
            else if(i%5==0)
                res.add("Buzz");
            else
                res.add(String.valueOf(i));
        }
        
        return res;
    }
}
*/