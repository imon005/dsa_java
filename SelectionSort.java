import java.util.Scanner;

class SelectionSort 
{
    public static void selectionSort(int[] a, int n) 
    {
        int i,j,mindex,t;
        for(i=0;i<n-1;i++)
        {
            mindex=i;
            for(j=i+1;j<n;j++)
            {
                if(a[j]<a[mindex])
                    mindex=j;
            }
            if(mindex!=i)
            {
                t=a[mindex];
                a[mindex]=a[i];
                a[i]=t;
            }
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

        selectionSort(arr, n);

        System.out.println("Sorted array:");
        for (int num : arr) 
            System.out.print(num + " ");

        scanner.close();
    }
}
