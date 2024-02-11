package sort;

public class QuickSort {
    public void sort(int[] arr) {
        /*
         * 0. unstable 정렬 알고리즘임
         * 1. 최악의 경우 시간 복잡도는 O(N^2)
         * 2. merge sort 랑 다르게 추가적으로 memory 를 더 안씀
         */
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            // pivot 보다 작은 값은 왼쪽으로 옮겨야 함
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        // i+1 에 pivot 을 위치시킴, start 부터 i 까지는 pivot 보다 작음
        int tmp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = tmp;

        return i + 1;
    }
}
