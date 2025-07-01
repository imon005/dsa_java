import java.util.Scanner;

class BinarySearch 
{
    public static int binarySearch(int[] arr, int n, int item) 
    {
        int low = 0, high = n - 1, mid;
        while (low <= high) 
        {
            mid = (low + high) / 2;
            if (arr[mid] == item) 
                return mid;
            else if (item > arr[mid]) 
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return -1;
    }

    public static int recBinarySearch(int[] arr, int item, int low, int high) 
    {
        if (low <= high) 
        {
            int mid = (low + high) / 2;
            if (arr[mid] == item) 
                return mid;
            else if (item > arr[mid]) 
                return recBinarySearch(arr, item, mid + 1, high);
            else 
                return recBinarySearch(arr, item, low, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the sorted elements:");
        for (int i = 0; i < n; i++) 
            arr[i] = scanner.nextInt();

        System.out.print("Enter the item to search: ");
        int item = scanner.nextInt();

        int result = binarySearch(arr, n, item);
        if (result != -1) 
            System.out.println("Item found at index (Iterative): " + result);
        else 
            System.out.println("Item not found (Iterative)");

        result = recBinarySearch(arr, item, 0, n - 1);
        if (result != -1) 
            System.out.println("Item found at index (Recursive): " + result);
        else 
            System.out.println("Item not found (Recursive)");

        scanner.close();
    }
}

