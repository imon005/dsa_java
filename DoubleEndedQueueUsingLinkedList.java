import java.util.Scanner;

class DequeLinkedListNode<T> 
{
    T data;
    DequeLinkedListNode<T> next, prev;

    public DequeLinkedListNode(T data) 
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DequeLinkedList<T> 
{
    private DequeLinkedListNode<T> front, rear;

    public DequeLinkedList() 
    {
        front = rear = null;
    }

    public void front_insert(T item) 
    {
        DequeLinkedListNode<T> newNode = new DequeLinkedListNode<>(item);

        if (front == null) 
        {
            front = rear = newNode;
        } 
        else 
        {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    public void front_delete() 
    {
        if (front == null) 
        {
            System.out.println("Deque is empty.");
            return;
        }

        if (front == rear) 
        {
            front = rear = null;
        } 
        else 
        {
            front = front.next;
            front.prev = null;
        }
    }

    public void rear_insert(T item) 
    {
        DequeLinkedListNode<T> newNode = new DequeLinkedListNode<>(item);

        if (rear == null) 
        {
            front = rear = newNode;
        } 
        else 
        {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    public void rear_delete() 
    {
        if (rear == null) 
        {
            System.out.println("Deque is empty.");
            return;
        }

        if (front == rear) 
        {
            front = rear = null;
        } 
        else 
        {
            rear = rear.prev;
            rear.next = null;
        }
    }

    public void display() 
    {
        if (front == null) 
        {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.println("Deque contents:");
        DequeLinkedListNode<T> temp = front;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DoubleEndedQueueUsingLinkedList
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        DequeLinkedList<Object> deque = new DequeLinkedList<>();
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

