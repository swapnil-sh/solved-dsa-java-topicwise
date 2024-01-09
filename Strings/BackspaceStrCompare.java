/*
844. Backspace String Compare - https://leetcode.com/problems/backspace-string-compare/description/
*/

/*
------- Two Pointer Approach (Without string modification)----------
TC - O(m+n)
SC - O(1)
*/
class BackspaceStrCompare {
    public boolean backspaceCompare(String s, String t) {
        boolean res = false;

        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}


/*
------- Modifying String --------
TC - O(n)
SC - O(1)
*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                if (i != 0) {
                    s = s.substring(0, i - 1) + s.substring(i + 1);
                    i--;
                } else {
                    s = s.substring(i + 1);
                    i = 0;
                }
            } else
                i++;
        }
        i = 0;
        while (i < t.length()) {
            if (t.charAt(i) == '#') {
                if (i != 0) {
                    t = t.substring(0, i - 1) + t.substring(i + 1);
                    i--;
                } else {
                    t = t.substring(i + 1);
                    i = 0;
                }
            } else
                i++;
        }

        return s.equals(t);
    }
}

/*
----------- Stack Solution -----------
TC - O(n)
SC - O(n)
*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        boolean res = false;
        String s1 = getUpdatedString(s);
        String t1 = getUpdatedString(t);

        System.out.println(s1 + " " + t1);
        return s1.equals(t1);
    }

    private String getUpdatedString(String s) {
        Stack<Character> st = new Stack<Character>();
        String s1 = "";

        for(int i=0;i<s.length();i++) {
            if (s.charAt(i)=='#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        while(!st.isEmpty()) {
            s1=st.pop()+s1;
        }
        return s1;
    }
}
