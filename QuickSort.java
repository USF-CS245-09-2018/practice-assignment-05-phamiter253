public class QuickSort implements SortingAlgorithm{
    public void sort(int [] a){
        quickSort(a, 0, a.length-1);
    }

    public void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p-1);
            quickSort(arr, p+1, right);
        }
    }

    int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j=left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;

        return i+1;
    }
}
