import java.util.Scanner;

class Node<T>
{
    T data;
    Node<T> next;

    Node(T data)
    {
        this.data = data;
        this.next = null;
    }
}

class SinglyCircularLinkedList<T>
{
    private Node<T> head;

    public void create(T item)
    {
        Node<T> newNode = new Node<>(item);
        if (head == null)
        {
            head = newNode;
            newNode.next = head;
        }
        else
        {
            Node<T> temp = head;
            while (temp.next != head)
            {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public boolean check(T item)
    {
        if (head == null) return false;
        Node<T> current = head;
        do
        {
            if (current.data.equals(item))
            {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    public void insertEnd(T item)
    {
        Node<T> newNode = new Node<>(item);
        if (head == null)
        {
            create(item);
        }
        else
        {
            Node<T> temp = head;
            while (temp.next != head)
            {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void insertBeg(T item)
    {
        Node<T> newNode = new Node<>(item);
        if (head == null)
        {
            create(item);
        }
        else
        {
            Node<T> temp = head;
            while (temp.next != head)
            {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAfter(T newItem, T item)
    {
        if (head == null) return;
        if (!check(item))
        {
            System.out.println(item + " is not present");
            return;
        }
        Node<T> newNode = new Node<>(newItem);
        Node<T> current = head;
        while (!current.data.equals(item))
        {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void insertBefore(T newItem, T item)
    {
        if (head == null) return;
        if (!check(item))
        {
            System.out.println(item + " is not present");
            return;
        }
        Node<T> newNode = new Node<>(newItem);
        if (head.data.equals(item))
        {
            insertBeg(newItem);
            return;
        }
        Node<T> current = head;
        while (!current.next.data.equals(item))
        {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void delBeg()
    {
        if (head == null) return;
        if (head.next == head)
        {
            head = null;
            return;
        }
        Node<T> temp = head;
        while (temp.next != head)
        {
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
    }

    public void delEnd()
    {
        if (head == null) return;
        if (head.next == head)
        {
            head = null;
            return;
        }
        Node<T> current = head;
        while (current.next.next != head)
        {
            current = current.next;
        }
        current.next = head;
    }

    public void delAfter(T item)
    {
        if (head == null) return;
        if (!check(item))
        {
            System.out.println(item + " is not present");
            return;
        }
        Node<T> current = head;
        while (!current.data.equals(item))
        {
            current = current.next;
        }
        if (current.next == head)
        {
            current.next = head.next;
            head = head.next;
            return;
        }
        Node<T> delNode = current.next;
        current.next = delNode.next;
    }

    public void delBefore(T item)
    {
        if (head == null) return;
        if (!check(item)) {
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
        while (!current.next.next.data.equals(item))
        {
            current = current.next;
        }
        Node<T> delNode = current.next;
        current.next = delNode.next;
    }

    public void display()
    {
        if (head == null)
        {
            System.out.println("Empty list");
            return;
        }
        System.out.print("List: ");
        Node<T> current = head;
        do
        {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

public class SinglyCircularLinkedListMain
{
    public static void main(String[] args)
    {
        SinglyCircularLinkedList<Integer> list = new SinglyCircularLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do
        {
            System.out.print("\n1. Insert\n2. Delete\n3. Display\n4. Exit\nEnter your choice: ");
            choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    char insertChoice;
                    do {
                        System.out.print("\na. Insert at begin\nb. Insert at end\nc. Insert before an element\nd. Insert after an element\ne. Display\nf. Exit\nEnter your choice: ");
                        insertChoice = scanner.next().charAt(0);
                        switch (insertChoice)
                        {
                            case 'a':
                                System.out.print("Enter the data: ");
                                int data = scanner.nextInt();
                                list.insertBeg(data);
                                list.display();
                                break;
                            case 'b':
                                System.out.print("Enter the data: ");
                                data = scanner.nextInt();
                                list.insertEnd(data);
                                list.display();
                                break;
                            case 'c':
                                System.out.print("Enter the data: ");
                                data = scanner.nextInt();
                                System.out.print("Enter the data before which " + data + " will be inserted: ");
                                int itemBefore = scanner.nextInt();
                                list.insertBefore(data, itemBefore);
                                list.display();
                                break;
                            case 'd':
                                System.out.print("Enter the data: ");
                                data = scanner.nextInt();
                                System.out.print("Enter the data after which " + data + " will be inserted: ");
                                int itemAfter = scanner.nextInt();
                                list.insertAfter(data, itemAfter);
                                list.display();
                                break;
                            case 'e':
                                list.display();
                                break;
                        }
                    } while (insertChoice != 'f');
                    break;
                case 2:
                    char deleteChoice;
                    do
                    {
                        System.out.print("\na. Delete at begin\nb. Delete at end\nc. Delete before an element\nd. Delete after an element\ne. Display\nf. Exit\nEnter your choice: ");
                        deleteChoice = scanner.next().charAt(0);
                        switch (deleteChoice)
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
                                int itemBeforeDel = scanner.nextInt();
                                list.delBefore(itemBeforeDel);
                                list.display();
                                break;
                            case 'd':
                                System.out.print("Enter the data after which deletion will take place: ");
                                int itemAfterDel = scanner.nextInt();
                                list.delAfter(itemAfterDel);
                                list.display();
                                break;
                            case 'e':
                                list.display();
                                break;
                        }
                    } while (deleteChoice != 'f');
                    break;
                case 3:
                    list.display();
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }
}

