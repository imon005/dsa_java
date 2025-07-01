/*
//METHOD-1 -> two stacks with costly enQueue() 
//Size of stack is infinite ---> Size of the Queue is infinite
//enQueue - O(n), deQueue - O(1)

import java.util.Stack;
import java.util.Scanner;

class Queue<T>
{
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void enQueue(T x) 
    { 
        // Move all elements from stack1 to stack2 
        while (!stack1.isEmpty())
        { 
            stack2.push(stack1.pop()); 
        } 
 
        // Push item into stack1 
        stack1.push(x); 
 
        // Push everything back to stack1 
        while (!stack2.isEmpty()) 
        { 
            stack1.push(stack2.pop()); 
        } 
    } 
 
    // Dequeue an item from the queue 
    public T deQueue() 
    { 
        // if first stack is empty 
        if (stack1.isEmpty()) 
        { 
            return null;
        } 
 
        // Return top of stack1 
        T x = stack1.peek(); 
        stack1.pop(); 
        return x; 
    } 

    //Displaying items of the queue
    public void display()
    {
        //If stack1 is empty
        if(stack1.size() == 0)
        {
            System.out.println("Empty Queue");
            return;
        }

        System.out.println("The Queue: ");
        for(int i = stack1.size()-1; i>=0; i--)
        {
            System.out.print(stack1.get(i)+"   ");
        }
        System.out.println();
    }
}
*/

//-----------------------------------------------------------------------------------

/*
//METHOD-2 -> two stacks with costly deQueue() 
//Size of stack is infinite ---> Size of the Queue is infinite
//enQueue - O(1), deQueue - O(n) in general, O(1) amortized
import java.util.Stack;
import java.util.Scanner;

class Queue<T>
{
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void enQueue(T x) 
    {
        // Push item into stack1 
        stack1.push(x); 
    } 
 
    // Dequeue an item from the queue 
    public T deQueue() 
    { 
        // If both stacks are empty then error
        if (stack1.isEmpty() && stack2.isEmpty()) 
        { 
            return null;
        } 

        // Move elements from stack1 to stack 2 only if stack2 is empty
        if(stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    } 

    //Displaying items of the queue
    public void display()
    {
        //If stack1 is empty
        if(stack1.isEmpty() && stack2.isEmpty())
        {
            System.out.println("Empty Queue");
            return;
        }

        System.out.println("The Queue: ");
        for(int i = stack2.size()-1; i>=0; i--)
        {
            System.out.print(stack2.get(i)+"   ");
        }
        for(int i=0; i<=stack1.size()-1; i++)
        {
            System.out.print(stack1.get(i)+"   ");
        }
        System.out.println();
    }
}
*/

//---------------------------------------------------------------------------------------------

//METHOD-3 -> one user stack, one function call stack (RECURSION) with costly deQueue() 
//Size of stack is infinite ---> Size of the Queue is infinite
//enQueue - O(1), deQueue - O(n)

import java.util.Stack;
import java.util.Scanner;

class Queue<T>
{
    private Stack<T> stack1 = new Stack<>();

    public void enQueue(T x) 
    {
        // Push item into stack1 
        stack1.push(x); 
    } 
 
    // Dequeue an item from the queue 
    public T deQueue() 
    { 
        T x, res = null;
        // If both stacks are empty then error
        if (stack1.isEmpty()) 
        { 
            return null;
        } 

        //Check if it is a last element of stack
        if(stack1.size() == 1)
        {
            return stack1.pop();
        }

        //pop an item from the stack1
        x = stack1.pop();
        //store the last deQueued item
        res = deQueue();
        //push everything back to stack1
        stack1.push(x);

        return res;
    } 

    //Displaying items of the queue
    public void display()
    {
        //If stack1 is empty
        if(stack1.isEmpty())
        {
            System.out.println("Empty Queue");
            return;
        }

        System.out.println("The Queue: ");
        for(int i=0; i<=stack1.size()-1; i++)
        {
            System.out.print(stack1.get(i)+"   ");
        }
        System.out.println();
    }
}

public class QueueUsingStack
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Queue<Object> queue = new Queue<>(); // Using Object type to accept all data types
        int choice;
        Object data;

        do
        {
            System.out.print("\n1. Enqueue\n2. Dequeue\n3. Display\n4. EXIT\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter data: ");
                    if (scanner.hasNextInt())
                        data = scanner.nextInt();
                    else if (scanner.hasNextDouble())
                        data = scanner.nextDouble();
                    else
                        data = scanner.next();
                    
                    queue.enQueue(data);
                    queue.display();
                    break;

                case 2:
                    data = queue.deQueue();
                    if (data != null) 
                        System.out.println("Dequeued item: " + data);
                    
                    queue.display();
                    break;

                case 3:
                    queue.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    } 
}