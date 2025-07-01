import java.util.Scanner;

class InsertionSort 
{
    public static void insertionSort(int[] a, int n) 
    {
        int i,j,temp;
        for(i=1;i<n;i++)
        {
            temp=a[i];
            j=i-1;
            while(j>=0 && temp<a[j])
            {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temp;
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

        insertionSort(arr, n);

        System.out.println("Sorted array:");
        for (int num : arr) 
            System.out.print(num + " ");

        scanner.close();
    }
}