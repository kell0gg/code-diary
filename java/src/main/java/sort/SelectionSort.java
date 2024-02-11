package sort;

public class SelectionSort {
    public void sort(int[] arr) {
        /*
         * 0. 정렬되지 않은 부분에서 가장 작은 요소를 찾음
         * 1. 가장 작은 요소의 값과 현재 위치의 값을 바꿈
         * 2. unstable 정렬 알고리즘임, [1, 3, 3, 2] 이 있다면 처음 삽입할 때 첫 번째 3와 두 번째 3의 순서가 바뀜
         */
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int currentIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[currentIdx] > arr[j]) {
                    currentIdx = j;
                }
            }

            // swap
            int tmp = arr[i];
            arr[i] = arr[currentIdx];
            arr[currentIdx] = tmp;
        }
    }
}
