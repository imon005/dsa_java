import java.util.Scanner;

// Node class to define each node of the linked list
class Node<T>
{
    T data;
    Node<T> next;

    Node(T item)
    {
        this.data = item;
        this.next = null;
    }
}

// LinkedList class to define linked list operations
class LinkedList<T>
{
    private Node<T> head;

    // Method to create a new node
    public Node<T> create(T item)
    {
        return new Node<>(item);
    }

    // Check if an item exists in the list
    public boolean check(T item)
    {
        Node<T> current = head;
        while (current != null)
        {
            if (current.data.equals(item))
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Insert at the end of the list
    public void insertEnd(Node<T> newNode)
    {
        if (head == null)
        {
            head = newNode;
            return;
        }
        Node<T> current = head;
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert at the beginning of the list
    public void insertBeg(Node<T> newNode)
    {
        newNode.next = head;
        head = newNode;
    }

    // Insert a new node after a given item
    public void insertAfter(Node<T> newNode, T item)
    {
        if (head == null || !check(item))
        {
            System.out.println(item + " is not present");
            return;
        }
        Node<T> current = head;
        while (!current.data.equals(item))
        {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Insert a new node before a given item
    public void insertBefore(Node<T> newNode, T item)
    {
        if (head == null || !check(item))
        {
            System.out.println(item + " is not present");
            return;
        }
        if (head.data.equals(item))
        {
            insertBeg(newNode);
            return;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(item))
        {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete the first node
    public void delBeg()
    {
        if (head != null)
        {
            head = head.next;
        }
    }

    // Delete the last node
    public void delEnd()
    {
        if (head == null)
            return;

        if (head.next == null)
        {
            head = null;
            return;
        }

        Node<T> current = head;
        while (current.next.next != null)
        {
            current = current.next;
        }
        current.next = null;
    }

    // Delete a node after a given item
    public void delAfter(T item)
    {
        if (head == null || !check(item))
        {
            System.out.println(item + " is not present");
            return;
        }
        Node<T> current = head;
        while (!current.data.equals(item))
        {
            current = current.next;
        }
        if (current.next == null)
        {
            System.out.println("Last node");
            return;
        }
        current.next = current.next.next;
    }

    // Delete a node before a given item
    public void delBefore(T item)
    {
        if (head == null || !check(item))
        {
            System.out.println(item + " is not present");
            return;
        }
        if (head.data.equals(item))
        {
            System.out.println("First node");
            return;
        }
        if (head.next.data.equals(item))
        {
            delBeg();
            return;
        }
        Node<T> current = head;
        while (current.next.next != null && !current.next.next.data.equals(item))
        {
            current = current.next;
        }
        current.next = current.next.next;
    }

    // Display the linked list
    public void display()
    {
        Node<T> current = head;
        if (current == null)
        {
            System.out.println("Empty list");
            return;
        }
        System.out.print("List: ");
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Reverse the linked list
    public void reverse()
    {
        Node<T> prev = null;
        Node<T> current = head;
        while (current != null)
        {
            Node<T> nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
    }

    // Delete nodes greater than a specified value
    public void deleteGreaterThanX(int X)
    {
        while (head != null && (Integer) head.data > X)
        {
            head = head.next;
        }
        Node<T> current = head;
        while (current != null && current.next != null)
        {
            if ((Integer) current.next.data > X)
            {
                current.next = current.next.next;
            }
            else
            {
                current = current.next;
            }
        }
    }
}

// Main class for user interaction
public class SinglyLinkedList
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> newNode;
        int choice, data, item, X;
        char subChoice;

        do
        {
            System.out.print("\n1. Insert\n2. Delete\n3. Display\n4. Reverse\n5. Exit\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    do
                    {
                        System.out.print("\na. Insert at begin\nb. Insert at end\nc. Insert before an element\nd. Insert after an element\ne. Display\nf. Exit\nEnter your choice: ");
                        subChoice = scanner.next().charAt(0);
                        switch (subChoice)
                        {
                            case 'a':
                                System.out.print("Enter the data: ");
                                data = scanner.nextInt();
                                newNode = list.create(data);
                                list.insertBeg(newNode);
                                list.display();
                                break;
                            case 'b':
                                System.out.print("Enter the data: ");
                                data = scanner.nextInt();
                                newNode = list.create(data);
                                list.insertEnd(newNode);
                                list.display();
                                break;
                            case 'c':
                                System.out.print("Enter the data: ");
                                data = scanner.nextInt();
                                newNode = list.create(data);
                                System.out.print("Enter the data before which " + newNode.data + " will be inserted: ");
                                item = scanner.nextInt();
                                list.insertBefore(newNode, item);
                                list.display();
                                break;
                            case 'd':
                                System.out.print("Enter the data: ");
                                data = scanner.nextInt();
                                newNode = list.create(data);
                                System.out.print("Enter the data after which " + newNode.data + " will be inserted: ");
                                item = scanner.nextInt();
                                list.insertAfter(newNode, item);
                                list.display();
                                break;
                            case 'e':
                                list.display();
                                break;
                        }
                    } while (subChoice != 'f');
                    break;
                case 2:
                    do
                    {
                        System.out.print("\na. Delete at begin\nb. Delete at end\nc. Delete before an element\nd. Delete after an element\ne. Display\nf. DeleteGreaterThanX\ng. Exit\nEnter your choice: ");
                        subChoice = scanner.next().charAt(0);
                        switch (subChoice)
                        {
                            case 'a':
                                list.delBeg();
                                list.display();
                                break;
                            case 'b':
                                list.delEnd();
                                list.display();
                                break;
                            case 'c':
                                System.out.print("Enter the data before which deletion will take place: ");
                                item = scanner.nextInt();
                                list.delBefore(item);
                                list.display();
                                break;
                            case 'd':
                                System.out.print("Enter the data after which deletion will take place: ");
                                item = scanner.nextInt();
                                list.delAfter(item);
                                list.display();
                                break;
                            case 'e':
                                list.display();
                                break;
                            case 'f':
                                System.out.print("Enter the value: ");
                                X = scanner.nextInt();
                                list.deleteGreaterThanX(X);
                                list.display();
                                break;
                        }
                    } while (subChoice != 'g');
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    list.reverse();
                    list.display();
                    break;
            }
        } while (choice != 5);
        scanner.close();
    }
}
