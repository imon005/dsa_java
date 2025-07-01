//Using Java Collection Framework
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix
{
    static Stack<Character> stack = new Stack<>();
    static StringBuilder postfixExpression = new StringBuilder();

    public static void push(char m)
    {
        stack.push(m);
    }

    public static char pop()
    {
        if (stack.isEmpty())
        {
            System.out.println("Stack is empty");
            return '\0';
        }
        return stack.pop();
    }

    public static int precedence(char c)
    {
        switch (c)
        {
            case '^':
                return 1;
            case '/':
            case '*':
                return 2;
            case '+':
            case '-':
                return 3;
            case '(':
            case ')':
                return 4;
            default:
                return -1;
        }
    }

    public static boolean checkPrecedence(char stackTop, char current)
    {
        int a1 = precedence(stackTop);
        int a2 = precedence(current);
        return a1 <= a2 && a1 != 4 && a2 != 4;
    }

    public static void convertToPostfix(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            char x = s.charAt(i);

            // If the character is an operand
            if (Character.isLetter(x))
            {
                postfixExpression.append(x);
            } 
            // If the character is '('
            else if (x == '(')
            {
                push(x);
            } 
            // If the character is ')'
            else if (x == ')')
            {
                while (true)
                {
                    char y = pop();
                    if (y == '(' || y == '\0')
                    {
                        break;
                    } 
                    else 
                    {
                        postfixExpression.append(y);
                    }
                }
            } 
            // If the character is an operator
            else if ("+-*/^".indexOf(x) != -1) 
            {
                while (!stack.isEmpty()) 
                {
                    char y = pop();
                    if (checkPrecedence(y, x)) 
                    {
                        postfixExpression.append(y);
                    } 
                    else 
                    {
                        push(y);
                        break;
                    }
                }
                push(x);
            }

            // Debugging: Print stack and expression
            System.out.print("\n" + x + "\t");
            System.out.print(stack + "\t");
            System.out.println(postfixExpression);
        }

        // Pop remaining operators in the stack
        while (!stack.isEmpty()) 
        {
            char y = pop();
            postfixExpression.append(y);
        }

        // Final Postfix Expression
        System.out.println("\n\t\t" + postfixExpression);
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an equation: ");
        String s = scanner.nextLine();
        System.out.println("\nSymbol\tStack\tExpression");
        convertToPostfix(s);
        System.out.println("\nPostfix: " + postfixExpression);
        scanner.close();
    }
}


//Without Using Java Collection Framework
// import java.util.Scanner;

// public class InfixToPostfix
// {

//     static char[] stack = new char[100];
//     static StringBuilder postfixExpression = new StringBuilder();
//     static int top = -1;

//     public static void push(char m)
//     {
//         stack[++top] = m;
//     }

//     public static char pop()
//     {
//         if (top < 0)
//         {
//             System.out.println("Stack is empty");
//             return '\0';
//         }
//         return stack[top--];
//     }

//     public static int precedence(char c)
//     {
//         switch (c)
//         {
//             case '^':
//                 return 1;
//             case '/':
//             case '*':
//                 return 2;
//             case '+':
//             case '-':
//                 return 3;
//             case '(':
//             case ')':
//                 return 4;
//             default:
//                 return -1;
//         }
//     }

//     public static boolean checkPrecedence(char stackTop, char current)
//     {
//         int a1 = precedence(stackTop);
//         int a2 = precedence(current);
//         return a1 <= a2 && a1 != 4 && a2 != 4;
//     }

//     public static void convertToPostfix(String s)
//     {
//         for (int i = 0; i < s.length(); i++) 
//         {
//             char x = s.charAt(i);

//             // If the character is an operand
//             if (Character.isLetter(x)) 
//             {
//                 postfixExpression.append(x);
//             } 
//             // If the character is '('
//             else if (x == '(') 
//             {
//                 push(x);
//             } 
//             // If the character is ')'
//             else if (x == ')') 
//             {
//                 while (true) 
//                 {
//                     char y = pop();
//                     if (y == '(' || y == '\0') 
//                     {
//                         break;
//                     } else 
//                     {
//                         postfixExpression.append(y);
//                     }
//                 }
//             } 
//             // If the character is an operator
//             else if ("+-*/^".indexOf(x) != -1) 
//             {
//                 while (top != -1) 
//                 {
//                     char y = pop();
//                     if (checkPrecedence(y, x)) 
//                     {
//                         postfixExpression.append(y);
//                     } 
//                     else 
//                     {
//                         push(y);
//                         break;
//                     }
//                 }
//                 push(x);
//             }

//             // Debugging: Print stack and expression
//             System.out.print("\n" + x + "\t");
//             for (int g = 0; g <= top; g++) 
//             {
//                 System.out.print(stack[g]);
//             }
//             System.out.print("\t" + postfixExpression);
//         }

//         // Pop remaining operators in the stack
//         while (top != -1) 
//         {
//             char y = pop();
//             postfixExpression.append(y);
//         }

//         // Final Postfix Expression
//         System.out.println("\n\t\t" + postfixExpression);
//     }

//     public static void main(String[] args) 
//     {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Enter an equation: ");
//         String s = scanner.nextLine();
//         System.out.println("\nSymbol\tStack\tExpression");
//         convertToPostfix(s);
//         System.out.println("\nPostfix: " + postfixExpression);
//         scanner.close();
//     }
// }
