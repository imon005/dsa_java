import java.util.Scanner;

// Generic Queue class using an array
class Queue<T>
{
    private T[] data;  // Array to hold the queue elements
    private int front;  // Index of the front element
    private int rear;   // Index of the rear element
    private int size; // Size of the queue

    @SuppressWarnings("unchecked")
    public Queue()
    {
        size = 10;
        data = (T[]) new Object[size]; // Creating a generic array
        front = -1;
        rear = -1;
    }

    // Enqueue method to add an element to the rear of the queue
    public void enqueue(T item)
    {
        if (rear == size - 1)
        {
            System.out.println("Queue overflow");
            return;
        }
        if (front == -1)
            front = 0; // Set front to 0 if the queue is empty
        
        data[++rear] = item; // Add item to the queue
    }

    // Dequeue method to remove and return the front element of the queue
    public T dequeue()
    {
        if (front == -1)
        {
            System.out.println("Queue underflow");
            return null;
        }
        T item = data[front]; // Get the front item
        if (front == rear)
        {
            front = -1; // Reset the queue if it becomes empty
            rear = -1;
        }
        else
            front++; // Move front to the next element
    
        return item; // Return the dequeued item
    }

    // Display method to show the elements in the queue
    public void display()
    {
        System.out.println("\nQueue:");
        if (front == -1)
        {
            System.out.println("Empty Queue");
            return;
        }
        System.out.println("Front=" + front + "    Rear=" + rear);
        for (int i = front; i <= rear; i++)
            System.out.print(data[i] + " ");
        
        System.out.println();
    }
}

public class LinearQueueUsingArray
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
                    
                    queue.enqueue(data);
                    queue.display();
                    break;

                case 2:
                    data = queue.dequeue();
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

