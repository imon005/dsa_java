import java.util.Scanner;

// Node class for the linked list
class Node<T>
{
    T data;       // Data stored in the node
    Node<T> next; // Pointer to the next node

    public Node(T data)
    {
        this.data = data; // Initialize node with data
        this.next = null; // Next is initially null
    }
}

// Queue class using linked list
class Queue<T>
{
    private Node<T> front; // Pointer to the front of the queue
    private Node<T> rear;  // Pointer to the rear of the queue

    public Queue()
    {
        this.front = null; // Initialize front
        this.rear = null;  // Initialize rear
    }

    // Enqueue method to add an element to the rear of the queue
    public void enqueue(T item)
    {
        Node<T> newNode = new Node<>(item); // Create a new node
        if (rear == null)
        {
            front = newNode; // If queue is empty, front and rear are the same
            rear = newNode;
        } else
        {
            rear.next = newNode; // Link new node to the end of the queue
            rear = newNode; // Update rear to the new node
        }
    }

    // Dequeue method to remove and return the front element of the queue
    public T dequeue()
    {
        if (front == null)
        {
            System.out.println("\nEmpty QUEUE");
            return null; // Use null to indicate an empty queue
        }
        T item = front.data; // Get the front item
        front = front.next; // Move front pointer to the next node
        if (front == null) 
            rear = null; // If the queue is now empty, reset rear as well
        
        return item; // Return the dequeued item
    }

    // Display method to show the elements in the queue
    public void display()
    {
        System.out.println("\nQUEUE:");
        if (front != null)
        {
            Node<T> current = front;
            while (current != null)
            {
                System.out.print(current.data + " "); // Print the data
                current = current.next; // Move to the next node
            }
            System.out.println();
        } else 
            System.out.println("Empty QUEUE");
    }
}

public class LinearQueueUsingLinkedList
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Queue<Object> queue = new Queue<>(); // Creating an instance of Queue with Object type
        int choice;

        do
        {
            System.out.print("\n1. ENQUEUE\n2. DEQUEUE\n3. DISPLAY\n4. EXIT\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Data to be inserted: ");
                    if (sc.hasNextInt())
                        queue.enqueue(sc.nextInt());
                    else if (sc.hasNextDouble())
                        queue.enqueue(sc.nextDouble());
                    else
                        queue.enqueue(sc.next());
                    
                    queue.display();
                    break;

                case 2:
                    Object item = queue.dequeue();
                    if (item != null)
                        System.out.println("Removed element: " + item);
                    
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

        sc.close();
    }
}

