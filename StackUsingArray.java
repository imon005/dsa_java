import java.util.Scanner;

// Generic Stack class that can accept any data type
class Stack<T>
{
    private int size;  // Maximum size of the stack
    private T[] data;  // Array to store stack elements
    private int top;  // Initially, the stack is empty (top = -1)

    // Constructor
    @SuppressWarnings("unchecked")
    public Stack()
    {
        size = 10;
        top = -1;
        data = (T[]) new Object[size];  // Generic array creation
    }

    // Push method to add an element to the stack
    public void push(T item)
    {
        if (top == size - 1)
        {
            System.out.println("Stack overflow");
            return;
        }
        data[++top] = item;
    }

    // Pop method to remove and return the top element of the stack
    public T pop()
    {
        if (top == -1)
        {
            System.out.println("Stack underflow");
            return null;
        }
        return data[top--];
    }

    // Peek method to display the current stack
    public void peek()
    {
        if (top == -1)
        {
            System.out.println("Empty Stack");
            return;
        }
        System.out.println("\nStack:");
        for (int i = top; i >= 0; i--)
        {
            System.out.println(data[i]);
        }
    }
}

public class StackUsingArray
{
    public static void main(String[] args)
    {
        Stack<Object> s = new Stack<>();  // Using Object type to allow all data types
        Scanner sc = new Scanner(System.in);
        int ch;
        Object item;

        do
        {
            System.out.print("\n1. PUSH\n2. POP\n3. PEEK\n4. EXIT\nEnter your choice: ");
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
                    s.peek();
                    break;
                case 2:
                    System.out.println("Popped item: " + s.pop());
                    s.peek();
                    break;
                case 3:
                    s.peek();
                    break;
            }
        }while (ch != 4);

        sc.close();
    }
}

