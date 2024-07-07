package com.sorting.AdvancedSorting;

import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithms {

    public static void heapSort(List<Student> items) {
        int n = items.size();
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(items, n, i);
        for (int i = n - 1; i >= 0; i--) {
            Student temp = items.get(0);
            items.set(0, items.get(i));
            items.set(i, temp);
            heapify(items, i, 0);
        }
    }

    private static void heapify(List<Student> items, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && items.get(left).getName().compareToIgnoreCase(items.get(largest).getName()) > 0)
            largest = left;

        if (right < n && items.get(right).getName().compareToIgnoreCase(items.get(largest).getName()) > 0)
            largest = right;

        if (largest != i) {
            Student swap = items.get(i);
            items.set(i, items.get(largest));
            items.set(largest, swap);
            heapify(items, n, largest);
        }
    }

    public static void quickSort(List<Student> items, int low, int high) {
        if (low < high) {
            int pi = partition(items, low, high);
            quickSort(items, low, pi - 1);
            quickSort(items, pi + 1, high);
        }
    }

    private static int partition(List<Student> items, int low, int high) {
        String pivot = items.get(high).getName();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (items.get(j).getName().compareToIgnoreCase(pivot) < 0) {
                i++;
                Student temp = items.get(i);
                items.set(i, items.get(j));
                items.set(j, temp);
            }
        }
        Student temp = items.get(i + 1);
        items.set(i + 1, items.get(high));
        items.set(high, temp);
        return i + 1;
    }

    public static void mergeSort(List<Student> items, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(items, l, m);
            mergeSort(items, m + 1, r);
            merge(items, l, m, r);
        }
    }

    private static void merge(List<Student> items, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        List<Student> L = new ArrayList<>();
        List<Student> R = new ArrayList<>();

        for (int i = 0; i < n1; ++i)
            L.add(items.get(l + i));
        for (int j = 0; j < n2; ++j)
            R.add(items.get(m + 1 + j));

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i).getName().compareToIgnoreCase(R.get(j).getName()) <= 0) {
                items.set(k, L.get(i));
                i++;
            } else {
                items.set(k, R.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            items.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            items.set(k, R.get(j));
            j++;
            k++;
        }
    }

    public static void radixSort(List<Student> items) {
        int maxLength = items.stream().mapToInt(item -> item.getName().length()).max().orElse(0);
        for (int exp = 1; maxLength / exp > 0; exp *= 10)
            countingSort(items, exp);
    }

    private static void countingSort(List<Student> items, int exp) {
        int n = items.size();
        List<Student> output = new ArrayList<>(n);
        int[] count = new int[256];

        for (int i = 0; i < 256; i++)
            count[i] = 0;

        for (int i = 0; i < n; i++) {
            int index = (items.get(i).getName().length() / exp) % 256;
            count[index]++;
        }

        for (int i = 1; i < 256; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            int index = (items.get(i).getName().length() / exp) % 256;
            output.set(count[index] - 1, items.get(i));
            count[index]--;
        }

        for (int i = 0; i < n; i++)
            items.set(i, output.get(i));
    }

    public static void bucketSort(List<Student> items, int maxVal) {
        int n = items.size();
        if (n <= 0)
            return;

        List<Student>[] bucket = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            bucket[i] = new ArrayList<Student>();
        }

        for (int i = 0; i < n; i++) {
            int index = items.get(i).getName().length() * n / (maxVal + 1);
            bucket[index].add(items.get(i));
        }

        for (int i = 0; i < n; i++) {
            quickSort(bucket[i], 0, bucket[i].size() - 1);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                items.set(index++, bucket[i].get(j));
            }
        }
    }
}
