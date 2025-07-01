import java.util.Scanner;

// Node class to represent each element in the stack
class Node<T>
{
    T data;  // The data stored in the node
    Node<T> next;  // The reference to the next node

    public Node(T data)
    {
        this.data = data;
        this.next = null;
    }
}

// Generic Stack class using linked list
class Stack<T>
{
    private Node<T> top;  // The top element of the stack

    public Stack()
    {
        this.top = null;  // Initially, the stack is empty
    }

    // Push method to add an element to the top of the stack
    public void push(T data)
    {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;  // Point the new node to the current top
        top = newNode;  // Update the top to the new node
    }

    // Pop method to remove and return the top element of the stack
    public T pop()
    {
        if (top == null)
        {
            System.out.println("Stack underflow");
            return null;
        }
        T data = top.data;
        top = top.next;  // Move the top to the next node
        return data;
    }

    // Peek method to display the elements of the stack
    public void peek()
    {
        if (top == null)
        {
            System.out.println("Stack is empty");
            return;
        }
        Node<T> current = top;
        System.out.println("Stack:");
        while (current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

public class StackUsingLinkedList
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Stack<Object> stack = new Stack<>();  // Using Object type to accept all data types
        int choice;
        Object data;

        do
        {
            System.out.print("\n1. PUSH\n2. POP\n3. PEEK\n4. EXIT\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter data: ");
                    if (sc.hasNextInt())
                        data = sc.nextInt();
                    else if (sc.hasNextDouble())
                        data = sc.nextDouble();
                    else
                        data = sc.next();

                    stack.push(data);
                    stack.peek();
                    break;

                case 2:
                    data = stack.pop();
                    if (data != null)
                        System.out.println("The Popped element: " + data);
                
                    stack.peek();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (choice != 4);

        sc.close();
    }
}

