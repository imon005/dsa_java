/*
//METHOD-1 -> two queues with costly push()
//Size of Queue is infinite ---> Size of the Stack is infinite
//push - O(n), pop - O(1)
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class Stack<T>
{
    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();

    public void push(T x)
    {
        // push x first in empty queue2
        q2.add(x);

        // push all the remaining elements from q1 to q2
        while(!q1.isEmpty())
        {
            q2.add(q1.poll());
        }

        // swap the names of two queues
        Queue<T> q = q1;
        q1 = q2;
        q2 = q; 
    }

    public T pop()
    {
        // if q1 is empty
        if(q1.isEmpty())
            return null;
        
        return q1.poll();
    }

    public T peek()
    {
        // if q1 is empty
        if(q1.isEmpty())
            return null;

        //return the top element
        return q1.peek();
    }

    public void display()
    {
        if(q1.isEmpty())
        {
            System.out.println("Stack Underflow");
            return;
        }

        System.out.println("The Stack:");
        for(T elm : q1)
        {
            System.out.println(elm);
        }
    }
}
*/

//----------------------------------------------------------------------------

/*
//METHOD-2 -> two queues with costly pop()
//Size of Queue is infinite ---> Size of the Stack is infinite
//push - O(1), pop - O(n)
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Stack<T>
{
    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();

    public void push(T x)
    {
        q1.add(x);
    }

    public T pop()
    {
        // if q1 is empty
        if(q1.isEmpty())
            return null;
        
        // Leave one element in q1 and push others in q2.
        while (q1.size() != 1)
        {
            q2.add(q1.poll());
        }

        // Pop the only left element from q1
        T temp = q1.poll();

        // swap the names of two queues
        Queue<T> q = q1;
        q1 = q2;
        q2 = q; 

        return temp;
    }

    public T peek()
    {
        // if q1 is empty
        if(q1.isEmpty())
            return null;
        
        // Leave one element in q1 and push others in q2.
        while (q1.size() != 1)
        {
            q2.add(q1.poll());
        }

        // Pop the only left element from q1
        T temp = q1.poll();

        // push last element to q2
        q2.add(temp);

        // swap the names of two queues
        Queue<T> q = q1;
        q1 = q2;
        q2 = q; 

        return temp;
    }

    public void display()
    {
        if(q1.isEmpty())
        {
            System.out.println("Stack Underflow");
            return;
        }

        ArrayList<T> arr = new ArrayList<>(q1);
        System.out.println("The Stack:");
        for(int i=arr.size()-1; i>=0; i--)
        {
            System.out.println(arr.get(i));
        }
    }
}
*/

//----------------------------------------------------------------------------------------------------

//METHOD-3 -> single queue
//Size of Queue is infinite ---> Size of the Stack is infinite
//push - O(n), pop - O(1)

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class Stack<T>
{
    private Queue<T> q1 = new LinkedList<>();

    public void push(T x)
    {
        //  Get previous size of queue
        int s = q1.size();

        // Push the current element
        q1.add(x);

        // Pop all the previous elements and put them after current element
        for (int i = 0; i < s; i++)
        {
            q1.add(q1.poll());
        }
    }

    public T pop()
    {
        // if q1 is empty
        if(q1.isEmpty())
            return null;
        
        return q1.poll();
    }

    public T peek()
    {
        // if q1 is empty
        if(q1.isEmpty())
            return null;

        //return the top element
        return q1.peek();
    }

    public void display()
    {
        if(q1.isEmpty())
        {
            System.out.println("Stack Underflow");
            return;
        }

        System.out.println("The Stack:");
        for(T elm : q1)
        {
            System.out.println(elm);
        }
    }
}

public class StackUsingQueue
{
    public static void main(String[] args)
    {
        Stack<Object> s = new Stack<>();  // Using Object type to allow all data types
        Scanner sc = new Scanner(System.in);
        int ch;
        Object item;

        do
        {
            System.out.print("\n1. PUSH\n2. POP\n3. PEEK\n4. DISPLAY\n5. EXIT\nEnter your choice: ");
            ch = sc.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.print("Enter the data: ");
                    if (sc.hasNextInt())
                        item = sc.nextInt();  // Read integer
                    else if (sc.hasNextDouble())
                        item = sc.nextDouble();  // Read double
                    else
                        item = sc.next();  // Read string or any other type

                    s.push(item);
                    s.display();
                    break;
                case 2:
                    System.out.println("Popped item: " + s.pop());
                    s.display();
                    break;
                case 3:
                    System.out.println("Top element: " + s.peek());
                    s.display();
                    break;
                case 4:
                    s.display();
                    break;
            }
        }while (ch != 5);

        sc.close();
    }
}