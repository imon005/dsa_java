import java.util.Scanner;

class Pair 
{
    int max;
    int min;
}

public class MaxMinDivCon 
{
    public static Pair maxMinDivCon(int[] a, int low, int high) 
    {
        Pair result = new Pair();
        Pair left = new Pair();
        Pair right = new Pair();

        if (low == high) 
        {
            result.max = a[low];
            result.min = a[low];
            return result;
        }

        if (high == low + 1) 
        {
            if (a[low] < a[high]) 
            {
                result.max = a[high];
                result.min = a[low];
            } 
            else 
            {
                result.max = a[low];
                result.min = a[high];
            }
            return result;
        }

        int mid = (low + high) / 2;
        left = maxMinDivCon(a, low, mid);
        right = maxMinDivCon(a, mid + 1, high);

        result.max = Math.max(left.max, right.max);
        result.min = Math.min(left.min, right.min);
        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[50];

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) 
        {
            System.out.print("arr[" + (i + 1) + "] = ");
            a[i] = sc.nextInt();
        }

        System.out.println("The array:");
        for (int i = 0; i < n; i++) 
        {
            System.out.print(a[i] + " ");
        }

        Pair result = maxMinDivCon(a, 0, n - 1);
        System.out.println("\nMaximum element = " + result.max);
        System.out.println("Minimum element = " + result.min);

        sc.close();
    }
}

/*
Feature | Normal Method | Divide & Conquer Method
Total Comparisons | 2(n - 1) | ~1.5n - 2 (fewer)
Approach | Iterative | Recursive (or stack-based)
Code Complexity | Simple | Slightly complex
Best for | Small arrays | Large datasets or recursion practice
Space Complexity | O(1) | O(log n) due to recursion stack
*/
