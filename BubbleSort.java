import java.util.Scanner;

class BubbleSort 
{
    public static void bubbleSort(int[] a, int n) 
    {
        int i, j, temp;
        boolean flag;
        for (i = 0; i < n - 1; i++) 
        {
            flag = false;
            for (j = 0; j < n - 1 - i; j++) 
            {
                if (a[j] > a[j + 1]) 
                {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) 
                return;
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) 
            arr[i] = scanner.nextInt();

        bubbleSort(arr, n);

        System.out.println("Sorted array:");
        for (int num : arr) 
            System.out.print(num + " ");

        scanner.close();
    }
}

