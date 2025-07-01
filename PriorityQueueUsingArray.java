//MIN-PRIORITY Queue -> elements with the lowest priority value are dequeued first
import java.util.Scanner;

class PriorityQueueArray<T>
{
    private T[] data;
    private int[] priorities;
    private int front, rear, size;

    @SuppressWarnings("unchecked")
    public PriorityQueueArray(int size)
    {
        this.size = size;
        this.front = -1;
        this.rear = -1;
        this.data = (T[]) new Object[size];
        this.priorities = new int[size];
    }

    public void enqueue(T item, int priority)
    {
        if (rear == size - 1)
        {
            System.out.println("Queue is full. Cannot add more elements.");
            return;
        }

        int i;
        if (front == -1) // First element being added
            front = 0;

        // Find the correct position for the new element
        for (i = rear; i >= front && priorities[i] > priority; i--)
        {
            data[i + 1] = data[i];
            priorities[i + 1] = priorities[i];
        }

        // Insert the new element
        data[i + 1] = item;
        priorities[i + 1] = priority;
        rear++;
    }

    public T dequeue()
    {
        if (front == -1 || front > rear)
        {
            System.out.println("Queue is empty.");
            return null;
        }

        T item = data[front];

        // Move `front` forward
        front++;
        if (front > rear) // Reset queue if empty
        {
            front = -1;
            rear = -1;
        }

        return item;
    }

    public void display()
    {
        if (front == -1 || front > rear)
        {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue contents (data - priority):");
        for (int i = front; i <= rear; i++)
        {
            System.out.println(data[i] + " - " + priorities[i]);
        }
    }
}

public class PriorityQueueUsingArray
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PriorityQueueArray<Object> queue = new PriorityQueueArray<>(10); // size set to 10
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

