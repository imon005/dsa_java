//Using Java Collection Framework
import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation
{

    public static int evaluatePostfix(String s) 
    {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);

            // If the character is a digit, push it onto the stack
            if (Character.isDigit(ch)) 
            {
                stack.push(ch - '0');
            } 
            // If the character is an operator, pop two elements and evaluate
            else if ("+-*/^".indexOf(ch) != -1) 
            {
                int op1 = stack.pop();
                int op2 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(op2 + op1);
                        break;
                    case '-':
                        stack.push(op2 - op1);
                        break;
                    case '*':
                        stack.push(op2 * op1);
                        break;
                    case '/':
                        stack.push(op2 / op1);
                        break;
                    case '^':
                        stack.push((int) Math.pow(op2, op1));
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPostfix: ");
        String postfixExpression = scanner.nextLine();
        int result = evaluatePostfix(postfixExpression);
        System.out.println("\nValue = " + result);
        scanner.close();
    }
}



//Without using Java Collection Framework
// import java.util.Scanner;

// public class PostfixEvaluationNoJCF 
// {

//     static int[] stack = new int[100];
//     static int top = -1;

//     public static void push(int m) 
//     {
//         stack[++top] = m;
//     }

//     public static int pop() 
//     {
//         if (top == -1) 
//         {
//             System.out.println("Stack is empty");
//             return 0;
//         }
//         return stack[top--];
//     }

//     public static int evaluatePostfix(String s) 
//     {
//         for (int i = 0; i < s.length(); i++) 
//         {
//             char ch = s.charAt(i);

//             // If the character is a digit, push it onto the stack
//             if (Character.isDigit(ch)) 
//             {
//                 push(ch - '0');
//             } 
//             // If the character is an operator, pop two elements and evaluate
//             else if ("+-*/^".indexOf(ch) != -1) 
//             {
//                 int op1 = pop();
//                 int op2 = pop();
//                 switch (ch) {
//                     case '+':
//                         push(op2 + op1);
//                         break;
//                     case '-':
//                         push(op2 - op1);
//                         break;
//                     case '*':
//                         push(op2 * op1);
//                         break;
//                     case '/':
//                         push(op2 / op1);
//                         break;
//                     case '^':
//                         push((int) Math.pow(op2, op1));
//                         break;
//                 }
//             }
//         }
//         return pop();
//     }

//     public static void main(String[] args) 
//     {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("\nPostfix: ");
//         String postfixExpression = scanner.nextLine();
//         int result = evaluatePostfix(postfixExpression);
//         System.out.println("\nValue = " + result);
//         scanner.close();
//     }
// }
