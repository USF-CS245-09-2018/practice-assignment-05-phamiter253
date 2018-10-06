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

    public void merge(int arr[], int leftIndex, int mid, int rightIndex) {
        int length1 = mid - leftIndex + 1;
        int length2 = rightIndex - mid;

        int left[] = new int[length1];
        int right[] = new int[length2];

        for (int i = 0; i < length1; ++i) left[i] = arr[leftIndex + i];
        for (int j = 0; j < length2; ++j) right[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = leftIndex;
        while (i < length1 && j < length2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < length1) {
            arr[k++] = left[i++];
        }
        while (j < length2) {
            arr[k++] = right[j++];
        }
    }
}