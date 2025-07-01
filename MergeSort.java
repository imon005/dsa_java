import java.util.Scanner;

class MergeSort
{
    static void mergeSort(int arr[], int l, int r)
    {
        int temp[] = new int[arr.length];
        mergeSort(arr, l, r, temp);
    }
    
    static void mergeSort(int arr[], int l, int r, int temp[])
    {
        if(l<r)
        {
            int mid = (l+r)/2;
            mergeSort(arr, l, mid, temp);
            mergeSort(arr, mid+1, r, temp);
            merge(arr, l, mid, r, temp);
        }
    }
    
    static void merge(int arr[], int lb, int mid, int ub, int temp[])
    {
        int i=lb, j=mid+1, k=lb;
        
        while(i<=mid && j<=ub)
        {
            if(arr[i] < arr[j])
            {
                temp[k] = arr[i];
                i++;
            }
            else
            {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        
        while(i<=mid)
        {
            temp[k] = arr[i];
            i++;
            k++;
        }
        
        while(j<=ub)
        {
            temp[k] = arr[j];
            j++;
            k++;
        }
        
        for(k=lb; k<=ub; k++)
        {
            arr[k] = temp[k];
        }
        
        //System.arraycopy(temp, lb, arr, lb, ub - lb + 1); //reduces runtime
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

        mergeSort(arr, 0, n-1);

        System.out.println("Sorted array:");
        for (int num : arr) 
            System.out.print(num + " ");

        scanner.close();
    }
}
