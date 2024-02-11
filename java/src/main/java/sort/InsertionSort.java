package sort;

public class InsertionSort {
    public void sort(int[] arr) {
        /*
         * 0. stable 정렬 알고리즘임
         * 1. 거의 정렬된 데이터라면 효율이 좋음
         * 2. 정렬된 부분, 정렬되지 않은 부분으로 나눔
         * 3. 정렬되지 않은 첫 번째 값을 선택하고, 이를 정렬된 부분의 적절한 위치에 삽입시킴 (unsorted subarray => sorted subarray 에 적절히 삽입)
         */
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 정렬되지 않은 배열의 첫 번째 값을 선택
            int key = arr[i];

            // 정렬된 subarray 의 끝 index
            int j = i - 1;

            /*
             * 0. 정렬되지 않은 배열의 첫 번째 값보다 클 경우, 한 칸씩 뒤로 이동시킨다고 생각하면 됨
             * 1. [0, 1, 4, 5], [3, 2]
             * 2. key 는 3, j = 3
             * 3. j = 4 의 위치에 5 를 이동시킴 (한 칸 뒤로 이동), j 는 2이 됨
             * 4. j = 3 의 위치에 4 를 이동시킴 (한 칸 뒤로 이동), j 는 1이 됨
             * 5. 1 < 3 이고, 정렬된 subarray 이므로, 더 이상 볼 필요는 없음
             * 7. 적절한 위치를 찾았으니 idx=2 (j+1) 의 위치에 3 을 이동시킴 [0, 1, 3, 4, 5], [2]
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

        }
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* key보다 큰 arr[j]를 한 칸씩 뒤로 이동 */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
