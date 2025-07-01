//MIN-PRIORITY Queue -> elements with the lowest priority value are dequeued first
import java.util.Scanner;

class PriorityQueueNode<T>
{
    T data;
    int priority;
    PriorityQueueNode<T> next;

    public PriorityQueueNode(T data, int priority)
    {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }
}

class Queue<T>
{
    private PriorityQueueNode<T> front;

    public Queue()
    {
        front = null;
    }

    public void enqueue(T data, int priority)
    {
        PriorityQueueNode<T> newNode = new PriorityQueueNode<>(data, priority);

        if (front == null || front.priority > priority)
        {
            newNode.next = front;
            front = newNode;
        }
        else
        {
            PriorityQueueNode<T> current = front;
            while (current.next != null && current.next.priority <= priority)
            {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public T dequeue()
    {
        if (front == null)
        {
            System.out.println("Queue is empty.");
            return null;
        }
        T data = front.data;
        front = front.next;
        return data;
    }

    public void display()
    {
        if (front == null)
        {
            System.out.println("Queue is empty.");
            return;
        }

        PriorityQueueNode<T> temp = front;
        System.out.println("Queue contents (data - priority):");
        while (temp != null)
        {
            System.out.println(temp.data + " - " + temp.priority);
            temp = temp.next;
        }
    }
}

public class PriorityQueueUsingLinkedList
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Queue<Object> queue = new Queue<>();
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

                    System.out.print("Enter priority: ");
                    int priority = scanner.nextInt();

                    queue.enqueue(data, priority);
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

