/*Remove Duplicate Bracket From Expression - Java Solution
*/
public class RemDupBrackets
{

    public List<BracketPair> findUnnecessaryBrackets(String input) {
        List<BracketPair> unneccessaryBrackets = new LinkedList<BracketPair>();
        Deque<BracketPair> bracketStack = new LinkedBlockingDeque<BracketPair>();

        for (int cursor = 0; cursor < input.length(); cursor++ ) {
            if (input.charAt(cursor) == '(') {
                BracketPair pair = new BracketPair(cursor);
                bracketStack.addLast(pair);
            } else if (input.charAt(cursor) == ')') {
                BracketPair lastBracketPair = bracketStack.removeLast();
                lastBracketPair.end = cursor;
                if (!lastBracketPair.isNecessary) {
                    unneccessaryBrackets.add(lastBracketPair);
                }
            } else if (input.charAt(cursor) != ' ') {
                if (!bracketStack.isEmpty()) {
                    bracketStack.getLast().isNecessary = true;
                }
            }
        }

        return unneccessaryBrackets;
    }

    class BracketPair 
    {
        public int start = -1;
        public int end = -1;
        public boolean isNecessary = false;

        public BracketPair(int startIndex) {
            this.start = startIndex;
        }
    }
}