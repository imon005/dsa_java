import java.util.Scanner;

class Dequeue<T>
{
    private T[] data;
    private int front, rear, size;

    @SuppressWarnings("unchecked")
    public Dequeue()
    {
        size = 10;
        data = (T[]) new Object[size];
        front = -1;
        rear = -1;
    }

    public void front_insert(T item)
    {
        if(front == 0)
        {
            System.out.println("Queue Overflow");
            return;
        }
        if(front == -1)
        {
            front = 0;
            rear = 0;
        }
        else
            front--;
        data[front] = item;
    }

    public void rear_insert(T item)
    {
        if(rear == size-1)
        {
            System.out.println("Queue Overflow");
            return;
        }
        if(front == -1)
            front = 0;
        rear++;
        data[rear] = item;
    }

    public T front_delete()
    {
        if(front == -1)
        {
            System.out.println("Queue Underflow");
            return null;
        }
        T x = data[front];
        if(front == rear)
        {
            front = -1;
            rear = -1;
        }
        else
            front++;
        
        return x;
    }

    public T rear_delete()
    {
        if(rear == -1)
        {
            System.out.println("Queue Underflow");
            return null;
        }
        T x = data[rear];
        if(front == rear)
        {
            front = -1;
            rear = -1;
        }
        else
            rear--;

        return x;
    }

    public void display()
    {
        if(front == -1 || rear == -1)
        {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("front = "+front+"   rear = "+rear);
        for(int i = front; i<=rear; i++)
            System.out.print(data[i]+"   ");
    }
}

public class DoubleEndedQueueUsingArray
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Dequeue<Object> deque = new Dequeue<>();
        int choice;

        do 
        {
            System.out.print("\n1. Front Insert\n2. Front Delete\n3. Rear Insert\n4. Rear Delete\n5. Display\n6. EXIT\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter data: ");
                    Object data1 = scanner.next();
                    deque.front_insert(data1);
                    deque.display();
                    break;

                case 2:
                    deque.front_delete();
                    deque.display();
                    break;

                case 3:
                    System.out.print("Enter data: ");
                    Object data2 = scanner.next();
                    deque.rear_insert(data2);
                    deque.display();
                    break;

                case 4:
                    deque.rear_delete();
                    deque.display();
                    break;

                case 5:
                    deque.display();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    } 
}
