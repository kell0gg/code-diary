package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;


class SortTest {
    SelectionSort selectionSort = new SelectionSort();
    BubbleSort bubbleSort = new BubbleSort();
    MergeSort mergeSort = new MergeSort();
    QuickSort quickSort = new QuickSort();
    InsertionSort insertionSort = new InsertionSort();

    int[] sortedArr = {1, 2, 3, 4, 5};

    @Test
    void selectionSort() {
        int[] arr = {3, 4, 1, 5, 2};
        selectionSort.sort(arr);
        printArr(arr);
        Assertions.assertArrayEquals(sortedArr, arr);
    }

    @Test
    void bubbleSort() {
        int[] arr = {3, 4, 1, 5, 2};
        bubbleSort.sort(arr);
        printArr(arr);
        Assertions.assertArrayEquals(sortedArr, arr);
    }

    @Test
    void mergeSort() {
        int[] arr = {3, 4, 1, 5, 2};
        mergeSort.sort(arr);
        printArr(arr);
        Assertions.assertArrayEquals(sortedArr, arr);
    }

    @Test
    void quickSort() {
        int[] arr = {3, 4, 1, 5, 2};
        quickSort.sort(arr);
        printArr(arr);
        Assertions.assertArrayEquals(sortedArr, arr);
    }

    @Test
    void insertionSort() {
        int[] arr = {3, 4, 1, 5, 2};

        /*
         * insertionSort.sort(arr);
         * printArr(arr);
         * Assertions.assertArrayEquals(sortedArr, arr);
         */

        // 중복된 부분이 보기 불편해지면 consumer 를 써서 처리해도 될 것 같음   
        // test(arr, consumerArr -> new InsertionSort().sort(consumerArr));
        test(arr, new Consumer<int[]>() {
            @Override
            public void accept(int[] consumerArr) {
                new InsertionSort().sort(consumerArr);
            }
        });
    }

    private void test(int[] originArr, Consumer<int[]> sort) {
        int[] arr = Arrays.copyOf(originArr, originArr.length);
        sort.accept(arr);
        printArr(arr);
        Assertions.assertArrayEquals(sortedArr, arr);
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}