/*Infix to Prefix conversion using two stacks - GeeksforGeeks Java Solution using Two Stacks*/


/*
The idea is to use one stack for storing operators and other to store operands. The stepwise algo is:

    Traverse the infix expression and check if given character is an operator or an operand.
    If it is an operand, then push it into operand stack.
    If it is an operator, then check if priority of current operator is greater than or less than or equal to the operator at top of the stack. If priority is greater, then push operator into operator stack. Otherwise pop two operands from operand stack, pop operator from operator stack and push string operator + operand1 + operand 2 into operand stack. Keep popping from both stacks and pushing result into operand stack until priority of current operator is less than or equal to operator at top of the operator stack.
    If current character is ‘(‘, then push it into operator stack.
    If current character is ‘)’, then check if top of operator stack is opening bracket or not. If not pop two operands from operand stack, pop operator from operator stack and push string operator + operand1 + operand 2 into operand stack. Keep popping from both stacks and pushing result into operand stack until top of operator stack is an opening bracket.
    The final prefix expression is present at top of operand stack.

*/
/*
Time Complexity: O(n)
Auxiliary Space: O(n)
*/

import java.util.*; 
class InfixToPrefix
{ 
// Function to check if  
// given character is 
// an operator or not. 
static boolean isOperator(char c) 
{ 
    return (!(c >= 'a' && c <= 'z') &&  
            !(c >= '0' && c <= '9') &&  
            !(c >= 'A' && c <= 'Z')); 
} 
  
// Function to find priority  
// of given operator. 
static int getPriority(char C) 
{ 
    if (C == '-' || C == '+') 
        return 1; 
    else if (C == '*' || C == '/') 
        return 2; 
    else if (C == '^') 
        return 3; 
    return 0; 
} 
  
// Function that converts infix 
// expression to prefix expression. 
static String infixToPrefix(String infix) 
{ 
    // stack for operators. 
    Stack<Character> operators = new Stack<Character>(); 
  
    // stack for operands. 
    Stack<String> operands = new Stack<String>(); 
  
    for (int i = 0; i < infix.length(); i++)  
    { 
  
        // If current character is an 
        // opening bracket, then 
        // push into the operators stack. 
        if (infix.charAt(i) == '(')  
        { 
            operators.push(infix.charAt(i)); 
        } 
  
        // If current character is a 
        // closing bracket, then pop from 
        // both stacks and push result 
        // in operands stack until 
        // matching opening bracket is 
        // not found. 
        else if (infix.charAt(i) == ')')  
        { 
            while (!operators.empty() &&  
                operators.peek() != '(')  
                { 
  
                // operand 1 
                String op1 = operands.peek(); 
                operands.pop(); 
  
                // operand 2 
                String op2 = operands.peek(); 
                operands.pop(); 
  
                // operator 
                char op = operators.peek(); 
                operators.pop(); 
  
                // Add operands and operator 
                // in form operator + 
                // operand1 + operand2. 
                String tmp = op + op2 + op1; 
                operands.push(tmp); 
            } 
  
            // Pop opening bracket  
            // from stack. 
            operators.pop(); 
        } 
  
        // If current character is an 
        // operand then push it into 
        // operands stack. 
        else if (!isOperator(infix.charAt(i)))  
        { 
            operands.push(infix.charAt(i) + ""); 
        } 
  
        // If current character is an 
        // operator, then push it into 
        // operators stack after popping 
        // high priority operators from 
        // operators stack and pushing 
        // result in operands stack. 
        else 
        { 
            while (!operators.empty() &&  
                getPriority(infix.charAt(i)) <=  
                    getPriority(operators.peek()))  
                { 
  
                String op1 = operands.peek(); 
                operands.pop(); 
  
                String op2 = operands.peek(); 
                operands.pop(); 
  
                char op = operators.peek(); 
                operators.pop(); 
  
                String tmp = op + op2 + op1; 
                operands.push(tmp); 
            } 
  
            operators.push(infix.charAt(i)); 
        } 
    } 
  
    // Pop operators from operators  
    // stack until it is empty and  
    // operation in add result of  
    // each pop operands stack. 
    while (!operators.empty())  
    { 
        String op1 = operands.peek(); 
        operands.pop(); 
  
        String op2 = operands.peek(); 
        operands.pop(); 
  
        char op = operators.peek(); 
        operators.pop(); 
  
        String tmp = op + op2 + op1; 
        operands.push(tmp); 
    } 
  
    // Final prefix expression is 
    // present in operands stack. 
    return operands.peek(); 
} 
  
// Driver code 
public static void main(String args[]) 
{ 
    String s = "(A-B/C)*(A/K-L)"; 
    System.out.println( infixToPrefix(s)); 
} 
} 
  