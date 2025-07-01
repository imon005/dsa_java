import java.util.Scanner;

// Circular Queue class using a generic type
class CircularQueue<T>
{
    private T[] data;      // Array to hold the queue elements
    private int front;     // Index of the front element
    private int rear;      // Index of the rear element
    private int SIZE;       // Size of the queue

    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    public CircularQueue()
    {
        SIZE = 3;
        data = (T[]) new Object[SIZE]; // Creating the queue array
        front = -1;
        rear = -1;
    }

    // Enqueue method to add an element to the rear of the queue
    public void enqueue(T item)
    {
        if ((rear + 1) % SIZE == front)
        {
            System.out.println("\nQueue is full");
            return;
        }
        if (front == -1)
            front = 0; // Set front to 0 if the queue is empty
        
        rear = (rear + 1) % SIZE; // Circular increment
        data[rear] = item; // Add item to the queue
    }

    // Dequeue method to remove and return the front element of the queue
    public T dequeue()
    {
        if (front == -1)
        {
            System.out.println("\nEmpty Queue");
            return null; // Use null to indicate an empty queue
        }
        T item = data[front]; // Get the front item
        data[front] = null;  //In case of Integer put -1
        if (front == rear)
        {
            front = -1; // Reset the queue if it becomes empty
            rear = -1;
        } else
            front = (front + 1) % SIZE; // Circular increment
        
        return item; // Return the dequeued item
    }

    // Display method to show the elements in the queue
    public void display()
    {
        System.out.println("\nQueue:");
        if (front != -1)
        {
            System.out.println("Front = " + front + "    Rear = " + rear);
            for(int i = 0; i < SIZE; i++)
                System.out.print(data[i]+"  ");
            System.out.println();
        } else
            System.out.println("Empty Queue");
    }
}

public class CircularQueueUsingArray
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        CircularQueue<Object> queue = new CircularQueue<>(); // Creating an instance of CircularQueue with Object type
        int choice;

        do
        {
            System.out.print("\n1. Enqueue\n2. Dequeue\n3. Display\n4. EXIT\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter the data: ");
                    if (scanner.hasNextInt())
                        queue.enqueue(scanner.nextInt());
                    else if (scanner.hasNextDouble())
                        queue.enqueue(scanner.nextDouble());
                    else
                        queue.enqueue(scanner.next());
                    
                    queue.display();
                    break;

                case 2:
                    Object item = queue.dequeue();
                    if (item != null)
                        System.out.println("Dequeued item: " + item);
                    
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
        }while (choice != 4);

        scanner.close();
    }
}

