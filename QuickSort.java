import java.util.Scanner;

class QuickSort
{
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        if(low < high)
        {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    static int partition(int arr[], int low, int high)
    {
        int pos = low;
        boolean flag = true;
    
        while (flag)
        {
            for (int i = high; i > pos; i--)
            {
                if (arr[i] < arr[pos])
                {
                    int temp = arr[i];
                    arr[i] = arr[pos];
                    arr[pos] = temp;
                    pos = i;
                    flag = true;
                    break;
                }
                flag = false;
            }
    
            if (flag)
            {
                for (int i = low; i < pos; i++)
                {
                    if (arr[i] > arr[pos])
                    {
                        int temp = arr[i];
                        arr[i] = arr[pos];
                        arr[pos] = temp;
                        pos = i;
                        flag = true;
                        break;
                    }
                    flag = false;
                }
            }
        }
    
        return pos;
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

        quickSort(arr, 0, n-1);

        System.out.println("Sorted array:");
        for (int num : arr) 
            System.out.print(num + " ");

        scanner.close();
    }
}
