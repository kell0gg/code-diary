package sort;

public class MergeSort {

    public void sort(int[] arr) {
        /*
         * 0. 배열 나누는 시간 logN, 배열 병합하는 시간 N => O(NlogN)
         * 1. stable 정렬 알고리즘임, 같은 값을 가진 요소의 순서가 변경되지 않음
         */
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // (left + right) / 2 로 구하면 left + right 가 int 범위를 벗어나는 경우가 발생할 수 있음
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private void merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0; // left sub arr idx
        int j = 0; // right sub arr idx
        int k = left; // origin arr idx

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // 남은 요소 있으면 처리
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
