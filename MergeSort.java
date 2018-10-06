import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    void merge(int arr[], int left, int mid, int right) {
        int length1 = mid - left + 1;
        int length2 = right - mid;

        int L[] = new int[length1];
        int R[] = new int[length2];

        for (int i = 0; i < length1; ++i) L[i] = arr[left + i];
        for (int j = 0; j < length2; ++j) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < length1 && j < length2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < length1) {
            arr[k++] = L[i++];
        }
        while (j < length2) {
            arr[k++] = R[j++];
        }
    }
}