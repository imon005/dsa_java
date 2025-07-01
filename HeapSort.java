import java.util.Scanner;

class HeapSort 
{
    public static void shiftDown(int[] arr, int root, int bottom) 
    {
        int flag = 1, maxChild, temp;

        while ((root * 2 + 1 <= bottom) && (flag == 1)) 
        {
            if (root * 2 + 1 == bottom) 
                maxChild = root * 2 + 1;
            else if (arr[root * 2 + 1] > arr[root * 2 + 2]) 
                maxChild = root * 2 + 1;
            else 
                maxChild = root * 2 + 2;

            if (arr[root] < arr[maxChild]) 
            {
                temp = arr[root];
                arr[root] = arr[maxChild];
                arr[maxChild] = temp;
                root = maxChild;
            } 
            else 
                flag = 0;
        }
    }

    public static void heapSort(int[] arr, int n) 
    {
        int temp;

        for (int i = (n / 2) - 1; i >= 0; i--) // (n/2)-1 is the first non-leaf node
            shiftDown(arr, i, n - 1);

        for (int i = n - 1; i >= 1; i--) 
        {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            shiftDown(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("\nEnter the elements:");
        for (int i = 0; i < n; i++) 
        {
            System.out.print("arr[" + (i + 1) + "] = ");
            arr[i] = scanner.nextInt();
        }

        heapSort(arr, n);

        System.out.println("\nThe sorted array:");
        for (int num : arr) 
            System.out.printf("%5d", num);

        scanner.close();
    }
}

